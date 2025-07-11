package org.sopt.pawkey.backendapi.global.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GeometryType {
	POINT("Point", "좌표 포인트"),
	LINESTRING("LineString", "라인스트링(직선)"),
	POLYGON("Polygon", "폴리곤(범위)"),
	MULTIPOLYGON("MultiPolygon", "복수의 폴리곤");

	private final String text;
	private final String description;
}
