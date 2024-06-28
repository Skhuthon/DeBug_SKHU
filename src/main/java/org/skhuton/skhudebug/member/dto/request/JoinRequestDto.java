package org.skhuton.skhudebug.member.dto.request;

public record JoinRequestDto(

        String loginId,

        String password,

        String nickname
) {
}
