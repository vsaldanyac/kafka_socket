package com.vic.driver.controllers;

import com.vic.driver.services.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RestController
public class SocketController {

	@Qualifier("sampleService") @Autowired
	SocketService socketService;



	@GetMapping("/init")
	public ResponseEntity<?> initSocket() throws ExecutionException, InterruptedException {
		socketService.subscribe();
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@GetMapping("/send")
	public ResponseEntity<?> sendSocket(@RequestParam String name) {
		socketService.send(name);
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}


}
