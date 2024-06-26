package org.skhuton.skhudebug.bughunt.dto;

import java.math.BigDecimal;

public record BughuntSaveReqDto(
        String loginId, // login id
        BigDecimal latitude,
        BigDecimal  longitude
) {
}
