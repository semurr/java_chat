package com.smurr.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

import com.smurr.core.Chat;
import com.smurr.rabbit.MessageSender;

public class ButtonAction implements ActionListener{
	
	JTextArea jTextArea;
	Chat messageSender;
	
	public ButtonAction(JTextArea jTextArea, Chat chat){
		
		this.jTextArea = jTextArea;
		this.messageSender = chat;
		
	}

	public void actionPerformed(ActionEvent e) {		
		try {
			messageSender.sendMessage(jTextArea.getText());
		} catch (IOException e1) {			
			e1.printStackTrace();
			System.out.println("Error Sending Message");
		}
		
		jTextArea.setText("");
		
		
	}

}
