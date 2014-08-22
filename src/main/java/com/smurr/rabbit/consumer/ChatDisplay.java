package com.smurr.rabbit.consumer;

public class ChatDisplay implements Listen{

	public void call(String call) {
		System.out.println("called me");
		
	}

}
