package com.vic.camera;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class controllers {

	@PostMapping(value = "camara/send")
	public ResponseEntity<?> sendPlate(@RequestBody String message) {

		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
