package com.vic.driver.controllers;

import com.vic.driver.services.SocketService;
import com.vic.driver.services.VicWebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ExecutionException;


@Controller
public class SocketController {


	@Autowired
	SocketService socketService;

	@Autowired
	VicWebSocketClient vicWebSocketClient;

	@GetMapping("/init")
	public ResponseEntity<?> initSocket() throws ExecutionException, InterruptedException {
		socketService.subscribe();
		vicWebSocketClient.openConnection();
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@GetMapping("/send")
	public ResponseEntity<?> sendSocket() {
		socketService.send();
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
