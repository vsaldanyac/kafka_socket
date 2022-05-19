package com.vic.driver.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.concurrent.ExecutionException;

@Service
public class VicWebSocketClient {
	Logger logger = LoggerFactory.getLogger(VicWebSocketClient.class);


	public void openConnection() throws ExecutionException, InterruptedException {
		WebSocketStompClient stompClient = new WebSocketStompClient(new WebSocketClient() {
			@Override public ListenableFuture<WebSocketSession> doHandshake(WebSocketHandler webSocketHandler, String uriTemplate, Object... uriVariables) {
				logger.info("doHandshake");
				return null;
			}
			@Override public ListenableFuture<WebSocketSession> doHandshake(WebSocketHandler webSocketHandler, WebSocketHttpHeaders headers, URI uri) {
				logger.info("doHandshake");
				return null;
			}
		});

	}
}



