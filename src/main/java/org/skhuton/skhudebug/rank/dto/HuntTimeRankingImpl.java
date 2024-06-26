package org.skhuton.skhudebug.rank.dto;

public class HuntTimeRankingImpl implements HuntTimeRanking {
    private final String nickname;
    private final Integer times;

    public HuntTimeRankingImpl(String nickname, Integer times) {
        this.nickname = nickname;
        this.times = times;
    }

    @Override
    public String getNickname() {
        return nickname;
    }

    @Override
    public Integer getTimes() {
        return times;
    }
}