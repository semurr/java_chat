package com.smurr.java_chat;

import java.io.IOException;
import java.util.Scanner;

import com.smurr.core.Chat;
import com.smurr.rabbit.MessageListener;
import com.smurr.rabbit.MessageSender;
import com.smurr.rabbit.consumer.ChatDisplay;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		
		Chat chat = new Chat();
		
		chat.connect();
		
		chat.setListener(new ChatDisplay());
		
		

		
		String line;
		Scanner scanner = new Scanner(System.in);

		while (!(line = scanner.nextLine()).equals("quit")) {

			chat.sendMessage(line);
		}

		System.out.println("GoodBye World!");
	}
}
