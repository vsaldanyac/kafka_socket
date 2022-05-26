package com.vic.driver.controllers;

import com.vic.driver.entities.CameraRead;
import com.vic.driver.repository.CameraRepository;
import com.vic.driver.services.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/camera")
public class CameraController {


	@Qualifier("cameraService") @Autowired
	SocketService socketService;

	@Autowired
	CameraRepository cameraRepository;



	@GetMapping("/init")
	public ResponseEntity<?> initSocket() throws ExecutionException, InterruptedException {
		socketService.subscribe();
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@PostMapping("/send")
	public ResponseEntity<?> sendSocket(@RequestBody CameraRead plate) {
		socketService.send(plate);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveCamera(@RequestBody CameraRead plate) {
		cameraRepository.save(plate);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}


}
