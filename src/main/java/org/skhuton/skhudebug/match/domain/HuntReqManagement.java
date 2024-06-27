package org.skhuton.skhudebug.match.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HuntReqManagement {

    /**
     * 요청 관리 엔티티
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hunt_match_id")
    private Long id;

    @Column(name = "request_id", nullable = false)
    private Long requestId;

    @Column(name = "sender_id", nullable = false)
    private String senderId;

    @Column(name = "receive_id", nullable = false)
    private String receiveId;

    @Column(name = "complete", nullable = false)
    private boolean complete;
}
