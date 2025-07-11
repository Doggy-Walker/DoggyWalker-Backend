package org.sopt.pawkey.backendapi.domain.user.infra.persistence;

// @SpringBootTest
// @Transactional
// @DisplayName("UserQueryRepositoryImpl 통합 테스트")
// class UserQueryRepositoryImplTest {
//
// 	@Autowired
// 	private UserQueryRepositoryImpl userQueryRepository;
//
// 	@Autowired
// 	private UserRepository userRepository;
//
// 	@BeforeEach
// 	void setUp() {
// 		IntStream.rangeClosed(1, 10).forEach(i -> {
// 			userRepository.save(User.createUser("loginId" + i, "name" + i));
// 		});
//
// 		IntStream.rangeClosed(11, 20).forEach(i -> {
// 			userRepository.save(User.createUser("loginId" + i, "another" + i));
// 		});
// 	}
//
// 	@AfterEach
// 	void tearDown() {
// 		userRepository.deleteAllInBatch();
// 	}
//
// 	@Test
// 	@DisplayName("UserQueryRepositoryImpl: queryDsl을 통해 전체 유저가 조회된다.")
// 	void 전체_유저를_조회한다() {
// 		// when
// 		List<User> users = userQueryRepository.getUsers();
//
// 		// then
// 		assertThat(users).hasSize(20);
// 		assertThat(users).extracting("loginId")
// 			.containsExactlyInAnyOrderElementsOf(IntStream.rangeClosed(1, 20).mapToObj(i -> "loginId" + i).toList());
// 	}
//
// 	@Test
// 	@DisplayName("UserQueryRepositoryImpl: queryDsl을 통해 이름 like 검색을 통과한 유저가 존재한다.")
// 	void getPosts_withPagination_success() {
// 		// given
// 		String searchNameKeyword = "another";
//
// 		// when
// 		List<User> users = userQueryRepository.getUsersByNameLike(searchNameKeyword);
//
// 		// then
// 		assertThat(users).hasSize(10);
// 		assertThat(users).extracting("name")
// 			.containsExactlyInAnyOrderElementsOf(IntStream.rangeClosed(11, 20).mapToObj(i -> "another" + i).toList());
// 	}
// }