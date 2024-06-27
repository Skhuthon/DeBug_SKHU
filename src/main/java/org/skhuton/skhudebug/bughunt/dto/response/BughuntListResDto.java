package org.skhuton.skhudebug.bughunt.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record BughuntListResDto(
        List<BughuntInfoResDto> bughunts
) {
    public static BughuntListResDto from(List<BughuntInfoResDto> bughunts) {
        return BughuntListResDto.builder()
                .bughunts(bughunts)
                .build();
    }
}
