package se.iths.entity;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@JsonbPropertyOrder({
        "topic",
        "teacher",
        "students"
})
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String topic;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "SUBJECT_STUDENT",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    private Teacher teacher;



    //region CONSTRUCTOR NEEDED FOR SampleDataGenerator

    public Subject(String topic) {
        this.topic = topic;
    }

    public Subject() {
    }

    //endregion

    public void addStudent(Student student) {
        boolean added = students.add(student);
        if (added) {
            student.getSubjects().add(this);
        }
    }

    public void removeSubject(Student student) {
        boolean removed = students.remove(student);
        if (removed) {
            student.getSubjects().remove(this);
        }
    }

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

    /** tar man bort denna kukar det ur **/
//    @JsonbTransient
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /** tar man bort denna kukar det ur **/
//    @JsonbTransient
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    //endregion


}
