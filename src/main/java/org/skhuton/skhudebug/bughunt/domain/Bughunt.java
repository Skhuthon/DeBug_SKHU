package org.skhuton.skhudebug.bughunt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.skhuton.skhudebug.member.domain.User;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(precision = 10, scale = 8, nullable = false)
    private BigDecimal latitude;

    @Column(precision = 11, scale = 8, nullable = false)
    private BigDecimal longitude;

    private int bugNum;
    private String bugSize;
    private String bugType;
    private int radius;

    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Builder
    public Bughunt(User user, BigDecimal latitude, BigDecimal longitude, int bugNum, String bugSize, String bugType, int radius, LocalDateTime createdAt) {
        this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
        this.bugNum = bugNum;
        this.bugSize = bugSize;
        this.bugType = bugType;
        this.radius = radius;
        this.createdAt = LocalDateTime.now();
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
