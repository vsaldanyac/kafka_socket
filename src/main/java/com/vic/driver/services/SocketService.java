package com.vic.driver.services;

import com.vic.driver.entities.IncomingMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;


@Service
public class SocketService {

	StompSession session;
	public void subscribe() throws ExecutionException, InterruptedException {
		WebSocketClient client = new StandardWebSocketClient();

		WebSocketStompClient stompClient = new WebSocketStompClient(client);
		stompClient.setMessageConverter(new StringMessageConverter());

		CustmStompSessionHandler clientOneSessionHandler = new CustmStompSessionHandler();
		ListenableFuture<StompSession> sessionAsync =
				stompClient.connect("ws://localhost:8090/websocket-server", clientOneSessionHandler);
		session = sessionAsync.get();
		session.subscribe("/topic/messages", clientOneSessionHandler);
	}

	public void send() {
		session.send("/app/process-message", "Himanshu " + System.currentTimeMillis());
	}
}
class CustmStompSessionHandler implements StompSessionHandler {

	Logger logger = LoggerFactory.getLogger(CustmStompSessionHandler.class);

	@Override public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		logger.info("afterConnected");
	}
	@Override public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
		logger.info("handleException");
	}
	@Override public void handleTransportError(StompSession session, Throwable exception) {
		logger.info("handleTransportError");
	}
	@Override public Type getPayloadType(StompHeaders headers) {
		return String.class;
	}
	@Override public void handleFrame(StompHeaders headers, Object payload) {
		logger.info(payload.toString());
	}
}

/*class ClientOneSessionHandler extends StompSessionHandlerAdapter {

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return IncomingMessage.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		System.out.println("Received : " + ((IncomingMessage) payload).getName());
	}

}
*/