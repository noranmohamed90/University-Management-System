package org.example.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@NamedQueries(
        @NamedQuery(name = "StudentsWithCourses", query = "SELECT s FROM Student s JOIN  s.course crs ")
)
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "St_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    @Column(name = "St_address")
    private String  address;


    @Column(name = "St_email")
    private String email;

    @Column(name = "St_phone")
    private String phone;

    @Column(name = "St_age")
    private int age;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name = "St_Card_id")
    private Student_Card Student_Card;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name= "students_Course",
            joinColumns = @JoinColumn(name = "st_id"),
            inverseJoinColumns = @JoinColumn(name= "crs_id")
    )
    private List<Course>course;

    public Student_Card getStudent_Card() {
        return Student_Card;
    }

    public void setStudent_Card(Student_Card student_Card) {
        this.Student_Card = student_Card;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }
}
