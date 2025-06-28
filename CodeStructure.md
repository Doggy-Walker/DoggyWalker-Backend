# 🏗️ DoggyWalker Backend API - 프로젝트 초기 설정

## 목차
- [🏛️ 전체 아키텍처 개요](#--------------)
    * [핵심 특징](#-----)
- [📁 패키지 구조 설명](#------------)
- [🎯 핵심 설계 원칙](#-----------)
    * [1. 도메인 중심 설계 (Domain-Centric)](#1------------domain-centric-)
    * [2. 의존성 역전 원칙 (DIP) 적용](#2------------dip----)
    * [3. 계층별 DTO 분리](#3-----dto---)
    * [4. 단일 책임 원칙](#4---------)
- [🔄 계층별 역할과 책임](#-------------)
    * [🌐 API 계층 (`api`)](#---api------api--)
    * [🔧 Application 계층 (`application`)](#---application------application--)
        + [Facade (파사드)](#facade------)
        + [Service (서비스)](#service------)
    * [🎯 Domain 계층 (`domain`)](#---domain------domain--)
        + [Model (도메인 엔티티)](#model----------)
        + [Repository Interface](#repository-interface)
    * [🔌 Infrastructure 계층 (`infra`)](#---infrastructure------infra--)
        + [Entity (영속성 엔티티)](#entity----------)
        + [Repository Implementation](#repository-implementation)
- [🎯 도메인 예외 통합 관리 체계](#------------------)
    * [1. 통합 예외 처리 원칙](#1------------)
    * [2. 예외 발생 위치별 처리](#2-------------)
    * [3. User 도메인 예시](#3-user-------)
    * [4. 장점](#4---)
- [📚 개발 가이드라인](#-----------)
    * [1. 새로운 도메인 추가 시](#1-------------)
    * [2. API 개발 순서](#2-api------)
    * [3. 코딩 규칙](#3------)
    * [4. 주의사항](#4-----)
- [🚀 시작하기](#-------)
## 🏛️ 전체 아키텍처 개요

본 프로젝트는 **Domain Driven Design(DDD)** 기반의 클린 아키텍처를 적용하여 구성되었습니다.

### 핵심 특징

- ✅ **도메인 중심 설계**: 비즈니스 로직을 도메인 계층에 집중
- ✅ **계층 간 의존성 역전**: DIP(Dependency Inversion Principle) 적용
- ✅ **엔티티와 도메인 모델 분리**: 영속성과 비즈니스 로직 분리
- ✅ **DTO 계층별 분리**: API DTO와 Service DTO 분리
- ✅ **통합 예외 처리**: 일관된 에러 응답 체계
- ✅ **파사드 패턴**: 복잡한 유스케이스 관리


## 📁 패키지 구조 설명

```
org.sopt.doggywalker.backendapi
├── domain                           # 📦 도메인별 모듈
│   └── user                         # 👤 사용자 도메인
│       ├── api                      # 🌐 프레젠테이션 계층
│       │   ├── controller/          # REST API 컨트롤러
│       │   └── dto/                 # API 요청/응답 DTO
│       │       ├── request/
│       │       └── response/
│       ├── application              # 🔧 애플리케이션 계층
│       │   ├── dto/                 # 서비스 계층 DTO
│       │   │   ├── request/
│       │   │   └── response/
│       │   ├── facade/              # 파사드 (유스케이스 조합)
│       │   └── service/             # 비즈니스 서비스
│       ├── domain                   # 🎯 도메인 모델 계층
│       │   ├── model/               # 도메인 엔티티 (POJO)
│       │   └── repository/          # 저장소 인터페이스
│       ├── exception                # ❌ 도메인별 예외
│       └── infra                    # 🔌 인프라스트럭처 계층
│           └── persistence/
│               ├── entity/          # JPA 엔티티
│               └── repository/      # 저장소 구현체
└── global                           # 🌍 전역 공통 모듈
    ├── config/                      # 설정 클래스
    ├── exception/                   # 공통 예외 처리
    │   └── handler/
    ├── infra/                       # 공통 인프라
    │   └── persistence/entity/      # BaseEntity
    └── response/                    # 공통 응답 포맷
```


## 🎯 핵심 설계 원칙

### 1. 도메인 중심 설계 (Domain-Centric)

- **비즈니스 로직**은 `domain.model` 패키지에 집중
- **도메인 규칙**은 도메인 엔티티 생성자에서 검증
- **영속성 기술**과 도메인 로직 완전 분리


### 2. 의존성 역전 원칙 (DIP) 적용

```java
// ✅ 올바른 의존성 방향
domain.repository.UserRepository (인터페이스)
    ⬆️ 의존
infra.persistence.UserRepositoryImpl (구현체)
```


### 3. 계층별 DTO 분리

- **API DTO**: 클라이언트와의 통신용 (`api.dto`)
- **application DTO**: application 계층 내부 통신용 (`application.dto`)
- **Domain Model**: 순수 비즈니스 객체 (`domain.model`)


### 4. 단일 책임 원칙

- **Controller**: HTTP 요청/응답 처리만
- **Facade**: 여러 서비스 조합 및 트랜잭션 관리
- **Service**: 단일 도메인 비즈니스 로직
- **Repository**: 데이터 접근만


## 🔄 계층별 역할과 책임

### 🌐 API 계층 (`api`)

**역할**: HTTP 요청 수신 및 응답 반환

```java
@RestController
public class UserController {
    private final UserFacade userFacade;
    
    @PostMapping("/users")
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        CreateUserServiceRequest serviceRequest = CreateUserServiceRequest.from(request);
        UserServiceResponse serviceResponse = userFacade.createUser(serviceRequest);
        return ApiResponse.success(UserResponse.from(serviceResponse));
    }
}
```


### 🔧 Application 계층 (`application`)

**역할**: 유스케이스 실행 및 서비스 조합

#### Facade (파사드)

```java
@Component
public class UserFacade {
    private final UserService userService;
    private final NotificationService notificationService;
    
    @Transactional
    public UserServiceResponse createUser(CreateUserServiceRequest request) {
        // 1. 사용자 생성
        UserServiceResponse user = userService.createUser(request);
        // 2. 알림 발송
        notificationService.sendWelcomeMessage(user.getEmail());
        return user;
    }
}
```


#### Service (서비스)

```java
@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserServiceResponse createUser(CreateUserServiceRequest request) {
        // 도메인 모델 생성 (비즈니스 규칙 검증 포함)
        User user = new User(request.getName(), new Email(request.getEmail()));
        User savedUser = userRepository.save(user);
        return UserServiceResponse.from(savedUser);
    }
}
```


### 🎯 Domain 계층 (`domain`)

**역할**: 순수 비즈니스 로직 및 규칙

#### Model (도메인 엔티티)

```java
public class User {
    private final Long id;
    private final String name;
    private final Email email;
    
    public User(String name, Email email) {
        validateName(name);  // 비즈니스 규칙 검증
        this.name = name;
        this.email = email;
    }
    
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new UserBusinessException(UserErrorCode.INVALID_USER_NAME);
        }
    }
}
```


#### Repository Interface

```java
public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(Email email);
}
```


### 🔌 Infrastructure 계층 (`infra`)

**역할**: 외부 시스템 연동 및 기술적 구현

#### Entity (영속성 엔티티)

```java
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    // 도메인 모델로 변환
    public User toDomain() {
        return new User(this.id, this.name, new Email(this.email));
    }
    
    // 도메인 모델에서 생성
    public static UserEntity from(User user) {
        return UserEntity.of(user.getName(), user.getEmail().getValue());
    }
}
```


#### Repository Implementation

```java
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final SpringDataUserRepository jpaRepository;
    
    @Override
    public User save(User user) {
        UserEntity entity = UserEntity.from(user);
        UserEntity saved = jpaRepository.save(entity);
        return saved.toDomain();
    }
}
```

## 🎯 도메인 예외 통합 관리 체계


### 1. 통합 예외 처리 원칙

- **모든 도메인 비즈니스 예외**는 해당 도메인의 `{Domain}ErrorCode`(예: `UserErrorCode`)에서 **통합 관리**
- **예외 발생 시** `BusinessException`을 상속받은 도메인별 예외(예: `UserBusinessException`)만 사용
- **커스텀 예외 클래스**를 도메인별로 추가 생성하지 않고, `ErrorCode`로 모든 케이스 구분


### 2. 예외 발생 위치별 처리

| 계층 | 예외 처리 방식 | 예시 |
| :-- | :-- | :-- |
| **Service** | `UserBusinessException` 던지기 + `UserErrorCode` 사용 | `throw new UserBusinessException(UserErrorCode.USER_NOT_FOUND)` |
| **Domain Model** | `UserBusinessException` 던지기 + `UserErrorCode` 사용 | `throw new UserBusinessException(UserErrorCode.INVALID_USER_NAME)` |
| **Controller** | Spring Validation 자동 처리 (`@Valid`) + `ResponseCode.BAD_REQUEST` 응답 | `@Valid @RequestBody CreateUserRequest` |
| **Infra** | 기술적 예외는 `GlobalErrorCode` 사용 + `BusinessException`으로 래핑 | `throw new BusinessException(GlobalErrorCode.DATABASE_ERROR)` |

### 3. User 도메인 예시

**UserErrorCode.java**

```java
public enum UserErrorCode implements ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001", "사용자를 찾을 수 없습니다"),
    INVALID_USER_NAME(HttpStatus.BAD_REQUEST, "U002", "유효하지 않은 사용자 이름입니다"),
    EMAIL_DUPLICATION(HttpStatus.CONFLICT, "U003", "이메일이 중복되었습니다");
    // ...
}
```

**Service 계층에서 사용**

```java
public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new UserBusinessException(UserErrorCode.USER_NOT_FOUND));
}
```

**Domain Model에서 사용**

```java
public User(String name, Email email) {
    if (name == null || name.isBlank()) {
        throw new UserBusinessException(UserErrorCode.INVALID_USER_NAME);
    }
    this.name = name;
    this.email = email;
}
```


### 4. 장점

1. **일관성**: 모든 비즈니스 예외가 동일한 메커니즘(`BusinessException`)으로 처리
2. **관리 용이**: 도메인별 에러 코드를 한 곳(`UserErrorCode`)에서 집중 관리
3. **확장성**: 새로운 에러 유형 추가 시 열거형만 수정하면 됨
4. **가독성**: 예외 발생 지점에서 `ErrorCode`만으로 오류 내용 명확히 표현


## 📚 개발 가이드라인

### 1. 새로운 도메인 추가 시

1. `domain.{새도메인}` 패키지 생성
2. 동일한 패키지 구조 (`api`, `application`, `domain`, `exception`, `infra`) 복사
3. 도메인별 `ErrorCode` 정의 (접두어: 도메인 첫글자)

### 2. API 개발 순서

1. **도메인 모델** 정의 (`domain.model`)
2. **서비스 DTO** 정의 (`application.dto`)
3. **서비스 로직** 구현 (`application.service`)
4. **API DTO** 정의 (`api.dto`)
5. **컨트롤러** 구현 (`api.controller`)
6. **테스트** 작성(optional)

### 3. 코딩 규칙

- **패키지명**: 소문자, 단수형 사용
- **클래스명**: 역할 명시 (`UserService`, `UserController`)
- **메서드명**: 동사 + 명사 조합 (`createUser`, `findByEmail`)
- **예외**: 도메인별 `BusinessException` 상속


### 4. 주의사항

- **도메인 모델**에는 JPA 어노테이션 사용 금지
- **Controller**에서 직접 `Service` 호출 금지 → `Facade` 경유
- **크로스 도메인** 호출은 `Facade`에서만 허용
- **외부 API** 호출은 `infra` 계층에서만


## 🚀 시작하기

1. **새로운 기능 개발** 시 `user` 도메인을 참고하여 동일한 구조로 개발
2. **공통 기능** 추가 시 `global` 패키지 활용
3. **예외 처리** 는 기존 패턴을 따라 `ErrorCode` 먼저 정의
4. **테스트** 는 각 계층별로 독립적으로 작성

이 구조를 통해 **유지보수성**, **확장성**, **테스트 용이성**을 확보하고, 팀원 간 **일관된 개발 패턴**을 유지할 수 있습니다.

<div style="text-align: center">⁂</div>

