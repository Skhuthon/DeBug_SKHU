package org.skhuton.skhudebug.member.dto;

import org.skhuton.skhudebug.member.domain.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequestDto {

    private String loginId;
    private String password;
    private Role role;

}
