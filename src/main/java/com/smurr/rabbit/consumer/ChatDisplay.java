package com.smurr.rabbit.consumer;

import javax.swing.JTextArea;

public class ChatDisplay implements Listen{
	
	JTextArea recieveMessageBox;
	
	public ChatDisplay(JTextArea recieveMessageBox){
		
		this.recieveMessageBox = recieveMessageBox;
		
	}

	public void call(String call) {
		
		//apend message
		recieveMessageBox.append(call);
		
		//add new line
		recieveMessageBox.append("\n");
	}

}
