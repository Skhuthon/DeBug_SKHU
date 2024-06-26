package org.skhuton.skhudebug.bughunt.dto;

import java.math.BigDecimal;

public record BughuntSaveReqDto(
        String loginId,
        BigDecimal latitude,
        BigDecimal longitude,
        int bugNum,
        String bugSize,
        String bugType,
        int radius
) {
}
