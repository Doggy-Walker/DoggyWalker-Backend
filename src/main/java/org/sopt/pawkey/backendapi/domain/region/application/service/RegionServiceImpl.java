package org.sopt.pawkey.backendapi.domain.region.application.service;

import org.sopt.pawkey.backendapi.domain.region.domain.RegionRepository;
import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

	private final RegionRepository regionRepository;
	@Override
	public Region getRegionById(Long regionId) {

		return regionRepository.getFirstById(regionId);
	}
}
