package org.sopt.pawkey.backendapi.domain.region.domain.model;

import lombok.Getter;

@Getter
public class Region {

	private final Long id;
	private final Enum regionType;
	private final String regionName;
	private final Long parentId;

	protected Region(Long id, Enum regionType, String regionName, Long parentId) {
		this.id = id;
		this.regionType = regionType;
		this.regionName = regionName;
		this.parentId = parentId;
	}

	public static Region of(Long id, Enum regionType, String regionName, Long parentId) {
		return new Region(id, regionType, regionName, parentId);
	}
}