package org.skhuton.skhudebug.match.dto;

import lombok.Builder;

public record MatchReqDto(
        String senderId,
        String receiveId,
        Long requestId
) {
    @Builder
    public static MatchReqDto from(String senderId, String receiveId, Long requestId) {
        return MatchReqDto.builder()
                .senderId(senderId)
                .receiveId(receiveId)
                .requestId(requestId)
                .build();
    }
}
