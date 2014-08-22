package com.smurr.core;

import java.io.IOException;

import com.smurr.rabbit.MessageListener;
import com.smurr.rabbit.MessageSender;
import com.smurr.rabbit.consumer.Listen;

public class Chat {
	
	MessageListener messageListener;
	MessageSender messageSender;
	
	public void connect(){
		
		//connect and create listeners
		messageListener = new MessageListener();
		messageSender = new MessageSender();		
	}
	
	public void setListener(Listen listen) throws IOException{
		
		messageListener.createListener(listen);		
	}
	
	public void sendMessage(String message) throws IOException{
		
		messageSender.sendMessage(message);		
	}
}
