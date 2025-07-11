package org.sopt.pawkey.backendapi.domain.region.api.dto;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.region.application.dto.result.GetRegionListResult;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PROTECTED)
public record GetRegionListResponse(
	List<GuDongDto> guDongDtoList
) {
	public static GetRegionListResponse from(GetRegionListResult result) {
		return GetRegionListResponse.builder()
			.guDongDtoList(result.guDongDtoList().stream().map(GuDongDto::from).toList())
			.build();
	}

	@Builder(access = AccessLevel.PROTECTED)
	public record GuDongDto(
		RegionDto gu,
		List<RegionDto> dongs
	) {
		public static GuDongDto from(GetRegionListResult.GuDongDto guDongDto) {
			return GuDongDto.builder()
				.gu(RegionDto.from(guDongDto.gu()))
				.dongs(guDongDto.dongs().stream().map(RegionDto::from).toList())
				.build();
		}
	}

	@Builder(access = AccessLevel.PROTECTED)
	public record RegionDto(
		Long id,
		String name
	) {
		public static RegionDto from(GetRegionListResult.RegionDto regionDto) {
			return RegionDto.builder()
				.id(regionDto.id())
				.name(regionDto.name())
				.build();
		}
	}
}
