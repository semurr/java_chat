package com.smurr.rabbit.consumer;

/**
 * This interface allows you to apply custom actions to the object you recieved.
 * The object recieved will be passed in as a string
 * 
 * @author stephen
 * 
 */
public interface Listen {

	/**
	 * This action is performed when the listener gets from the chat server
	 * 
	 * @param listenValue
	 *            is the string object found by the listener
	 */
	public void call(String listenValue);

}
