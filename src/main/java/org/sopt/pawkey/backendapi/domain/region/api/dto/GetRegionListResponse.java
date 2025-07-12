package org.sopt.pawkey.backendapi.domain.region.api.dto;

import java.util.List;

import org.sopt.pawkey.backendapi.domain.region.application.dto.result.GetRegionListResult;

import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PROTECTED)
public record GetRegionListResponse(
	List<DistrictDto> districtDtos
) {
	public static GetRegionListResponse from(GetRegionListResult result) {
		return GetRegionListResponse.builder()
			.districtDtos(result.districtDtos().stream().map(DistrictDto::from).toList())
			.build();
	}

	@Builder(access = AccessLevel.PROTECTED)
	public record DistrictDto(
		RegionDto gu,
		List<RegionDto> dongs
	) {
		public static DistrictDto from(GetRegionListResult.DistrictDto guDongDto) {
			return DistrictDto.builder()
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
