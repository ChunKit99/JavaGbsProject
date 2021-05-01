package database;

import java.util.ArrayList;

class Table {

    public final String name;//table name
    private ArrayList<String> columns;
    private String primaryKey;
    private ArrayList<String> foreignKey;

    /**
     * create table base on name given
     */
    protected Table(String name) {
        this.name = name;//set the name of table need to create
        columns = new ArrayList<String>();
        foreignKey = new ArrayList<String>();
    }

    /**
     * add the column base on name and type, example name = username, type =
     * varchar
     */
    void addColumn(String name, String type) {
        columns.add("`" + name + "` " + type);
    }

    /**
     * set primary key
     */
    void setPrimary(String columnName) {
        primaryKey = "PRIMARY KEY (`" + columnName + "`)";
    }

    /**
     * add foreign key, example booking username and customer username
     *
     * @param columnName column that become FK
     * @param reference column come from where
     *
     */
    void addForeignKey(String columnName, String reference) {
        foreignKey.add("FOREIGN KEY (`" + columnName + "`) REFERENCES " + reference);
    }

    /**
     * returns table statement. use for creating
     *
     */
    @Override
    public String toString() {
        String colString = String.join(", ", columns);//combine all the column name and data type
        String fkString = String.join(", ", foreignKey);//combine set foreignkey statement
        String tableString;//statement sql need to do
        if (primaryKey != null) {//there is a pk
            tableString = colString + ", " + primaryKey;
        } else {
            tableString = colString;
        }
        // only join fk if there are any
        if (!fkString.equals("")) {
            tableString += ", " + fkString;
        }

        return "CREATE TABLE `" + name + "` (" + tableString + ")";
    }
}
