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

	public ChatMessageConsumer(Channel channel) {
		super(channel);
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope,
			AMQP.BasicProperties properties, byte[] body) throws IOException {

		// create the message
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[X] Message Receieved = ");
		stringBuilder.append(new String(body));

		// output the message
		System.out.println(stringBuilder.toString());

		// clearing the buffer
		stringBuilder.setLength(0);
	}

}
