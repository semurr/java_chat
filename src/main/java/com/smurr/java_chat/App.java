package com.smurr.java_chat;

import java.io.IOException;
import java.util.Scanner;

import com.smurr.rabbit.MessageListener;
import com.smurr.rabbit.MessageSender;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");

		MessageListener ml = new MessageListener();
		MessageSender ms = new MessageSender();

		ml.createListener();

		String line;
		Scanner scanner = new Scanner(System.in);

		while (!(line = scanner.nextLine()).equals("quit")) {

			ms.sendMessage(line);
		}

		System.out.println("GoodBye World!");
	}
}
