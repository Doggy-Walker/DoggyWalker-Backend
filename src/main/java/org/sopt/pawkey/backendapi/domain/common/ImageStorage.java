package org.sopt.pawkey.backendapi.domain.common;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorage {
	String uploadProfileImage(MultipartFile image);

	String uploadRouteImage(MultipartFile image);

	List<String> uploadWalkImages(List<MultipartFile> images);
}
