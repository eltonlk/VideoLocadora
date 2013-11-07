package dao;

import framework.DaoHelper;
import framework.QueryMapping;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Actor;
import model.Movie;

public class ActorDao {
    
    private final DaoHelper daoHelper;
    
    public ActorDao() {
        daoHelper = new DaoHelper();
    }

    public List<Actor> getAll() {
        final List<Actor> actors = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM actors ORDER BY name"; 
            
            daoHelper.executePreparedQuery(query, 
                    new QueryMapping<Actor>() {
                        @Override
                        public void mapping(ResultSet rset) throws SQLException {
                            while (rset.next()) {
                                Actor actor = new Actor();
                                actor.setId( rset.getInt("id") );
                                actor.setName( rset.getString("name") );

                                actors.add(actor);
                            }
                        }
                    });
        } catch (SQLException | IOException e) { }
            
        return actors; 
    }    
    
    public List<Actor> getByMovie(final Movie movie) {
        final List<Actor> actors = new ArrayList<>();
        
        try {
            String query = "SELECT * FROM actors INNER JOIN actors_movies ON actors_movies.actor_id = actors.id WHERE actors_movies.movie_id = ?"; 
            
            daoHelper.executePreparedQuery(query, 
                new QueryMapping<Actor>() {
                    @Override
                    public void mapping(ResultSet rset) throws SQLException {
                        while (rset.next()) {
                            Actor actor = new Actor();

                            actor.setId( rset.getInt("id") );
                            actor.setName( rset.getString("name") );

                            actors.add(actor);
                        }
                    }
                },
                movie.getId());
        } catch (SQLException | IOException e) { }
        
        return actors; 
    } 
}
