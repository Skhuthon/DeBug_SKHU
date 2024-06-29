package org.skhuton.skhudebug.rank.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.skhuton.skhudebug.rank.dto.HuntTimeRanking;
import org.skhuton.skhudebug.rank.repository.HuntTimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final HuntTimeRepository huntTimeRepository;
    private final UserRepository userRepository;

public List<HuntTimeRanking> getRanking() {
    return huntTimeRepository.findByOrderByTimesDesc();
}
}
