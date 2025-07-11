package org.sopt.pawkey.backendapi.domain.region.infra.mapper;

import org.sopt.pawkey.backendapi.domain.region.domain.model.Region;
import org.sopt.pawkey.backendapi.domain.region.domain.vo.RegionArea;
import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;
import org.springframework.stereotype.Component;

@Component
public class RegionMapper {
	/**
	 * 데이터베이스 인프라와 통신하기 위한 객체로 변경
	 * @param domain Region 도메인 모델
	 * @return Region 엔티티
	 */
	public RegionEntity toEntity(Region domain) {
		if (domain == null) {
			return null;
		}

		return RegionEntity.builder()
			.regionType(domain.getRegionType())
			.regionName(domain.getRegionName())
			.areaGeometry(domain.getArea().getMultiPolygon())
			.build();
	}

	/**
	 * 데이터베이스 엔티티를 도메인 로직에서 사용하기 위한 도메인 모델로 변경
	 * @param entity Region 엔티티
	 * @return Region 도메인 모델
	 */
	public Region toDomain(RegionEntity entity) {
		if (entity == null) {
			return null;
		}

		return Region.builder()
			.regionType(entity.getRegionType())
			.regionName(entity.getRegionName())
			.area(RegionArea.of(entity.getAreaGeometry()))
			.parent(toDomain(entity.getParent()))
			.build();
	}
}
