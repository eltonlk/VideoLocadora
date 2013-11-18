package videolocadora.models;

import java.math.BigDecimal;
import java.util.Date;

public class Operation {
    
    private int idOperation;
    private Date issuedAt;
    private Person person;
    private Date due_at;
    private BigDecimal amount;
    private BigDecimal increase;
    private BigDecimal discount;
    private Date paidAt;
    private String document;

    public Operation() {
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDue_at() {
        return due_at;
    }

    public void setDue_at(Date due_at) {
        this.due_at = due_at;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getIncrease() {
        return increase;
    }

    public void setIncrease(BigDecimal increase) {
        this.increase = increase;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

}
