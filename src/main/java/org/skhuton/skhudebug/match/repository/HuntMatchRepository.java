package org.skhuton.skhudebug.match.repository;

import org.skhuton.skhudebug.match.domain.HuntReqManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntMatchRepository extends JpaRepository<HuntReqManagement, Long> {
    HuntReqManagement findBySenderId(String senderId);
}
