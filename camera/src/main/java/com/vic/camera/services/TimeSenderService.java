package com.vic.camera.services;

import com.vic.camera.entities.IncomingMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Component
public class TimeSenderService {

	private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

	Logger log = LoggerFactory.getLogger(TimeSenderService.class);

	@Autowired
	private SimpMessagingTemplate broker;

	@Autowired
	public TimeSenderService(final SimpMessagingTemplate broker) {
		this.broker = broker;
	}

	@Scheduled(fixedRate = 15000)
	public void run() {
		String time = LocalTime.now().format(TIME_FORMAT);

		log.info("Time broadcast: {}", time);
		broker.convertAndSend("/topic/messages", new IncomingMessage("Current time is " + time));
	}
}
