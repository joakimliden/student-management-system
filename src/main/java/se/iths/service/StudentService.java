package se.iths.service;

import se.iths.entity.Student;

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
        return entityManager.find(Student.class, id);
    }

    public void update(Long id, Student student) {
        Student newStudent = getById(id);
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setPhoneNumber(student.getPhoneNumber());
        entityManager.merge(newStudent);
    }

    public void delete(Long id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
