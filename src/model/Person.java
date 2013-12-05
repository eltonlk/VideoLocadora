package model;

import dao.PersonDao;

public class Person extends util.GenericModel {

    private Long personId;
    private byte[] avatar;
    private String legalName;
    private String name;
    private String document1;
    private String document2;
    private String phone;
    private String cell;
    private String email;
    private String kind;

    public Person() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument1() {
        return document1;
    }

    public void setDocument1(String document1) {
        this.document1 = document1;
    }

    public String getDocument2() {
        return document2;
    }

    public void setDocument2(String document2) {
        this.document2 = document2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    protected void validateRules() {
        if (ValidationUtils.isEmpty(legalName)) {
            addError("legal_name", "Razão social não pode ficar em branco.");
        } else {
            PersonDao dao = new PersonDao();

            if (dao.exists(this)) {
                addError("legal_name", "Cliente já existe.");
            }
        }

        if (ValidationUtils.isEmpty(name)) {
            addError("name", "Nome fantasia não pode ficar em branco.");
        }
    }

}
