package controller;

import dao.ActorDao;
import model.Actor;

public class ActorController {

    public static void create(Actor actor) {
        ActorDao dao = new ActorDao();

        dao.save(actor);
    }
    
}
