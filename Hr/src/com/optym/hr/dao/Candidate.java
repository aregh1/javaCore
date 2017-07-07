package com.optym.hr.dao;

/**
 * Created by Areg on 7/8/2017.
 */
public interface Candidate {
        int add(Candidate candidate);
        void delete(Candidate candidate);
        Candidate getCandidate(int id);
        void changeCandidateStatus(int id);
        void setCandidate(Candidate candidate);
}
