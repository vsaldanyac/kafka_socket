package com.vic.camera.controller;

import com.vic.camera.entities.IncomingMessage;
import com.vic.camera.entities.OutgoingMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class ServerController {
	Logger logger = LoggerFactory.getLogger(ServerController.class);

	@MessageMapping("/process-message")
	@SendTo("/topic/messages")
	public String processMessage(String incomingMessage) throws Exception {
		logger.info(incomingMessage);
		return "Hello " + incomingMessage;
	}
}
