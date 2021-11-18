package se.iths.service;

import se.iths.entity.Student;
import se.iths.exception.CreateStudentException;
import se.iths.exception.DataNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    String mandatoryFieldsString = "firstName, lastName, email are mandatory and not filled correct";

    public void create(Student student) {
        try {
            entityManager.persist(student);
        } catch (Exception e) {
            throw new CreateStudentException(mandatoryFieldsString);
        }
    }

    public List<Student> getAll() {
        List<Student> students = entityManager
                .createQuery("SELECT s from Student s", Student.class)
                .getResultList();
        if (students.isEmpty())
            throw new DataNotFoundException("There are no students in db");
        return students;
    }

    public Student getById(Long id) {
        return getStudent(id);
    }

    public void update(Long id, Student updatedStudent) {
        Student student = getById(id);
        try {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            student.setPhoneNumber(updatedStudent.getPhoneNumber());
        } catch (ConstraintViolationException e) {
            throw new CreateStudentException(mandatoryFieldsString);
        }
        entityManager.merge(student);
    }

    public void delete(Long id) {
        Student student = getStudent(id);
        entityManager.remove(student);
    }

    private Student getStudent(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student == null)
            throw new DataNotFoundException("Student with id " + id + " not found");
        return student;
    }

    public List<Student> getByLastName(String lastName) {
        List<Student> students = entityManager
                .createQuery("SELECT s FROM Student s WHERE s.lastName = :lastName", Student.class)
                .setParameter("lastName", lastName)
                .getResultList();
        if (students.isEmpty())
            throw new DataNotFoundException("Students with last name " + lastName + " does not exist");
        return students;
    }
}
