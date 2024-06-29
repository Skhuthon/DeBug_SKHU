package org.skhuton.skhudebug.match.service;

import lombok.RequiredArgsConstructor;
import org.skhuton.skhudebug.match.domain.HuntReqManagement;
import org.skhuton.skhudebug.match.dto.CompleteHuntReqDto;
import org.skhuton.skhudebug.match.dto.MatchReqDto;
import org.skhuton.skhudebug.match.repository.HuntMatchRepository;
import org.skhuton.skhudebug.member.repository.UserRepository;
import org.skhuton.skhudebug.rank.domain.HuntTime;
import org.skhuton.skhudebug.rank.repository.HuntTimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final HuntMatchRepository huntMatchRepository;
    private final HuntTimeRepository huntTimeRepository;
    private final UserRepository userRepository;
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

    /*
     * 헌트 요청 건의 처리를 완료했을 때 실행하는 메소드
     * 1. 요청 관리 테이블에서 요청 아이디를 통해 요청을 찾아서 완료 컬럼을 true로 변경
     * 2. 헌트 요청을 수락한 유저에 관한 정보를 HuntTime 테이블에서 찾아봄.
     * 3. HuntTime 테이블에 해당 유저의 정보가 있으면 헌트 횟수를 1 증가시키고 저장
     * 4. HuntTime 테이블에 해당 유저의 정보가 없으면 헌트 횟수를 1로 초기화하고 저장
     */
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

        huntTimeRepository.findByUser_LoginId(huntReqManagement.getReceiveId())
                .ifPresentOrElse(huntTime -> {
                    huntTime.setTimes(huntTime.getTimes() + 1);
                    huntTimeRepository.save(huntTime);
                }, () -> {
                    huntTimeRepository.save(HuntTime.builder()
                            .times(1)
                            .user(userRepository.findByLoginId(huntReqManagement.getReceiveId()).get())
                            .build());
                });
    }
}