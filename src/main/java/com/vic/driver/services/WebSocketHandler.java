package com.vic.driver.services;


import com.vic.driver.entities.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;


public class WebSocketHandler extends StompSessionHandlerAdapter {

	private Logger logger = LogManager.getLogger(WebSocketHandler.class);

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		logger.info("New session established : " + session.getSessionId());
		session.subscribe("/topic/messages", this);
		logger.info("Subscribed to /topic/messages");
		session.send("/app/chat", getSampleMessage());
		logger.info("Message sent to websocket server");
	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
		logger.error("Got an exception", exception);
	}

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return Message.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		Message msg = (Message) payload;
		logger.info("Received : " + msg.getText() + " from : " + msg.getFrom());
	}


	private Message getSampleMessage() {
		Message msg = new Message();
		msg.setFrom("Nicky");
		msg.setText("Howdy!!");
		return msg;
	}
}
