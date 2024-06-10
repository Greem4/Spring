package edu.spring.dao;

import edu.spring.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public PersonDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Transactional(readOnly = true)
//    public List<Person> index() {
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.createQuery("select p from Person p", Person.class)
//                .getResultList();
//    }
//
//
//    @Transactional(readOnly = true)
//    public Person show(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Person.class, id);
//    }
//
//    @Transactional
//    public void save(Person person) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(person);
//    }
//
//    @Transactional
//    public void update(int id, Person updatePerson) {
//        Session session = sessionFactory.getCurrentSession();
//        Person personToBeUpdate = session.get(Person.class, id);
//
//        personToBeUpdate.setName(updatePerson.getName());
//        personToBeUpdate.setAge(updatePerson.getAge());
//        personToBeUpdate.setEmail(updatePerson.getEmail());
//    }
//
//    @Transactional
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.remove(session.get(Person.class, id));
//    }

    public final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);
//
//        // 1 Запрос
//        List<Person> people = session.createQuery("select p from Person p", Person.class)
//                .getResultList();
//
//        // N запросов к БД
//        for (Person person : people) {
//            System.out.println("Person: " + person.getName() + " has " + person.getItems());
//        }


        // Solution
        // SQL: A LEFT JOIN B -> Результирующая обедненная таблица
        Set<Person> people = new HashSet<Person> (session.createQuery("select p from Person p LEFT JOIN FETCH p.items")
                .getResultList());

        for (Person p : people) {
            System.out.println("Person: " + p.getName() + " has " + p.getItems());
        }
    }

}