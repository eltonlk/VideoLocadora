package dao;

import framework.CreateDaoException;
import framework.DaoHelper;
import framework.DeleteDaoException;
import framework.QueryMapping;
import framework.UpdateDaoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Genre;

public class GenreDao {
    
    private DaoHelper daoHelper;
    
    public GenreDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(Genre genre) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO genres (name, status) VALUES ( ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                genre.getName(),
                genre.getStatus());                    
            
            genre.setId(id);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }

    public void update(Genre genre) throws UpdateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "UPDATE genres SET name = ?, status = ? WHERE id = ?";           
           
            daoHelper.executePreparedUpdate(
                query, 
                genre.getName(), 
                genre.getStatus(),
                genre.getId());                    
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new UpdateDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    
    
    public void delete(Genre genre) throws DeleteDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "DELETE FROM genres WHERE id = ?";           
            
            daoHelper.executePreparedUpdate(
                query, 
                genre.getId());                    
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new DeleteDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    
    
    public List<Genre> getAll() {
        final List<Genre> genres = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM genres"; 
            
            daoHelper.executePreparedQuery(query, 
                    new QueryMapping<Genre>() {
                        @Override
                        public void mapping(ResultSet rset) throws SQLException {
                            while (rset.next()) {
                                Genre genre = new Genre();
                                genre.setId( rset.getInt("id") );
                                genre.setName( rset.getString("name") );
                                genre.setStatus( rset.getString("status") );

                                genres.add(genre);
                            }
                        }
                    });
        } catch (SQLException e) { }
        
        return genres; 
    }
    
}