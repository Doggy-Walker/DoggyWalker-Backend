package org.sopt.pawkey.backendapi.domain.region.application.facade.command;

import org.sopt.pawkey.backendapi.domain.region.application.dto.command.GetRegionCoordinatesCommand;
import org.sopt.pawkey.backendapi.domain.region.application.dto.result.GetRegionCoordinatesResult;
import org.sopt.pawkey.backendapi.domain.region.application.service.RegionService;
import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetRegionCoordinatesFacade {

	private final RegionService regionService;

	public GetRegionCoordinatesResult execute(Long userId,
		GetRegionCoordinatesCommand getRegionCoordinatesCommand) {

		// TODO: user 가져오기

		Region region = regionService.getRegionById(getRegionCoordinatesCommand.regionId());

		return GetRegionCoordinatesResult.from(region);
	}
}
