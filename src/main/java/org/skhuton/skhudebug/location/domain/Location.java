package org.skhuton.skhudebug.location.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long id;

    @Column(precision = 10, scale = 8)
    private BigDecimal latitude;    //BigDecimal 부동소수점 오류 방지(위도, 경도 정확 표현)

    @Column(precision = 11, scale = 8)
    private BigDecimal longitude;

    @Builder
    public Location(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
