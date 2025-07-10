package org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity;

import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPetRepository extends JpaRepository<PetEntity, Long>{
}
