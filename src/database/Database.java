package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import basic.Account;
import javax.swing.JOptionPane;

/**
 * abstract class for database
 *
 * @author Liew Chun Kit
 */
public abstract class Database {

    /**
     * database Connection object
     *
     */
    protected Connection c;
    /**
     * name of database use
     *
     */
    private String dbName;
    protected Logger logger;//use to log message for system

    /**
     * database about, will initialize the database if empty
     * 
     */
    public Database(String dbName) {
        // get the logger
        logger = Logger.getLogger(getClass().getName());
        this.dbName = dbName;
        if (open()) {
            createDatabase();
        }
    }

    public abstract Account getAccount(String username);

    protected abstract boolean validatePassword(Account account, String password);

    protected abstract ArrayList<Table> createTables();

    protected abstract boolean seed();

    /**
     * login into database and get account if valid
     *
     * @author Liew Chun Kit
     * @return account object that login success, null means fail login
     */
    public Account login(String username, String password) {
        Account account = getAccount(username);

        if (validatePassword(account, password)) {
            return account;
        }

        return null;
    }

    /**
     * connect to database, using database password and username
     *
     * @return true if connect success
     */
    protected boolean open() {

        try {
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            String username = "root";
            String password = "123456";
            c = DriverManager.getConnection(url, username, password);
            if (c != null) {
                return true;
            }
        } catch (SQLException e) {
            logger.severe("DB Could not open: SQLException");
            JOptionPane.showMessageDialog(null, "Database Unable Connect!!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }

    /**
     * close database and null it
     *
     *
     * @return true if disconnect success
     */
    protected boolean close() {
        try {
            if (c != null) {
                c.close();
                c = null;
                logger.info("Closed connection");
            }
        } catch (SQLException e) {
            logger.warning("DB Connection failed to close");
            return false;
        }
        return true;
    }

    /**
     * insert data into table database
     *
     *
     */
    protected boolean insert(String table, String... values) {
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i].replaceAll("'", "''");
            values[i] = "'" + values[i] + "'";
        }
        String valueString = String.join(",", values);
        String query = "INSERT INTO " + table + " VALUES(" + valueString + ")";
        logger.fine("Executing query: " + query);

        try {
            Statement stm = c.createStatement();
            stm.execute(query);
            return true;
        } catch (SQLException e) {
            logger.warning("SQL Exception: " + e.toString());
            return false;
        }
    }

    /**
     * statement that perform in database
     *
     * @return object found in database
     */
    protected <T> ArrayList<T> query(String sql, ModelBuilder<T> builder) {
        ArrayList<T> resultArray = new ArrayList<T>();

        try (Statement stm = c.createStatement()) {
            try (ResultSet rs = stm.executeQuery(sql)) {
                while (rs.next()) {// there is a result return from database
                    resultArray.add(builder.build(rs));
                }
            }
        } catch (SQLException e) {
            logger.warning("Query failed :" + e);
        }
        return resultArray;
    }

    /**
     * only return the first result found in database
     *
     *
     */
    protected <T> T querySingle(String sql, ModelBuilder<T> builder) {
        ArrayList<T> resultArray = query(sql, builder);

        if (resultArray != null && resultArray.size() > 0) {
            return resultArray.get(0);
        }

        return null;
    }

    /**
     * create data into database if empty, will check every time when login to
     * database
     *
     *
     */
    private void createDatabase() {
        try (Statement stm = c.createStatement()) {
            //check empty database
            try (ResultSet rs = stm.executeQuery("SELECT count(*) AS TOTALNUMBEROFTABLES"
                    + "    FROM INFORMATION_SCHEMA.TABLES"
                    + "    WHERE TABLE_SCHEMA = 'gbsdb';")) {
                if (rs.next() && rs.getInt(1) == 0) {
                    logger.info("Database empty, initialising tables");
                    insertTables(createTables());
                    logger.info("Seeding database");
                    seed();
                }
            }
        } catch (Exception e) {
            logger.severe(e.toString());
            System.exit(0);
        }
    }

    /**
     * insert table into database
     *
     *
     */
    private void insertTables(ArrayList<Table> tables) {
        try (Statement stm = c.createStatement()) {
            for (Table table : tables) {//create table one by one
                logger.fine("Creating table: " + table);
                stm.execute(table.toString());
            }
        } catch (SQLException e) {
            logger.severe("SQL Exception in table creation: " + e);
        }
    }
}
