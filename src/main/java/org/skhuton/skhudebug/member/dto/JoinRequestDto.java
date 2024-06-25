package org.skhuton.skhudebug.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.skhuton.skhudebug.member.domain.Role;
import org.skhuton.skhudebug.member.domain.User;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JoinRequestDto {
    private String loginId;

    private String password;

    private String nickname;
}
