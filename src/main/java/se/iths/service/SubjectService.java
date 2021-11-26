package se.iths.service;

import se.iths.entity.Subject;
import se.iths.exception.DataNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Subject> getAll() {
        List<Subject> subjects = entityManager
                .createQuery("SELECT s FROM Subject s", Subject.class)
                .getResultList();
        if (subjects.isEmpty())
            throw new DataNotFoundException("There are no subjects in db");
        return subjects;
    }

    public Subject getBySubject(String subject) {
        try {
            return entityManager
                    .createQuery("SELECT s FROM Subject s WHERE s.topic = :subject", Subject.class)
                    .setParameter("subject", subject)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new DataNotFoundException("Subject " + subject + " does not exist");
        }
    }
}
