package org.skhuton.skhudebug.match.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.match.domain.HuntReqManagement;
import org.skhuton.skhudebug.match.dto.CompleteHuntReqDto;
import org.skhuton.skhudebug.match.dto.MatchReqDto;
import org.skhuton.skhudebug.match.repository.HuntMatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final HuntMatchRepository huntMatchRepository;

    /**
     * 호출 수락
     * <p>
     * 1. 수락 버튼 클릭
     * 2. 벌레에 대한 정보와 호출한 유저, 수락한 유저의 아이디를 담은 요청 데이터 전송
     * 3. 요청 관리 테이블에서 수락 컬럼을 true로 변경
     * <p>
     * 요청관리테이블의 특정 컬럼들이 true가 될 때까지 벌레 잡은 상태로 취급하지 않음.
     */
    @Transactional
    public void acceptByHunter(MatchReqDto matchReqDto) {
        HuntReqManagement huntReqManagement = huntMatchRepository.findBySenderId(matchReqDto.senderId());
        huntReqManagement.setReceiveId(matchReqDto.receiveId());
        huntMatchRepository.save(huntReqManagement);
    }

    @Transactional
    public void completeMatch(CompleteHuntReqDto completeHuntReqDto) {
        HuntReqManagement huntReqManagement = huntMatchRepository.findByRequestId(completeHuntReqDto.requestId());
        huntMatchRepository.save(HuntReqManagement.builder()
                .id(huntReqManagement.getId())
                .requestId(huntReqManagement.getRequestId())
                .senderId(huntReqManagement.getSenderId())
                .receiveId(huntReqManagement.getReceiveId())
                .complete(true)
                .build());
    }
}