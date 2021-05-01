package database;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
    create a builder to build object 
 */
interface ModelBuilder<T> {

    T build(ResultSet rs) throws SQLException;
}
