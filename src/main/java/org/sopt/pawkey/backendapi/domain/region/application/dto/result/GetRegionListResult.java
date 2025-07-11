package org.sopt.pawkey.backendapi.domain.region.application.dto.result;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.region.infra.persistence.entity.RegionEntity;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PROTECTED)
public record GetRegionListResult(
	List<GuDongDto> guDongDtoList
) {
	public static GetRegionListResult from(List<RegionEntity> regions) {
		if (regions == null) {
			return GetRegionListResult.builder().guDongDtoList(List.of()).build();
		}

		return GetRegionListResult
			.builder()
			.guDongDtoList(
				regions.stream()
					.map(GuDongDto::from)
					.toList()
			)
			.build();
	}

	@Builder(access = AccessLevel.PROTECTED)
	public record GuDongDto(
		RegionDto gu,
		List<RegionDto> dongs
	) {
		public static GuDongDto from(RegionEntity region) {
			return GuDongDto
				.builder()
				.gu(RegionDto.from(region))
				.dongs(region.getChildrenRegionList().stream().map(RegionDto::from).toList())
				.build();
		}
	}

	@Builder(access = AccessLevel.PROTECTED)
	public record RegionDto(
		Long id,
		String name
	) {
		public static RegionDto from(RegionEntity entity) {
			return RegionDto.builder()
				.id(entity.getRegionId())
				.name(entity.getRegionName())
				.build();
		}
	}
}
