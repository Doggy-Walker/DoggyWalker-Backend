package org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity;

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
@Table(name = "regions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
public class RegionEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id")
	private Long regionId;

	@Enumerated(EnumType.STRING)
	@Column(name = "region_type", nullable = false)
	private RegionType regionType;

	@Column(name = "region_name", nullable = false)
	private String regionName;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "parent_id")
	// private Region parent;

	@Column(name = "area_geometry", columnDefinition = "geometry(Polygon, 4326)")
	private Polygon areaGeometry;
}
