package org.skhuton.skhudebug.bughunt.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.skhuton.skhudebug.member.domain.User;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bughunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bughunt_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="userId", nullable = false)
    private User user;

    @Column(precision = 10, scale = 8)
    private BigDecimal latitude;    //BigDecimal 부동소수점 오류 방지(위도, 경도 정확 표현)

    @Column(precision = 11, scale = 8)
    private BigDecimal longitude;

    private int bugNum;
    private String bugSize;
    private String bugType;
    private int range;

    @Builder
    public Bughunt(User user, BigDecimal latitude, BigDecimal longitude) {
        this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
