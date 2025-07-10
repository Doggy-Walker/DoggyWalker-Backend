package org.sopt.pawkey.backendapi.domain.region.domain;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;

public interface RegionRepository {
	Optional<Region> getFirstById(Long regionId);
}
