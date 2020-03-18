package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Contact;
import be.pxl.ja2.jpa.model.Message;

import javax.persistence.*;
import java.util.List;

public class Opdracht2GetMessage {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
            entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<Message> allMessagesQuery = entityManager.createQuery("SELECT m FROM Message m", Message.class);
            allMessagesQuery.getResultStream().forEach(System.out::println);
            /*EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            allMessagesQuery.setParameter("id", 1L);
            Message result = allMessagesQuery.getSingleResult();
            System.out.println(result.getText());*/
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
