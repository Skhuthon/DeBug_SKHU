package org.skhuton.skhudebug.bughunt.dto.response;

import lombok.Builder;
import org.skhuton.skhudebug.bughunt.domain.Bughunt;
import org.skhuton.skhudebug.member.domain.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record BughuntInfoResDto(
        Long id, String loginId,
        BigDecimal latitude, BigDecimal longitude,
        int bugNum, String bugSize, String bugType,
        int radius, LocalDateTime createdAt
) {
    public static BughuntInfoResDto from(Bughunt bughunt) {
        return BughuntInfoResDto.builder()
                .id(bughunt.getId())
                .loginId(bughunt.getUser().getLoginId())    // User 정보 통째로 X, loginId 정보만 내보내기
                .latitude(bughunt.getLatitude())
                .longitude(bughunt.getLongitude())
                .bugNum(bughunt.getBugNum())
                .bugSize(bughunt.getBugSize())
                .bugType(bughunt.getBugType())
                .radius(bughunt.getRadius())
                .createdAt(bughunt.getCreatedAt())
                .build();
    }
}
