package se.iths.service;

import se.iths.entity.Student;
import se.iths.exception.DataNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void create(Student student) {
        entityManager.persist(student);
    }

    public List<Student> getAll() {
        return entityManager.createQuery(
                "SELECT s from Student s", Student.class)
                .getResultList();
    }

    public Student getById(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student == null) {
            throw new DataNotFoundException("Student with id " + id + " not found");
        }
        return student;
    }

    public void update(Long id, Student current) {
        Student update = getById(id);
        update.setFirstName(current.getFirstName());
        update.setLastName(current.getLastName());
        update.setEmail(current.getEmail());
        update.setPhoneNumber(current.getPhoneNumber());
        entityManager.merge(update);
    }

    public void delete(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    public List<Student> getByLastName(String lastName) {
        return entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.lastName = :lastName", Student.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }
}
