package org.sopt.pawkey.backendapi.domain.region.application.dto.command;

public record GetRegionCoordinatesCommand(
	Long regionId
) {
	public static GetRegionCoordinatesCommand of(Long regionId) {
		return new GetRegionCoordinatesCommand(regionId);
	}
}
