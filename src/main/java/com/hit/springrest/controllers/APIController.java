package com.hit.springrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@RestController
@RequestMapping("/API")
public class APIController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("/bin")
	public String getHttpBin() {
		String url = "https://httpbin.org/get";			//some urls may need additional configs
		Object response = restTemplate.getForObject(url, Object.class);
		return new Gson().toJson(response, Object.class);
	}
}
