package org.sopt.pawkey.backendapi.domain.user.api.controller;

import org.sopt.pawkey.backendapi.domain.common.ImageStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/s3")
@RequiredArgsConstructor
public class S3Controller {

	private final ImageStorage s3ImageService;

	@PostMapping("/upload/profile")
	public ResponseEntity<String> uploadProfileImage(@RequestParam("image") MultipartFile image) {
		String url = s3ImageService.uploadProfileImage(image);
		return ResponseEntity.ok(url);
	}
}