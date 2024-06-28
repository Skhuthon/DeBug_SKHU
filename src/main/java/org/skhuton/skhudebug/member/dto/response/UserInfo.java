package org.skhuton.skhudebug.member.dto.response;

import lombok.Builder;

@Builder
public record UserInfo(
        String loginId,
        String nickname
) {
}
