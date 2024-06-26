package org.skhuton.skhudebug.location.dto;

import java.math.BigDecimal;

public record LocationSaveReqDto(
        String loginId, // login id
        BigDecimal latitude,
        BigDecimal  longitude
) {
}
