package org.sopt.pawkey.backendapi.domain.region.infra.persistence;

import java.util.Optional;

import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRegionRepository extends JpaRepository<RegionEntity, Long> {

	Optional<RegionEntity> getByRegionId(Long regionId);
}
