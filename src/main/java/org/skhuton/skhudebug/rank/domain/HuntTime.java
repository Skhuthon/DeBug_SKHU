package org.skhuton.skhudebug.rank.domain;

import jakarta.persistence.*;
import lombok.*;
import org.skhuton.skhudebug.member.domain.User;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HuntTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //벌레 잡기 횟수
    private int times;
}
