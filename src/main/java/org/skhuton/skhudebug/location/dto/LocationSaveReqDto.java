package org.skhuton.skhudebug.location.dto;

import java.math.BigDecimal;

public record LocationSaveReqDto(
        String userId,
        BigDecimal latitude,
        BigDecimal  longitude
) {
}
