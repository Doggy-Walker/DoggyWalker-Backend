package org.sopt.pawkey.backendapi.domain.region.domain.model;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.region.domain.vo.RegionArea;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class Region {
	private final Long id;
	private final RegionType regionType;
	private final String regionName;
	private final Region parent;
	private final List<Region> children;
	private final RegionArea area;
}
