package framework;

import framework.database.DataBaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {

    private static final ThreadLocal<Connection> context = new ThreadLocal<>();
    
    public Connection getConnection() throws IOException, SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        
        return dataBaseConnection.getConnection();
    }
    
    public void begingTransaction() throws SQLException, IOException {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        context.set(conn);
    }
    
    public void endTransaction() throws SQLException {
        commit( getConnectionFromContext() );
        releaseTransaction();
    }
    
    public void releaseTransaction() throws SQLException {
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
   
    public void commit(Connection conn) throws SQLException {
        conn.commit();
    }
    
    public void rollback(Connection conn) throws SQLException {
        if (conn != null) conn.rollback();
    }

    public Connection getConnectionFromContext() throws SQLException {
        Connection conn = context.get();
        
        if ( conn == null ) {
            throw new SQLException("Transação invalida.");
        } else if (conn.isClosed()) {
            throw new SQLException("Transação invalida. Conexção está fechada.");
        }
        
        return conn;
    }

    public int executePreparedUpdateAndReturnGenerateKeys(Connection conn, String query, Object... params) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int id = 01;

        try {
            pstmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            populatePreparedStatement(pstmt, params);

            pstmt.executeUpdate();

            rset = pstmt.getGeneratedKeys();

            if (rset.next()) id = rset.getInt(1);
        } finally {
            release(rset);
            release(pstmt);
        }
        
        return id;       
    }
    
    public int executePreparedUpdateAndReturnGenerateKeys(String query, Object... params) throws SQLException {
        return executePreparedUpdateAndReturnGenerateKeys(getConnectionFromContext(), query, params);
    }
    
    public void executePreparedUpdate(Connection conn, String query, Object... params) throws SQLException {
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(query);
            
            populatePreparedStatement(pstmt, params);

            pstmt.executeUpdate();
        } finally {
            release(pstmt);
        }
    }
    
    public void executePreparedUpdate(String query, Object... params) throws SQLException {
        executePreparedUpdate(getConnectionFromContext(), query, params);
    }    
    
    public void release(Connection conn) {
        if (conn == null) return;
        
        try {
            conn.close();
        } catch (SQLException e) { }        
    }        
    
    public void release(Statement stmt) {
        if (stmt == null) return;
        
        try {
            stmt.close();
        } catch (SQLException e) { }        
    }
   
    public void release(ResultSet rs) {
        if (rs == null) return;
        
        try {
            rs.close();
        } catch (SQLException e) { }        
    }    
    
    public void releaseAll(Connection conn, Statement stmt) {
        release(stmt);   
        release(conn);
    }
    
    public void releaseAll(Connection conn, Statement stmt, ResultSet rs) {
        release(rs);
        releaseAll(conn, stmt);
    }    
    
    public <T> void executeQuery(Connection conn, String query, QueryMapping<T> queryMapping) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        try {
            pstmt = conn.prepareStatement(query);

            rset = pstmt.executeQuery();

            queryMapping.mapping(rset);
        } finally {
            release(rset);
            release(pstmt);
            release(conn);
        }        
    }
    
    public <T> void executeQuery(String query, QueryMapping<T> queryMapping) throws SQLException, IOException {
        executeQuery(getConnection(), query, queryMapping);
    }
    
    public <T> void executePreparedQuery(Connection conn, String query, QueryMapping<T> queryMapping, Object... params) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        try {
            pstmt = conn.prepareStatement(query);
            
            populatePreparedStatement(pstmt, params);
            
            rset = pstmt.executeQuery();

            queryMapping.mapping(rset);
        } finally {
            release(rset);
            release(pstmt);
            release(conn);
        } 
    }
    
    public <T> void executePreparedQuery(String query, QueryMapping<T> queryMapping, Object... params) throws SQLException, IOException {
        executePreparedQuery(getConnection(), query, queryMapping, params);
    }

    private void populatePreparedStatement(PreparedStatement pstmt, Object[] params) throws SQLException {
        int i = 0;
        for (Object param : params) {
            pstmt.setObject(++i, param);
        }
    }
    
}
