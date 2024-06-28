package org.skhuton.skhudebug.bughunt.dto.request;

import lombok.Getter;

import java.math.BigDecimal;
public record BughuntLocationReqDto(
        BigDecimal latitude,
        BigDecimal longitude,
        int radius
) {
    @Override
    public BigDecimal latitude() {
        return latitude;
    }

    @Override
    public BigDecimal longitude() {
        return longitude;
    }

    @Override
    public int radius() {
        return radius;
    }
}
