package com.vic.driver.services;

import com.vic.driver.entities.OutgoingMessage;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.ExecutionException;


@Service
public class SocketService {

	StompSession session;
	public void subscribe() throws ExecutionException, InterruptedException {
		WebSocketClient client = new StandardWebSocketClient();

		WebSocketStompClient stompClient = new WebSocketStompClient(client);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		//stompClient.setMessageConverter(new StringMessageConverter());

		CustmStompSessionHandler clientOneSessionHandler = new CustmStompSessionHandler();
		ListenableFuture<StompSession> sessionAsync =
				stompClient.connect("ws://localhost:8090/websocket-server", clientOneSessionHandler);
		session = sessionAsync.get();
		session.subscribe("/topic/messages", clientOneSessionHandler);
	}

	public void send(String name) {
		session.send("/app/process-message", new OutgoingMessage(name + " connected to VicSocket on " + System.currentTimeMillis()));
	}
}
