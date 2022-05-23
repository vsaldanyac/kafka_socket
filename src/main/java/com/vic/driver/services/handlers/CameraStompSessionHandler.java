package com.vic.driver.services.handlers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vic.driver.entities.CameraRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;


public class CameraStompSessionHandler implements StompSessionHandler {

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
		return CameraRead.class;
	}
	@Override public void handleFrame(StompHeaders headers, Object payload) {
		ObjectMapper mapper = new ObjectMapper();
		CameraRead camera = (CameraRead) payload;
		try {
			String json = mapper.writeValueAsString(camera);
			logger.info(json);
		} catch (JsonProcessingException e) {
			logger.info(e.getMessage());
		}

	}
}



