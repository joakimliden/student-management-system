package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Joakim", "Lidén", "joakim@mail.com");
        Student student2 = new Student("Josefin", "Lidén", "josefin@mail.com");
        Student student3 = new Student("Linnea", "Axell", "linnea@mail.com");
        Student student4 = new Student("Anna", "Axell", "anna@mail.com");
        Student student5 = new Student("Torbjörn", "Enarsson", "torbjörn@mail.com");
        Student student6 = new Student("Stefan", "Enarsson", "stefan@mail.com");

        Subject subject1 = new Subject("Matematik");
        Subject subject2 = new Subject("Gymnastik");
        Subject subject3 = new Subject("Biologi");
        Subject subject4 = new Subject("Engelska");

        Teacher teacher1 = new Teacher("Bert", "Stjärt", "bert@mail.com", "0701234567");
        Teacher teacher2 = new Teacher("Berta", "Stjärta", "berta@mail.com", "0701234567");

        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject4);

        student1.addSubject(subject1);
        student2.addSubject(subject2);
        student3.addSubject(subject3);
        student4.addSubject(subject4);

        /*subject1.addStudent(student1);
        subject1.addStudent(student2);
        subject1.addStudent(student3);
        subject1.addStudent(student4);

        subject2.addStudent(student1);
        subject2.addStudent(student2);
        subject2.addStudent(student3);
        subject2.addStudent(student4);

        subject3.addStudent(student1);
        subject3.addStudent(student2);
        subject3.addStudent(student3);
        subject3.addStudent(student4);

        subject4.addStudent(student1);
        subject4.addStudent(student2);
        subject4.addStudent(student3);
        subject4.addStudent(student4);*/

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.persist(student5);
        entityManager.persist(student6);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);
        entityManager.persist(subject4);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
    }

}
