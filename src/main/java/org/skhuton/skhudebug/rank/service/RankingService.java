package org.skhuton.skhudebug.rank.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.skhuton.skhudebug.rank.dto.HuntTimeRanking;
import org.skhuton.skhudebug.rank.repository.HuntTimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final HuntTimeRepository huntTimeRepository;

    @Transactional(readOnly = true)
    public List<HuntTimeRanking> getRanking() {
        return huntTimeRepository.findByOrderByTimesDesc();
    }
}
