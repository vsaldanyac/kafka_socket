package com.vic.driver.services;

import java.util.concurrent.ExecutionException;


public interface SocketService {

	void subscribe() throws ExecutionException, InterruptedException;
	void send(String name);
}
