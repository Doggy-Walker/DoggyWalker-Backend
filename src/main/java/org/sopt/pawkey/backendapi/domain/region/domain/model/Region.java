package org.sopt.pawkey.backendapi.domain.region.domain.model;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.region.domain.vo.RegionArea;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class Region {
	private final Long regionId;
	private RegionType regionType;
	private String regionName;
	private Region parent;
	private List<Region> children;
	private RegionArea area;

	public String getFullRegionName() {
		String parentText = parent == null ? "" : parent.getRegionName() + " ";

		return parentText + regionName;
	}
}
