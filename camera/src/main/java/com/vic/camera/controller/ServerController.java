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
	public IncomingMessage processMessage(OutgoingMessage incomingMessage) {
		logger.info(incomingMessage.getContent());
		return new IncomingMessage("\n Hello " + incomingMessage.getContent() + ". \n Welcome to this jungle!!!!");
	}
}
