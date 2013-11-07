package dao;

import framework.CreateDaoException;
import framework.DaoHelper;
import framework.DeleteDaoException;
import framework.QueryMapping;
import framework.UpdateDaoException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Actor;

import model.Movie;

public class MovieDao {
    
    private final DaoHelper daoHelper;
    
    public MovieDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(Movie movie) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO movies (title, release_in, genre_id, synopsis) VALUES ( ?, ?, ?, ? )";           

            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                movie.getTitle(), 
                movie.getReleaseIn(),    
                movie.getGenre().getId(),
                movie.getSynopsis());    

            movie.setId(id);
            
            saveActors(movie);
            
            daoHelper.endTransaction();          
        } catch (SQLException | IOException e) {
           daoHelper.rollbackTransaction();
            System.out.println(e.getMessage());
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }
    
    public void update(Movie movie) throws UpdateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "UPDATE movies SET title = ?, release_in = ?, genre_id = ?, synopsis = ? WHERE id = ?";           
           
            daoHelper.executePreparedUpdate(
                query, 
                movie.getTitle(), 
                new java.sql.Date( movie.getReleaseIn().getTime()),    
                movie.getGenre().getId(),
                movie.getSynopsis(),
                movie.getId()); 
            
            saveActors(movie);
            
            daoHelper.endTransaction();          
        } catch (SQLException | IOException e) {
           daoHelper.rollbackTransaction();
            System.out.println(e.getMessage());            
           throw new UpdateDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    

    public void saveActors(Movie movie) {
        System.out.println("1");
        
        try {
            String query = "INSERT INTO actors_movies (actor_id, movie_id) SELECT ?, ? WHERE NOT EXISTS (SELECT 1 FROM actors_movies WHERE actor_id = ? AND movie_id = ?)";           

            
            for(Actor actor : movie.getActors()) {
                daoHelper.executePreparedUpdate(
                    query, 
                    actor.getId(), 
                    movie.getId(),          
                    actor.getId(), 
                    movie.getId());                
            }
        } catch (SQLException e) {
           daoHelper.rollbackTransaction();
            System.out.println( e.getMessage() );
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }         
    }       
    
    public void delete(Movie movie) throws DeleteDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "DELETE FROM movies WHERE id = ?";           
            
            daoHelper.executePreparedUpdate(
                query, 
                movie.getId());                    
            
            daoHelper.endTransaction();          
        } catch (SQLException | IOException e) {
           daoHelper.rollbackTransaction();
            
           throw new DeleteDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    
    
    public List<Movie> getAll() {
        final List<Movie> movies = new ArrayList<>();

        try {
            String query = "SELECT * FROM movies"; 
           
            daoHelper.executePreparedQuery(query, 
                    new QueryMapping<Movie>() {
                        @Override
                        public void mapping(ResultSet rset) throws SQLException {
                            while (rset.next()) {
                                Movie movie = new Movie();
                                
                                movie.setId( rset.getInt("id") ); 
                                movie.setTitle( rset.getString("title") );
                                movie.setReleaseIn( rset.getDate("release_in") );
                                movie.setGenre( new GenreDao().getById( rset.getInt("genre_id") ) );
                                movie.setSynopsis( rset.getString("synopsis") );

                                movie.setMedias( new MediaDao().getByMovie(movie) );
                                
                                movie.setActors( new ActorDao().getByMovie(movie) );
                                
                                movies.add(movie);
                            }
                        }
                    });
        } catch (SQLException e) { } catch (IOException ex) {
            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return movies; 
    }
}
