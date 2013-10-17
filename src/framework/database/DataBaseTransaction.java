package framework.database;

import java.sql.Connection;

public class DataBaseTransaction {

    public void begingTransaction() {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        context.set(conn);
    }
    
    public void endTransaction() {
        commit( getConnectionFromContext() );
        releaseTransaction();
    }
    
    public void releaseTransaction() {
        Connection conn = getConnectionFromContext();
        release(conn);
        context.remove();
    }
 
    public void rollbackTransaction() {
        try {
            Connection conn = getConnectionFromContext();
            rollback(conn);
            release(conn);
            context.remove();
        } catch (SQLException e) {
        }
    }        

}
