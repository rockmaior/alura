package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteProducerTopico {
	public static void main(String[] args) throws Exception {

		InitialContext context = new InitialContext();

		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();

		// Cria o consumidor

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination loja = (Destination) context.lookup("loja");
		MessageProducer producer = session.createProducer(loja);

			Message message = session.createTextMessage("<pedido><id>123</id></pedido>");
			producer.send(message);
		
		new Scanner(System.in).nextLine();

		session.close();

		connection.close();
		context.close();
	}
}
