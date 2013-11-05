package model;

import framework.BaseModel;

public class Person extends BaseModel {
    
    private String name;
    private String legal_name;
    private String kind;
    private String document_1;
    private String document_2;
    private String email;
    private String phone;
    private String cel;
    private String status;
    
    private PersonAddress address;
    
    public Person() {
        this.status = "Ativo";
    }

    public Person(String name, String legal_name, String kind, String document_1, String document_2, String email, String phone, String cel, String status, PersonAddress address) {
        this.name = name;
        this.legal_name = legal_name;
        this.kind = kind;
        this.document_1 = document_1;
        this.document_2 = document_2;
        this.email = email;
        this.phone = phone;
        this.cel = cel;
        this.status = status;
        this.address = address;
    }

    @Override
    public void setId(int id) {
        this.id = id;  
        
        if (address != null) {
            this.address.setPerson(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalName() {
        return legal_name;
    }

    public void setLegalName(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDocument1() {
        return document_1;
    }

    public void setDocument1(String document_1) {
        this.document_1 = document_1;
    }

    public String getDocument2() {
        return document_2;
    }

    public void setDocument2(String document_2) {
        this.document_2 = document_2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public PersonAddress getAddress() {
        return address;
    }
    
    public void setAddress(PersonAddress address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        
        return this.id == other.id;
    }

    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome Fantasia não pode ficar em branco.");
        }
        if (ValidationUtils.isEmpty(legal_name)) {
            addError("legal_name", "Razão Social não pode ficar em branco.");
        }
        if (ValidationUtils.emailInvalid(email)) {
            addError("email", "Email não é válido.");
        }
    }
    
}
