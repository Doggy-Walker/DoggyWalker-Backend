package org.sopt.doggywalker.backendapi.domain.user.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/")
	public String index() {
		return "API is running";
	}
}
