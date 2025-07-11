package org.sopt.pawkey.backendapi.domain.region.infra.persistence;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.region.domain.RegionRepository;
import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.sopt.pawkey.backendapi.domain.region.infra.mapper.RegionMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepository {

	private final SpringDataRegionRepository springDataRegionRepository;

	@Override
	public Optional<Region> getById(Long regionId) {
		return springDataRegionRepository.getByRegionId(regionId)
			.map(RegionMapper::toDomain);
	}
}
