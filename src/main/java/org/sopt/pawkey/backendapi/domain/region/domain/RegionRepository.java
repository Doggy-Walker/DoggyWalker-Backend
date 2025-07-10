package org.sopt.pawkey.backendapi.domain.region.domain;

import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;

public interface RegionRepository {
	Region getFirstById(Long regionId);
}
