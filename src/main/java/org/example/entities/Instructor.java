package org.example.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructor")
@NamedEntityGraph(
        name = "instructor.course",
        attributeNodes = @NamedAttributeNode("course")
)
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ins_id;
    private String ins_name;
    private int ins_salary;
    private String ins_specialization;
    private String ins_phone;
    private String ins_email;


    @OneToMany(mappedBy = "instructor")
    private List<Course>course;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;


    public int getIns_id() {
        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }

    public String getIns_name() {
        return ins_name;
    }

    public void setIns_name(String ins_name) {
        this.ins_name = ins_name;
    }

    public int getIns_salary() {
        return ins_salary;
    }

    public void setIns_salary(int ins_salary) {
        this.ins_salary = ins_salary;
    }

    public String getIns_specialization() {
        return ins_specialization;
    }

    public void setIns_specialization(String ins_specialization) {
        this.ins_specialization = ins_specialization;
    }

    public String getIns_phone() {
        return ins_phone;
    }

    public void setIns_phone(String ins_phone) {
        this.ins_phone = ins_phone;
    }

    public String getIns_email() {
        return ins_email;
    }

    public void setIns_email(String ins_email) {
        this.ins_email = ins_email;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "ins_id=" + ins_id +
                ", ins_name='" + ins_name + '\'' +
                ", ins_salary=" + ins_salary +
                ", ins_specialization='" + ins_specialization + '\'' +
                ", ins_phone='" + ins_phone + '\'' +
                ", ins_email='" + ins_email + '\'' +
                '}';
    }
}
