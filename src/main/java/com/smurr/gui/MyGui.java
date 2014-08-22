package com.smurr.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.smurr.core.Chat;
import com.smurr.gui.action.ButtonAction;
import com.smurr.rabbit.MessageListener;
import com.smurr.rabbit.MessageSender;
import com.smurr.rabbit.consumer.ChatDisplay;

public class MyGui extends JFrame {

	Chat			chat;

	// gui components
	JPanel			jPanel;

	JTextArea		messageBoxRecieve;
	JTextArea		messageBoxSend;

	JScrollPane		textRecieveScroll;
	JScrollPane		textSendScroll;

	JButton			sendMessageButton;	

	public MyGui(Chat chat) {

		this.chat = chat;

	}

	public void guiSetup() {

		// set layout
		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		// set initiate components
		messageBoxRecieve = new JTextArea();
		messageBoxSend = new JTextArea();

		messageBoxRecieve.setEditable(false);
		textRecieveScroll = new JScrollPane(messageBoxRecieve);
		textRecieveScroll.setPreferredSize(new Dimension(400, 500));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.0;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 0;
		this.add(textRecieveScroll, c);

		textSendScroll = new JScrollPane(messageBoxSend);
		textSendScroll.setPreferredSize(new Dimension(200, 50));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		this.add(textSendScroll, c);

		sendMessageButton = new JButton("Send");
		sendMessageButton.setPreferredSize(new Dimension(50, 50));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		this.add(sendMessageButton, c);

		this.setTitle("JChat");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//setup listener objects
		setupListeners();
	}	
	
	private void setupListeners(){
		
		
		//send button listener
		sendMessageButton.addActionListener(new ButtonAction(messageBoxSend, chat));
		
		ChatDisplay chatDisplay = new ChatDisplay(messageBoxRecieve);
		
		
		//chat recieve listener
		try {
			chat.setListener(chatDisplay);
		} catch (IOException e) {			
			e.printStackTrace();
			System.out.println("Error when setting up chat listener");
		}
		
		
		
	}

}
