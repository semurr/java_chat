package com.smurr.rabbit;

import java.io.IOException;

import com.rabbitmq.client.Channel;

public class MessageSender extends RabbitConnection{
	
	private String EXCHANGE_NAME = "chat";
	private String EXCHANGE_TYPE = "fanout";
	
	Channel channel;
	
	private void attachExchange() throws IOException{
		
		if(channel == null){
			channel = getNewChannel();			
		}
		
		channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);		
	}
	
	public void sendMessage(String message) throws IOException{
		
		if(channel == null){
			attachExchange();
		}
		
		channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
		
		// create the message
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("[Y] Message Sent = ");
				stringBuilder.append(message);
				
				System.out.println(stringBuilder.toString());
				stringBuilder.setLength(0);		
	}
	

}
