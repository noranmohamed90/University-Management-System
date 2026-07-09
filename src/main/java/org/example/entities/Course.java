package org.example.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int crs_id;
    private String crs_title;
    private String crs_description;
    private int crs_hours;
    private int crs_price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ins_id")
    private Instructor instructor;


    @ManyToMany(mappedBy = "course")
    private List<Student>student;

    public int getCrs_id() {
        return crs_id;
    }

    public void setCrs_id(int crs_id) {
        this.crs_id = crs_id;
    }

    public String getCrs_title() {
        return crs_title;
    }

    public void setCrs_title(String crs_title) {
        this.crs_title = crs_title;
    }

    public String getCrs_description() {
        return crs_description;
    }

    public void setCrs_description(String crs_description) {
        this.crs_description = crs_description;
    }

    public int getCrs_hours() {
        return crs_hours;
    }

    public void setCrs_hours(int crs_hours) {
        this.crs_hours = crs_hours;
    }

    public int getCrs_price() {
        return crs_price;
    }

    public void setCrs_price(int crs_price) {
        this.crs_price = crs_price;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "crs_id=" + crs_id +
                ", crs_title='" + crs_title + '\'' +
                ", crs_description='" + crs_description + '\'' +
                ", crs_hours=" + crs_hours +
                ", crs_price=" + crs_price +
                '}';
    }
}
