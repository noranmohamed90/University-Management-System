package org.example.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "student_card")
public class Student_Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int id;
    private String cardNumber;
    private String issueDate;
    private String expireDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Student_Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }
}
