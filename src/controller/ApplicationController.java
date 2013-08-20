package controller;

import dao.PersonDao;
import java.util.List;
//import javax.swing.JFrame;

import model.Address;
import model.City;
import model.Country;
import model.District;
import model.Person;
import model.State;
//import view.DashboardJFrame;

public class ApplicationController {
    
    public static void main(String[] args) {
//        JFrame frame = new DashboardJFrame();
//                
//        frame.setVisible(true);
        
//        testeGravacao();
        
        testeBusca();
    }
    
    public static void testeBusca() {
        
        PersonDao personDao = new PersonDao();
        List<Person> people = personDao.getAll();
        
        for (Person person : people ) {
            System.out.println(person.getId() + " - " + person.getName());
        }
        
        System.out.println( "Total: " + people.size() );
    }
    
    public static void testeGravacao() {
        Country country = new Country("Brasil").save();
        
        State state = new State("Rio Grande do Sul", country).save();
        
        City city = new City("Teutônia", "95890000", state).save();
        
        District district = new District("Canabarro", city).save();
        
        Address address = new Address("Rua Décio Pelegrini, 799", "home", district);
        
        Person person = new Person("Elton", "Elton Kolling", "employee", "123456789", "987654321", "eltonlk@gmail.com", "98327358", "98327358", "active", address);
        
        new PersonDao().insert(person);
        
//        System.out.println(person.getId());
//        System.out.println(person.getAddress().getId());
//        System.out.println(address.getId());
//        
//        System.out.println(person.getName());
//        System.out.println(address.getAddress());
        
        person.setName("Elton Luis Kolling");
        
        address.setAddress("Rua 7 de setembro, 1245");
        
        new PersonDao().update(person);

//        System.out.println(person.getName());
//        System.out.println(address.getAddress());
    }
    
}
