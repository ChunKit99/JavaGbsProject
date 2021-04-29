package database;

import java.sql.ResultSet;
import java.sql.SQLException;


interface ModelBuilder<T> {
    T build(ResultSet rs) throws SQLException;
}
