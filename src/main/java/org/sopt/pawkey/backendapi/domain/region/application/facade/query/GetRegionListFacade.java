package org.sopt.pawkey.backendapi.domain.region.application.facade.query;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.region.application.dto.command.GetRegionListCommand;
import org.sopt.pawkey.backendapi.domain.region.application.dto.result.GetRegionListResult;
import org.sopt.pawkey.backendapi.domain.region.application.service.query.RegionQueryService;
import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetRegionListFacade {

	private final RegionQueryService regionQueryService;
	public GetRegionListResult execute(GetRegionListCommand command) {
		List<RegionEntity> GusWithDongs = regionQueryService.searchGusWithRegion(command);

		return GetRegionListResult.from(GusWithDongs);
	}
}
