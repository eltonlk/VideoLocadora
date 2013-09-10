package mapping;

import view.person.FormPanel;
import model.Person;

public class PersonMapping {
    
    private FormPanel formPanel;
    
    public PersonMapping(FormPanel formPanel) {
        this.formPanel = formPanel;
    }
    
    public void toForm(Person person) {
        formPanel.getLabelId().setText( Integer.toString(person.getId()) );
        formPanel.getLabelId().setText( Integer.toString(person.getId()) );
        formPanel.getInputLegalName().setText( person.getLegalName() );
        formPanel.getInputName().setText( person.getName() );
        formPanel.getInputDocument1().setText( person.getDocument1() );
        formPanel.getInputDocument2().setText( person.getDocument2() );
        formPanel.getInputEmail().setText( person.getEmail() );
        formPanel.getInputPhone().setText( person.getPhone() );
        formPanel.getInputCel().setText( person.getCel() );
    }    
    
    public Person toPerson() {
        Person person = new Person();
        
        if ( !"".equals( formPanel.getLabelId().getText() ) ) {
            person.setId( Integer.parseInt(formPanel.getLabelId().getText()) );
        }
        
        person.setName( formPanel.getInputName().getText() );
        person.setLegalName( formPanel.getInputLegalName().getText() );
        person.setDocument1( formPanel.getInputDocument1().getText() );
        person.setDocument2( formPanel.getInputDocument2().getText() );
        person.setEmail( formPanel.getInputEmail().getText() );
        person.setKind( formPanel.getKind() );
        person.setCel( formPanel.getInputCel().getText() );
        person.setPhone( formPanel.getInputPhone().getText() );
        
//        person.setStatus(frame.getjCBStatus());
        
//        person.setAddress( mappingFormToAddress() );
        
        return person;
    }
    
//    private Address mappingFormToAddress() {
//        Address address = new Address();
//        
//        if ( !"".equals( frame.getjLAddressId().getText() ) ) {
//            address.setId( Integer.parseInt(frame.getjLAddressId().getText()) );
//        }        
//        
//        address.setAddress( frame.getjTFAddress().getText() );
////        address.setDistrictId( );
//        address.setLocation( "work" );
//        
//        return address;        
//    }    
    
}
