package edu.spring;

import edu.spring.model.Item;
import edu.spring.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.ls.LSOutput;

import java.util.List;

public class App2 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println("Получим человека из таблицы");


//            Hibernate.initialize(person.getItems());
//            Item item = session.get(Item.class, 1);
//            System.out.println("Получили товар");
//
//            System.out.println(item.getOwner());

            session.getTransaction().commit();

            System.out.println("session.close");

            // Открываем сессию и транзакцию еще раз (в любом месте в коде)
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Внутри второй транзакции");

            person = (Person) session.merge(person);

            Hibernate.initialize(person.getItems());

//            List<Item> items = session.createQuery("select i from Item i where i.owner.id=:personId", Item.class)
//                    .setParameter("personId", person.getId()).getResultList();

//            System.out.println(items);

            session.getTransaction().commit();

            System.out.println("Вне второй сессии");

            // Вне сессии товары можем получать - если  они уже были подгружены (fetch = FetchType.EAGER)
            // это работает, так как связанные товары были загружены
            System.out.println(person.getItems());
        }
    }

}

