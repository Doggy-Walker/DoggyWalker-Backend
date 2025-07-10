package org.sopt.pawkey.backendapi.domain.region.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Region {
	private final Long regionId;
	private final String regionName;
	private final RegionType regionType;
	private final Long parentId;
}
