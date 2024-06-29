package org.skhuton.skhudebug.rank.repository;

import org.skhuton.skhudebug.rank.domain.HuntTime;
import org.skhuton.skhudebug.rank.dto.HuntTimeRanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HuntTimeRepository extends JpaRepository<HuntTime, Long> {
    @Query("SELECT new org.skhuton.skhudebug.rank.dto.HuntTimeRankingImpl(h.user.nickname, h.times) FROM HuntTime h ORDER BY h.times DESC")
    List<HuntTimeRanking> findByOrderByTimesDesc();

    Optional<HuntTime> findByUser_LoginId(String loginId);
}
