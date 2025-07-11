package org.sopt.pawkey.backendapi.domain.region.application.facade.command;

import org.sopt.pawkey.backendapi.domain.region.application.dto.command.GetRegionCoordinatesCommand;
import org.sopt.pawkey.backendapi.domain.region.application.dto.result.GetRegionCoordinatesResult;
import org.sopt.pawkey.backendapi.domain.region.application.service.RegionService;
import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.sopt.pawkey.backendapi.domain.user.application.service.UserService;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetRegionCoordinatesFacade {

	private final RegionService regionService;
	private final UserService userService;

	public GetRegionCoordinatesResult execute(Long userId,
		GetRegionCoordinatesCommand getRegionCoordinatesCommand) {

		User user = userService.getByUserId(userId);
		Region region = regionService.getRegionById(getRegionCoordinatesCommand.regionId());

		return GetRegionCoordinatesResult.from(region);
	}
}
