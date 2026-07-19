package org.example.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departement")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dep_id;
    private String dep_name;
    private String dep_location;

    @OneToMany(mappedBy = "department")
    private List<Student>student;

    @OneToMany(mappedBy = "department")
    private List<Instructor>instructor;


    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_location() {
        return dep_location;
    }

    public void setDep_location(String dep_location) {
        this.dep_location = dep_location;
    }


    @Override
    public String toString() {
        return "Department{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_location='" + dep_location + '\'' +

                '}';
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Instructor> getInstructor() {
        return instructor;
    }

    public void setInstructor(List<Instructor> instructor) {
        this.instructor = instructor;
    }
}
