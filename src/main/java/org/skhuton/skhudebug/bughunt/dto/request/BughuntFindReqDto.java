package org.skhuton.skhudebug.bughunt.dto.request;

import java.math.BigDecimal;

public record BughuntFindReqDto(
        BigDecimal latitude,
        BigDecimal longitude
) {
}
