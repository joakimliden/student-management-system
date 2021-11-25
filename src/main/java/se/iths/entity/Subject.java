package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String topic;
    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();
    @ManyToOne
    private Teacher teacher;

/*    public void addStudent(Student student) {
        students.add(student);
        student.setSubject(this);
    }*/

    //region CONSTRUCTOR NEEDED FOR SampleDataGenerator

    public Subject(String topic) {
        this.topic = topic;
    }

    public Subject() {
    }

    //end region

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudent(Set<Student> students) {
        this.students = students;
    }

    //endregion


}
