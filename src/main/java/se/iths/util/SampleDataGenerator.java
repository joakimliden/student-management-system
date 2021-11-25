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

        Student joakim = new Student("Joakim", "Lidén", "joakim@mail.com");
        Student conny = new Student("Conny", "Andersson", "connny@mail.com");
        Student bonny = new Student("Bonny", "Axell", "bonny@mail.com");
        Student jonny = new Student("Jonny", "Axell", "jonny@mail.com");
        Student benny = new Student("Benny", "Enarsson", "benny@mail.com");
        Student sonny = new Student("Sonny", "Enarsson", "sonny@mail.com");

        Subject mathematics = new Subject("Matematik");
        Subject gymnastic = new Subject("Gymnastik");
        Subject biology = new Subject("Biologi");
        Subject english = new Subject("Engelska");

        Teacher bert = new Teacher("Bert", "Stjärt", "bert@mail.com", "0701234567");
        Teacher berta = new Teacher("Berta", "Stjärta", "berta@mail.com", "0701234567");

        bert.addSubject(mathematics);
        bert.addSubject(gymnastic);
        berta.addSubject(biology);
        berta.addSubject(english);

        joakim.addSubject(mathematics);
        conny.addSubject(gymnastic);
        bonny.addSubject(biology);
        jonny.addSubject(mathematics);
        benny.addSubject(english);
        sonny.addSubject(english);

        entityManager.persist(joakim);
        entityManager.persist(conny);
        entityManager.persist(bonny);
        entityManager.persist(jonny);
        entityManager.persist(benny);
        entityManager.persist(sonny);

        entityManager.persist(mathematics);
        entityManager.persist(gymnastic);
        entityManager.persist(biology);
        entityManager.persist(english);

        entityManager.persist(bert);
        entityManager.persist(berta);
    }

}
