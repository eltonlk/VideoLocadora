package framework;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueryMapping<T> {
    
    void mapping(ResultSet rset) throws SQLException;
    
}
