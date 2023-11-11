package com.example.votingapp;

public class Voterr {
    String voteId;
    String voteNo;
    String voteGenre;

    public Voterr(){

    }

    public Voterr(String voteId, String voteNo, String voteGenre) {
        this.voteId = voteId;
        this.voteNo = voteNo;
        this.voteGenre = voteGenre;
    }

    public String getVoteId() {
        return voteId;
    }

    public String getVoteNo() {
        return voteNo;
    }

    public String getVoteGenre() {
        return voteGenre;
    }


}
