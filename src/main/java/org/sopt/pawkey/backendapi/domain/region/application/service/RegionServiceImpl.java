package org.sopt.pawkey.backendapi.domain.region.application.service;

import org.sopt.pawkey.backendapi.domain.region.domain.RegionRepository;
import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.sopt.pawkey.backendapi.domain.region.exception.RegionBusinessException;
import org.sopt.pawkey.backendapi.domain.region.exception.RegionErrorCode;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

	private final RegionRepository regionRepository;

	@Override
	public Region getRegionById(Long regionId) {

		return regionRepository.getById(regionId)
			.orElseThrow(() -> new RegionBusinessException(RegionErrorCode.REGION_NOT_FOUND));
	}
}
