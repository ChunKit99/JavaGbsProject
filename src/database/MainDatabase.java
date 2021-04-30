package database;

import basic.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.util.converter.LocalDateStringConverter;

/**
 * Main Database, for store data in GBS
 *
 * @author Liew Chun Kit, TYL, KC, OHG, LWC
 */
public class MainDatabase extends Database {

    public MainDatabase(String dbName) {
        super(dbName);
    }

    /**
     * initialize create admin account, and some example data
     *
     * @author Liew Chun Kit
     * @return true if success create
     *
     */
    @Override
    protected boolean seed() {
        LocalDate dateToday = LocalDate.now();
        insert(new Customer("chunkit", "liew123", "Liew Chun Kit", "liewchunkit@email.com", "0112345678", "Male"));//when pass to insert, tablename,  username, password, name, email, phonenumber, gender, type.
        insert(new Customer("angie", "ong123", "Ong Hui Gie", "onghuigie@email.com", "0112334444", "Female"));
        insert(new Customer("woeichi", "liong123", "Liong Woei Chi", "liongwoeichi@email.com", "0112335555", "Female"));
        insert(new Customer("kc", "kc123", "Kong Choon", "kingchoon@email.com", "0112332222", "Male"));
        insert(new Customer("yongliang", "tua123", "Tua Yong Liang", "tuayongliang@email.com", "0112336666", "Male"));
        insert(new GymRoom(1, "Room 1", "Gold"));//when pass ot insert, tablename, id, room name, level
        insert(new GymRoom(2, "Room 2", "Silver"));
        insert(new GymRoom(3, "Room 3", "Bronze"));
        //insert(new TimeSlot(1, "1000", "1200"));//when pass ot insert, tablename, id, timestart, timeend
        //insert(new BookingGym(1, "chunkit", 1, 1, dateToday));//when pass ot insert, tablename, id, username, id, id, datebook;
        insert("TimeSlot", Integer.toString(1), "1000", "1200");
        insert("TimeSlot", Integer.toString(2), "1200", "1400");
        insert("TimeSlot", Integer.toString(3), "1400", "1600");
        insert("BookingGym", Integer.toString(1), "chunkit", Integer.toString(1), Integer.toString(2), dateToday.toString());//dateToday.toString() means covert date into string
        insert("BookingGym", Integer.toString(2), "angie", Integer.toString(2), Integer.toString(3), dateToday.toString());
        insert("BookingGym", Integer.toString(3), "woeichi", Integer.toString(3), Integer.toString(1), dateToday.toString());
        insert("BookingGym", Integer.toString(4), "kc", Integer.toString(2), Integer.toString(1), dateToday.toString());
        insert("BookingGym", Integer.toString(5), "yongliang", Integer.toString(1), Integer.toString(1), dateToday.toString());
        return insert(new Admin("Admin", "Admin"));//when pass to insert, tablename, username, password, type.
    }

    /**
     * create table into database
     *
     * @author Liew Chun Kit
     * @return table that need to create in database
     */
    @Override
    protected ArrayList<Table> createTables() {
        ArrayList<Table> tables = new ArrayList<Table>();

        Table customer = new Table("Customer");
        customer.addColumn("Username", "varchar(30)");
        customer.addColumn("Password", "varchar(255)");
        customer.addColumn("Name", "varchar(255)");
        customer.addColumn("Email", "varchar(255)");
        customer.addColumn("PhoneNumber", "varchar(15)");
        customer.addColumn("Gender", "varchar(10)");
        customer.addColumn("Type", "varchar(13)");
        customer.setPrimary("Username");
        tables.add(customer);

        Table admin = new Table("Admin");
        admin.addColumn("Username", "varchar(30)");
        admin.addColumn("Password", "varchar(255)");
        admin.addColumn("Type", "varchar(13)");
        admin.setPrimary("Username");
        tables.add(admin);

        Table timeSlot = new Table("TimeSlot");
        timeSlot.addColumn("TimeID", "int");
        timeSlot.addColumn("TimeStart", "varchar(30)");
        timeSlot.addColumn("TimeEnd", "varchar(30)");
        timeSlot.setPrimary("TimeID");
        tables.add(timeSlot);

        Table gymRoom = new Table("GymRoom");
        gymRoom.addColumn("GymID", "int");
        gymRoom.addColumn("Name", "varchar(30)");
        gymRoom.addColumn("Level", "varchar(30)");
        gymRoom.setPrimary("GymID");
        tables.add(gymRoom);

        Table bookingGym = new Table("BookingGym");
        bookingGym.addColumn("BookID", "int");
        bookingGym.addColumn("Customer", "varchar(30)");
        bookingGym.addColumn("GymID", "int");
        bookingGym.addColumn("TimeID", "int");
        bookingGym.addColumn("BookDate", "date");
        bookingGym.setPrimary("BookID");
        bookingGym.addForeignKey("Customer", "Customer(Username)");
        bookingGym.addForeignKey("GymID", "GymRoom(GymID)");
        bookingGym.addForeignKey("TimeID", "TimeSlot(TimeID)");
        tables.add(bookingGym);
        return tables;
    }

    /**
     * return class for know admin or customer base on username, if null is not
     * exist
     *
     * @author Liew Chun Kit
     */
    private Class<? extends Account> validateUsername(String username, String typeUser) {
        String sql = String.format("SELECT Username, Type FROM " + typeUser + " WHERE Username = '%s'", username);

        try (Statement stmt = c.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    String type = rs.getString("Type");
                    logger.info("Found " + username + " (" + type + ")");
                    if (type.equals("Admin")) {
                        return Admin.class;
                    } else if (type.equals("Customer")) {
                        return Customer.class;
                    }
                }
            }
        } catch (SQLException e) {
            logger.warning(e.toString());
        }

        return null;
    }

    /**
     * check password from database, if valid will true
     *
     * @author Liew Chun Kit
     * @param account Account object
     * @param password to check same with account password or not
     * @return
     */
    @Override
    public boolean validatePassword(Account account, String password) {
        String table;
        if (account instanceof Customer) {
            table = "Customer";
        } else if (account instanceof Admin) {
            table = "Admin";
        } else {
            return false; // if account isn't one of these, exit.
        }
        String sql = String.format("SELECT password FROM %s WHERE username='%s'", table, account.username);

        try (Statement stmt = c.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next() && rs.getString("Password").equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            logger.warning(e.toString());
        }

        return false;
    }

    /**
     * add account(customer) into database
     *
     * @author Liew Chun kit
     * @param account account object that need to add in database
     * @return true if add success
     */
    public boolean addAccount(Account account) {
        //check the username exist
        if (getAccount(account.username, "Customer") == null && getAccount(account.username, "Admin") == null) {
            // not exist, can add
            if (account instanceof Customer) {//only add for customer type
                return insert((Customer) account);
            }
        }

        return false;
    }

    /**
     * Returns a Customer object by it's username get from database
     *
     * @author Liew Chun Kit
     */
    private Customer getCustomer(String username) {
        String sql = String.format("SELECT * FROM Customer WHERE Username = '%s'", username);
        Customer cus = querySingle(sql, new ModelBuilder<Customer>() {
            public Customer build(ResultSet rs) throws SQLException {
                String name = rs.getString("Name");
                String password = rs.getString("Password");
                String email = rs.getString("Email");
                String phone = rs.getString("PhoneNumber");
                String gender = rs.getString("Gender");
                String usr = rs.getString("Username");
                return new Customer(usr, password, name, email, phone, gender);
            }
        });
        return cus;
    }

    /**
     * get Admin from database
     *
     * @author Liew Chun Kit
     */
    private Admin getAdmin(String username) {
        String sql = String.format("SELECT * FROM Admin WHERE Username = '%s'", username);
        Admin a = querySingle(sql, new ModelBuilder<Admin>() {
            public Admin build(ResultSet rs) throws SQLException {
                String password = rs.getString("Password");
                String usr = rs.getString("Username");
                return new Admin(usr, password);
            }
        });
        return a;
    }

    /**
     * return type of the account, null is no this user
     *
     * @author Liew Chun Kit
     * @param username username for search
     * @param typeUser type of user select
     * @return
     *
     */
    @Override
    public Account getAccount(String username, String typeUser) {
        Class<? extends Account> type = validateUsername(username, typeUser);
        if (type != null) {
            if (type.equals(Customer.class)) {
                return getCustomer(username);
            } else if (type.equals(Admin.class)) {
                return getAdmin(username);
            }
            logger.info("Couldn't find account " + username);
        }
        return null;
    }

    /**
     * insert data Admin into database
     *
     * @author Liew Chun Kit
     */
    private boolean insert(Admin a) {
        return insert("Admin", a.username, a.getPassword(), "Admin");
    }

    /**
     * insert data customer into database for data customer(when register)
     *
     * @author Liew Chun Kit
     */
    private boolean insert(Customer c) {
        return insert("Customer", c.username, c.getPassword(), c.getName(), c.getEmail(),
                c.getPhoneNumber(), c.getGender(), "Customer");
    }

    /**
     * change/edit data of Customer in database
     *
     * @author Liew Chun Kit
     * @param cus customer object to update
     * @return true if update success
     */
    public boolean updateCustomer(Customer cus) {
        // update the given service in the db
        try (Statement stmt = c.createStatement()) {
            String sql = String.format("UPDATE Customer SET Name = '%s', Password = '%s', Email = '%s', PhoneNumber = '%s', Gender = '%s' WHERE Username = '%s'",
                    cus.getName(), cus.getPassword(), cus.getEmail(), cus.getPhoneNumber(), cus.getGender(), cus.username);

            if (stmt.executeUpdate(sql) == 1) {
                return true; // only 1 row should be affected.
            }
        } catch (SQLException e) {
            logger.warning(e.toString());
        }
        return false;
    }

    /**
     * delete data of Customer in database
     *
     * @author Liew Chun Kit
     * @param cus customer object to delete
     * @return true if delete success
     */
    public boolean deleteCustomer(Customer cus) {
        try (Statement stmt = c.createStatement()) {
            String sql = String.format("DELETE FROM Customer WHERE Username = '%s'", cus.username);
            if (stmt.executeUpdate(sql) == 1) {
                return true;
            }
        } catch (SQLException e) {
            logger.warning(e.toString());
        }
        return false;
    }

    /**
     * show all data of Customer in database
     *
     * @author Liew Chun Kit
     * @return array list of object customer in database
     */
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> list = new ArrayList<Customer>();

        try (Statement stmt = c.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM Customer")) {
                while (rs.next()) {
                    String pass = rs.getString("Password");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phone = rs.getString("PhoneNumber");
                    String gender = rs.getString("Gender");
                    String username = rs.getString("Username");
                    Customer current = new Customer(username, pass, name, email, phone, gender);
                    list.add(current);
                }
            }

        } catch (SQLException e) {
            logger.warning(e.toString());
        }
        return list;
    }

    /**
     * call insert data
     *
     * @author Liew Chun Kit
     * @param gym gymroom object to delete
     * @return true if add success
     */
    public boolean addGymRoom(GymRoom gym) {
        return insert(gym);
    }

    /**
     * insert data into database
     *
     * @author Liew Chun Kit
     */
    private boolean insert(GymRoom g) {
        return insert("GymRoom", Integer.toString(g.ID), g.getName(), g.getLevel());
    }

    /**
     * create latest id of GymRoom object
     *
     * @author Liew Chun Kit
     * @return gym room object with id only
     */
    public GymRoom buildGymRoom() {
        // find the highest current ID
        int maxID = 0;

        try (Statement stmt = c.createStatement()) {
            try (ResultSet rs = stmt.executeQuery("SELECT MAX(GymID) AS GymID FROM GymRoom")) {
                if (rs.next()) {
                    maxID = rs.getInt("GymID");
                }
            }
        } catch (SQLException e) {
            logger.warning(e.toString());
        }

        return new GymRoom(maxID + 1, "", "");//create gymroom with id only
    }

    /**
     * show example how to get object booking from database
     *
     * @author Liew Chun Kit
     * @param bookID booking id that search
     * @return booking gym object
     */
    public BookingGym getExampleBookingGym(int bookID) {
        String sql = String.format("SELECT * FROM BookingGym WHERE BookID = %d", bookID);
        BookingGym book = querySingle(sql, new ModelBuilder<BookingGym>() {
            public BookingGym build(ResultSet rs) throws SQLException {
                String username = rs.getString("Customer");//customer in database represent username of customer
                int gymID = rs.getInt("GymID");
                int timeID = rs.getInt("TimeID");
                //GymRoom gym = getGymRoom(gymID);
                //TimeSlot time = getTimeSlot(timeID);
                GymRoom gym = createExampleGymRoom(gymID);
                TimeSlot time = createExampleTimeSlot(timeID);
                LocalDate bookDate = rs.getDate("BookDate").toLocalDate();
                return new BookingGym(bookID, username, bookDate, gym, time);
            }
        });
        return book;
    }

    /**
     * show example return a gym room object
     *
     * @author Liew Chun Kit
     */
    private GymRoom createExampleGymRoom(int gymID) {
        return new GymRoom(gymID, "", "");//please do the correct one
    }

    /**
     * show example return a time slot object
     *
     * @author Liew Chun Kit
     */
    private TimeSlot createExampleTimeSlot(int timeID) {
        return new TimeSlot(timeID, "", "");//please do the correct one
    }

    // TYL part start
    /*
    GymRoom about
    add gymroom (LCK do already)
    edit gymroom
    delete gymroom
    show gymroom
     */
    //public boolean updateGymRoom(GymRoom gym)
    //public boolean deleteGymRoom(GymRoom gym)
    //public ArrayList<GymRoom> getAllGymRoom()
    //public GymRoom getGymRoom(int gymID){
    // TYL part end
    // KC part start
    /*
    TimeSlot about
    add TimeSlot
    edit TimeSlot
    delete TimeSlot
    show TimeSlot
     */

    //public boolean addTimeSlot(TimeSlot time)
    //public TimeSlot buildTimeSlot()
    //private boolean insert(TimeSlot t)
    //public boolean updateGymRoom(TimeSlot time)
    //public boolean deleteGymRoom(TimeSlot time)
    //public ArrayList<TimeSlot> getAllTimeSlot()
    //public TimeSlot getTimeSlot(int timeID){
    // KC part end
    // OHG part start
    /*
    add booking
    show customer personal detail
     */
    //public boolean addBookingGym(BookingGym book)
    //public BookingGym buildTimeSlot()
    //private boolean insert(BookingGym book)
    //use only, this method create already!!(to do show customer personal detail)
    //(database code part)
    // (use only)private Customer getCustomer(String username)//for get a customer object given username
    // OHG part end
    // LWC part start
    /*
    edit booking
    delete booking
    show customer booking record(customer menu)
    show all booking record(admin menu)
     */
    //public boolean updateBookingGym(BookingGym book)
    //public boolean deleteBookingGym(BookingGym book)
    //public BookingGym getBookingGym(int bookID)
    //public ArrayList<BookingGym> getAllBookingGym()
    // LWC part end
}
