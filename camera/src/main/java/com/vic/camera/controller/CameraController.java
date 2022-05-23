package com.vic.camera.controller;

import com.vic.camera.entities.CameraRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class CameraController {

	Logger logger = LoggerFactory.getLogger(CameraController.class);

	@MessageMapping("/camera-message")
	@SendTo("/topic/camera")
	public CameraRead processCameraMessage(CameraRead cameraMessage) {
		logger.info(cameraMessage.toJsonString());
		return cameraMessage;
	}
}
