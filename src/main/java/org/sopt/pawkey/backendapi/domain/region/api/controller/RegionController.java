package org.sopt.pawkey.backendapi.domain.region.api.controller;

import static org.sopt.pawkey.backendapi.global.constants.AppConstants.*;

import org.sopt.pawkey.backendapi.domain.region.api.dto.GetRegionCoordinatesResponse;
import org.sopt.pawkey.backendapi.domain.region.application.dto.command.GetRegionCoordinatesCommand;
import org.sopt.pawkey.backendapi.domain.region.application.dto.result.GetRegionCoordinatesResult;
import org.sopt.pawkey.backendapi.domain.region.application.facade.command.GetRegionCoordinatesFacade;
import org.sopt.pawkey.backendapi.global.exception.BusinessException;
import org.sopt.pawkey.backendapi.global.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(API_PREFIX + "/regions")
@RequiredArgsConstructor
public class RegionController {

	private final GetRegionCoordinatesFacade getRegionCoordinatesFacade;

	@GetMapping("/{regionId}/geometry")
	@Operation(summary = "지역 좌표 조회", description = "지역 좌표 조회 API입니다.", tags = {"Region"})
	@ApiResponses({
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "지역 범위 좌표 조회"),
		@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "조회 실패 (USER_NOT_FOUND 또는 REGION_NOT_FOUND 에러코드 확인)", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BusinessException.class)))})
	public ResponseEntity<ApiResponse<GetRegionCoordinatesResponse>> getRegionCoordinates(
		@RequestHeader("userId") Long userId,
		@PathVariable("regionId") Long regionId
	) {

		GetRegionCoordinatesResult result = getRegionCoordinatesFacade.execute(userId,
			GetRegionCoordinatesCommand.of(regionId));

		return ResponseEntity.ok(
			ApiResponse.success(GetRegionCoordinatesResponse.from(result)));
	}
}
