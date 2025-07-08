package org.sopt.pawkey.backendapi.domain.routes.infra.persistence.entity;

import java.time.LocalDateTime;

import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Polygon;
import org.sopt.pawkey.backendapi.domain.region.domain.model.RegionType;
import org.sopt.pawkey.backendapi.global.infra.persistence.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "routes")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class RouteEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private Long route_id;

	// post_id 는 안가지는게 맞는거 같은데 맞나
	// region_id

	@Column(name = "coordinates", columnDefinition = "geometry(LineString, 4326)", nullable = false)
	private LineString coordinates;

	@Column(name = "distance", nullable = false)
	private Double distance;

	@Column(name = "duration", nullable = false)
	private Integer duration;

	@Column(name = "started_at", nullable = false)
	private LocalDateTime startedAt;

	@Column(name = "ended_at", nullable = false)
	private LocalDateTime endedAt;

	@Column(name = "step_count", nullable = false)
	private Integer stepCount;
}
