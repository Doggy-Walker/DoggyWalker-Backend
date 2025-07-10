package org.sopt.pawkey.backendapi.domain.routes.infra.mapper;

import org.sopt.pawkey.backendapi.domain.routes.domain.model.Route;
import org.sopt.pawkey.backendapi.domain.routes.infra.persistence.entity.RouteEntity;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

	public Route toDomain(RouteEntity entity) {
		return new Route(
			entity.getRouteId(),
			entity.getCoordinates(),
			entity.getDistance(),
			entity.getDuration(),
			entity.getStepCount(),
			entity.getRegion()
		);
	}

	public RouteEntity toEntity(Route route) {
		return RouteEntity.builder()
			.routeId(route.getRouteId())
			.coordinates(route.getCoordinates())
			.distance(route.getDistance())
			.duration(route.getDuration())
			.stepCount(route.getStepCount())
			.region(route.getRegion())
			.build();
	}
}