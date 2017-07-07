package com.optym.hr.model;

import java.util.Date;

/**
 * Created by Areg on 7/2/2017.
 */
public class Schedule {
    private int id;
    private Date meetingDate;
    private String type;
    private String isCanceled;
    private String notes;
    private String candidate_Id;
    private String employee_Id;
    private Date cratedDate;
    private int createdBy;
    private Date modifiedDate;
    private int modifiedBy;
    private int position_Id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(String isCanceled) {
        this.isCanceled = isCanceled;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCandidate_Id() {
        return candidate_Id;
    }

    public void setCandidate_Id(String candidate_Id) {
        this.candidate_Id = candidate_Id;
    }

    public String getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(String employee_Id) {
        this.employee_Id = employee_Id;
    }

    public Date getCratedDate() {
        return cratedDate;
    }

    public void setCratedDate(Date cratedDate) {
        this.cratedDate = cratedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public int getPosition_Id() {
        return position_Id;
    }

    public void setPosition_Id(int position_Id) {
        this.position_Id = position_Id;
    }
}
