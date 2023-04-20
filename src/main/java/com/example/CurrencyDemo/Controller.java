package com.example.CurrencyDemo;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private CoindeskAPI mCoindeskAPI;
	
	@GetMapping("/coindeskAPI")
	public ResponseEntity<String> getDataCoindeskAPI(){
		JSONObject json = mCoindeskAPI.callCoindeskAPI();
		System.out.println(json);
		return new ResponseEntity<>(json.toString(),HttpStatus.OK);
	}
}
