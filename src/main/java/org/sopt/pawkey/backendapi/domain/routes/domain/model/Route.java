package org.sopt.pawkey.backendapi.domain.routes.domain.model;

import org.locationtech.jts.geom.LineString;
import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;

import lombok.Getter;

@Getter
public class Route {

	private final Long routeId;
	private final LineString coordinates;
	private final double distance;
	private final Integer duration;
	private final Integer stepCount;
	private final RegionEntity region;

	public Route(Long routeId, LineString coordinates, double distance, Integer duration,
		Integer stepCount, RegionEntity region) {
		this.routeId = routeId;
		this.coordinates = coordinates;
		this.distance = distance;
		this.duration = duration;
		this.stepCount = stepCount;
		this.region = region;
	}

	public static Route createRoute(LineString coordinates, double distance, Integer duration,
		Integer stepCount, RegionEntity region) {
		return new Route(null, coordinates, distance, duration, stepCount, region);
	}
}