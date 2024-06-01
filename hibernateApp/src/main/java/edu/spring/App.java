package edu.spring;

import edu.spring.model.Passport;
import edu.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = new Person("Test cascading", 30);
//            Passport passport = new Passport(123456);
//
//            person.setPassport(passport);
//            session.save(person);

            Person person = session.get(Person.class, 1);
            session.remove(person);

            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }
}
