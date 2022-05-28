package com.vic.mstelestodetections.services.impl;

import com.vic.mstelestodetections.entities.CameraRead;
import com.vic.mstelestodetections.services.KafkaDetectionsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaDetectionsListenerImpl implements KafkaDetectionsListener {



	@Value("${topic: topic}")
	String topic;

	Logger log = LoggerFactory.getLogger(KafkaDetectionsListenerImpl.class);

	@KafkaListener(topics="topic_camera", groupId = "my-group")
	public void listenTopic(CameraRead cameraRead) {
		log.info("INCORPORADA nueva detección: " + cameraRead.getPlate());
	}
}
