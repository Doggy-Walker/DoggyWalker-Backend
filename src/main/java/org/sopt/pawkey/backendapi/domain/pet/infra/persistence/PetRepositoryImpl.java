package org.sopt.pawkey.backendapi.domain.pet.infra.persistence;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.pet.domain.model.Pet;
import org.sopt.pawkey.backendapi.domain.pet.domain.repository.PetRepository;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.PetTraitCategoryEntity;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.SpringDataPetRepository;
import org.sopt.pawkey.backendapi.domain.pet.infra.persistence.entity.SpringDataPetTraitCategoryRepository;
import org.sopt.pawkey.backendapi.domain.user.domain.model.User;
import org.sopt.pawkey.backendapi.domain.user.infra.mapper.UserMapper;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.SpringDataUserRepository;
import org.sopt.pawkey.backendapi.domain.user.infra.persistence.entity.UserEntity;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository {

	private final SpringDataPetTraitCategoryRepository springDataPetTraitCategoryRepository;


	@Override
	public List<PetTraitCategoryEntity> findAllPetTraitCategoriesWithOptions() {
		return springDataPetTraitCategoryRepository.findAllWithOptions();
	}

}


// @Override
// public User save(final User user) {
// 	UserEntity entity = userMapper.toEntity(user);
// 	UserEntity saved = springDataUserRepository.save(entity);
//
// 	return userMapper.toDomain(saved);
// }
//
// @Override
// public boolean existsByLoginId(final String loginId) {
// 	return springDataUserRepository.existsByLoginId(loginId);
// }
//
// @Override
// public void deleteAllInBatch() {
// 	springDataUserRepository.deleteAllInBatch();
// }