package com.smurr.rabbit;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.smurr.rabbit.consumer.ChatMessageConsumer;
import com.smurr.rabbit.consumer.Listen;

public class MessageListener extends RabbitConnection {

	private String	EXCHANGE_NAME	= "chat";
	private String	EXCHANGE_TYPE	= "fanout";
	private String queue_name;

	Channel			channel;

	public void createListener(Listen listenAction) throws IOException {

		if (channel == null) {
			channel = getNewChannel();
		}

		channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
		
		queue_name = channel.queueDeclare().getQueue();
		channel.queueBind(queue_name, EXCHANGE_NAME, "");
		
		ChatMessageConsumer consumer = new ChatMessageConsumer(channel, listenAction);
		
		channel.basicConsume(queue_name, false, consumer);		
	}
}