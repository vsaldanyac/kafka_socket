package com.vic.driver.services;

import com.vic.driver.entities.IncomingMessage;
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

public class CustmStompSessionHandler implements StompSessionHandler {

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
		return IncomingMessage.class;
	}
	@Override public void handleFrame(StompHeaders headers, Object payload) {
		logger.info(((IncomingMessage)payload).getName());
	}
}



