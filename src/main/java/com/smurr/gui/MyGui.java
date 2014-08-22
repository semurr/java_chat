package com.smurr.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.smurr.rabbit.MessageListener;
import com.smurr.rabbit.MessageSender;

public class MyGui extends JFrame {

	// gui components
	JPanel			jPanel;

	JTextArea		messageBoxRecieve;
	JTextArea		messageBoxSend;

	JScrollPane		textRecieveScroll;
	JScrollPane		textSendScroll;

	JButton			sendMessageButton;

	// rabbit components
	MessageListener	messageListener;
	MessageSender	messageSender;

	public MyGui() {

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

		// add actions
		// sendMessageButton.addActionListener(l);

	}

	public void setDimenision() {

		this.setTitle("JChat");
		this.setSize(500, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

}
