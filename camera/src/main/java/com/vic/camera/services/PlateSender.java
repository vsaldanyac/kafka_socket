package com.vic.camera.services;

import com.vic.camera.entities.CameraRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;


@Component
public class PlateSender {

	Logger log = LoggerFactory.getLogger(PlateSender.class);


	@Autowired
	private SimpMessagingTemplate broker;

	@Autowired
	public PlateSender(final SimpMessagingTemplate broker) {
		this.broker = broker;
	}


	@Scheduled(fixedRate = 30000)
	public void run() {


		CameraRead camera = fillCamera();
		log.info("New Plate broadcast: {}", camera.toJsonString());
		broker.convertAndSend("/topic/camera", camera);
	}

	private CameraRead fillCamera() {
		CameraRead camera = new CameraRead();

		camera.setPlate(genPlate());
		camera.setZone(genZone());
		camera.setDate(new Date());
		camera.setPicture("http://google.com/" + camera.getPlate());

		return camera;
	}

	private String genPlate() {
		char[] matr = new char[7];
		matr[0] = generarRandomNum().charAt(0);
		matr[1] = generarRandomNum().charAt(0);
		matr[2] = generarRandomNum().charAt(0);
		matr[3] = generarRandomNum().charAt(0);
		matr[4] = generarRandomChar();
		matr[5] = generarRandomChar();
		matr[6] = generarRandomChar();
		return String.valueOf(matr);

	}

	private static char generarRandomChar() {
		return (char) (int) (Math.random () * 26 + 65);
	}

	private static String generarRandomNum() {
		int num =  (int) (Math.random() * 9) ;
		return Integer.toString(num);
	}

	private String genZone() {
		String[] ZONE = {"Raval", "Eixample", "Sant Martí", "Guinardó", "Sant Andreu"};
		Random random = new Random();

		return ZONE[random.ints(0, 4)
				.findFirst()
				.getAsInt()];
	}
}
