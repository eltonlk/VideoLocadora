package controller;

import model.Actor;
import view.actor.ActorFrame;
import view.actor.ActorsFrame;

public class ActorController {

    private ActorFrame actorFrame;
    private ActorsFrame actorsFrame;
    private Actor model;
    
    public void listar() {
        this.actorsFrame = new ActorsFrame();
        
        this.actorsFrame.setVisible(true);
    }
    
    public void cadastrar() {
        this.actorFrame = new ActorFrame();
    }
    
}
