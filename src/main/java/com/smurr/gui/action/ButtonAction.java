package com.smurr.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class ButtonAction implements ActionListener{
	
	JTextArea jTextArea;
	
	public ButtonAction(JTextArea jTextArea){
		
		this.jTextArea = jTextArea;
		
	}

	public void actionPerformed(ActionEvent e) {
		
		jTextArea.append("I was clicked\n");
		
		System.out.println("I was clicked");
		
		
	}

}
