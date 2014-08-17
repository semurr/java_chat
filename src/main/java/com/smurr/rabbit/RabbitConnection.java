package com.smurr.rabbit;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class RabbitConnection {

	private static Connection	connection;

	private static String		RABBIT_HOST	= "localhost";

	/**
	 * Create a connection if one was not created
	 * 
	 * @throws IOException
	 */
	static void setup() throws IOException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(RABBIT_HOST);

		connection = connectionFactory.newConnection();
	}

	/**
	 * only allow one connection to be established per app
	 * 
	 * @return a new channel from the connection
	 * @throws IOException
	 */
	synchronized static Channel getNewChannel() throws IOException {

		if (connection == null) {
			setup();
		}

		return connection.createChannel();

	}

}
