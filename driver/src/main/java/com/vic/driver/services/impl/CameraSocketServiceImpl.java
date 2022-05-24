package com.vic.driver.services.impl;


import com.vic.driver.entities.CameraRead;
import com.vic.driver.services.SocketService;
import com.vic.driver.services.handlers.CameraStompSessionHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.ExecutionException;

@Service
@Qualifier("cameraService")
public class CameraSocketServiceImpl implements SocketService {

	StompSession session;

	@Override public void subscribe() throws ExecutionException, InterruptedException {
		WebSocketClient client = new StandardWebSocketClient();

		WebSocketStompClient stompClient = new WebSocketStompClient(client);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());

		CameraStompSessionHandler clientOneSessionHandler = new CameraStompSessionHandler();
		ListenableFuture<StompSession> sessionAsync =
				stompClient.connect("ws://vicCamera:8090/camera-broadcast", clientOneSessionHandler);
		session = sessionAsync.get();
		session.subscribe("/topic/camera", clientOneSessionHandler);
	}

	@Override public void send(Object plate) {
		CameraRead cameraRead = (CameraRead)plate;
		StompSession.Receiptable receiptable = session.send("/app/camera-message", cameraRead);
	}

	@Override public void disconnect() {
		session.disconnect();
	}
}
