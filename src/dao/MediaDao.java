package dao;

import framework.DaoHelper;
import framework.QueryMapping;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Media;
import model.Movie;

public class MediaDao {
    
    private final DaoHelper daoHelper;
    
    public MediaDao() {
        daoHelper = new DaoHelper();
    }

    public List<Media> getByMovie(final Movie movie) {
        final List<Media> medias = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM medias WHERE movie_id = ?"; 
            
            daoHelper.executePreparedQuery(query, 
                    new QueryMapping<Media>() {
                        @Override
                        public void mapping(ResultSet rset) throws SQLException {
                            while (rset.next()) {
                                Media media = new Media();
                                
                                media.setId( rset.getInt("id") );
                                media.setMovie( movie );
                                media.setSupplier( new PersonDao().getById( rset.getInt("supplier_id") ) );
                                media.setKind( rset.getString("kind") );
                                media.setAmount( rset.getBigDecimal("amount") );
                                media.setAmountPaid( rset.getBigDecimal("amount_paid") );
                                media.setStatus( rset.getString("status") );
                                media.setPurchasedAt( rset.getDate("purchased_at") );

                                medias.add(media);
                            }
                        }
                    },
                    movie.getId());
        } catch (SQLException e) { } catch (IOException ex) {
            Logger.getLogger(MediaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return medias; 
    }    
    
    
    
//    public void insert(Movie movie) throws CreateDaoException {
//        try {
//            daoHelper.begingTransaction();
//                        
//            String query = "INSERT INTO movies (title, release_in, genre_id, synopsis) VALUES ( ?, ?, ?, ? )";           
//
//            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
//                query, 
//                movie.getTitle(), 
//                movie.getReleaseIn(),    
//                movie.getGenre().getId(),
//                movie.getSynopsis());    
//
//            movie.setId(id);
//            
//            daoHelper.endTransaction();          
//        } catch (SQLException | IOException e) {
//           daoHelper.rollbackTransaction();
//            System.out.println(e.getMessage());
//           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
//        }
//    }
    
//    public void update(Movie movie) throws UpdateDaoException {
//        try {
//            daoHelper.begingTransaction();
//                        
//            String query = "UPDATE movies SET title = ?, release_in = ?, genre_id = ?, synopsis = ? WHERE id = ?";           
//           
//            daoHelper.executePreparedUpdate(
//                query, 
//                movie.getTitle(), 
//                new java.sql.Date( movie.getReleaseIn().getTime()),    
//                movie.getGenre().getId(),
//                movie.getSynopsis(),
//                movie.getId()); 
//            
//            daoHelper.endTransaction();          
//        } catch (SQLException | IOException e) {
//           daoHelper.rollbackTransaction();
//            System.out.println(e.getMessage());            
//           throw new UpdateDaoException("Não foi possivel realizar a tranzação.", e);
//        }        
//    }    
    
//    public void delete(Movie movie) throws DeleteDaoException {
//        try {
//            daoHelper.begingTransaction();
//                        
//            String query = "DELETE FROM movies WHERE id = ?";           
//            
//            daoHelper.executePreparedUpdate(
//                query, 
//                movie.getId());                    
//            
//            daoHelper.endTransaction();          
//        } catch (SQLException | IOException e) {
//           daoHelper.rollbackTransaction();
//            
//           throw new DeleteDaoException("Não foi possivel realizar a tranzação.", e);
//        }        
//    }    
    
//    public List<Movie> getAll() {
//        final List<Movie> movies = new ArrayList<>();
//
//        try {
//            String query = "SELECT * FROM movies"; 
//           
//            daoHelper.executePreparedQuery(query, 
//                    new QueryMapping<Movie>() {
//                        @Override
//                        public void mapping(ResultSet rset) throws SQLException {
//                            while (rset.next()) {
//                                Movie movie = new Movie();
//                                
//                                movie.setId( rset.getInt("id") ); 
//                                movie.setTitle( rset.getString("title") );
//                                movie.setReleaseIn( rset.getDate("release_in") );
//                                movie.setGenre( new GenreDao().getById( rset.getInt("genre_id") ) );
//                                movie.setSynopsis( rset.getString("synopsis") );
//
//                                movie.setMedias( new MediaDao().getByMovieId(movie.getId()) );
//                                
//                                movies.add(movie);
//                            }
//                        }
//                    });
//        } catch (SQLException e) { } catch (IOException ex) {
//            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return movies; 
//    }
}
