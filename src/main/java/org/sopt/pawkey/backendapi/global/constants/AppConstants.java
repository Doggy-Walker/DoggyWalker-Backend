package org.sopt.pawkey.backendapi.global.constants;

public final class AppConstants {
	// 예시 상수들
	public static final String API_PREFIX = "/api/v1";
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String SYSTEM_USER = "SYSTEM";
	public static final String JWT_HEADER = "Authorization";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String USER_ID_HEADER = "X-USER-ID";

	// Prevent instantiation
	private AppConstants() {
	}
}
