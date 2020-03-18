package be.pxl.ja2.jpa;

import be.pxl.ja2.jpa.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Opdracht1SaveMessage {

	public static void main(String[] args) {
		//TODO vraag message en schrijf weg in database
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type your message: ");
		String givenMessage = scanner.nextLine();

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("musicdb_pu");
			entityManager = entityManagerFactory.createEntityManager();
			Message message = new Message();
			message.setText(givenMessage);
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(message);
//			entityManager.persist(new Message(1, "test"));
//			entityManager.persist(new Message(2, "test1"));
//			entityManager.persist(new Message(3, "test2"));
			tx.commit();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}

}
