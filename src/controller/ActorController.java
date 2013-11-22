package controller;

import dao.ActorDao;
import java.util.List;
import model.Actor;

public class ActorController {
    
    private static final ActorDao dao = new ActorDao();

    public static List<Actor> list() {
        return dao.list();
    }
    
    public static void create(Actor actor) {
        dao.save(actor);
    }
    
    public static void destroy(Actor actor) {
        dao.destroy(actor);
    }
    
}
