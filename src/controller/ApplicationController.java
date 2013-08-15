package controller;

//import javax.swing.JFrame;
//
//import view.LoginJFrame;

import model.Person;
import model.Address;

import dao.PersonDao;
import java.util.Date;

public class ApplicationController {
    
    public static void main(String[] args) {
        
//        JFrame frame = new LoginJFrame();
//        
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
        
        Address address = new Address("Rua Décio Pelegrini, 799", "home", 0, 0);
        
        Person person = new Person("Elton", "Elton Kolling", "employee", "123456789", "987654321", "eltonlk@gmail.com", "98327358", "98327358", "active", address);
                     
        person.setCreatedAt(new Date());
        
        System.out.println(person.getCreatedAt());
        
        new PersonDao().insert(person);
        
    }
    
}
