package org.sopt.pawkey.backendapi.domain.region.domain.model;

import java.util.List;

import org.locationtech.jts.geom.MultiPolygon;

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
	// 전용 VO로 wrapping 필요
	private final MultiPolygon areaGeometry;
}
