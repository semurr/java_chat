package com.smurr.rabbit.consumer;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.QueueingConsumer.Delivery;

/**
 * Consumer for grabbing the messages in its own thread
 * 
 * @author stephen
 * 
 */
public class ChatMessageConsumer extends DefaultConsumer {
	
	Listen listenObject;

	public ChatMessageConsumer(Channel channel, Listen listenObject) {
		super(channel);
		this.listenObject = listenObject;
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope,
			AMQP.BasicProperties properties, byte[] body) throws IOException {
		
		String recieved = new String(body);

		// create the message
		listenObject.call(recieved);

		// output the message
		System.out.println("[X] Recieved: " + recieved);		
	}

}
