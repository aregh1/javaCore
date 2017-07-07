package com.optym.hr.model;

/**
 * Created by Areg on 7/2/2017.
 */
public class EvaluationForm {
    private int id;
    private String notes;
    private int recommendPositionId;
    private String createdDate;
    private int createdBy;
    private String jsonData;
    private int scheduleInterviewer_Id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getRecommendPositionId() {
        return recommendPositionId;
    }

    public void setRecommendPositionId(int recommendPositionId) {
        this.recommendPositionId = recommendPositionId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    public int getScheduleInterviewer_Id() {
        return scheduleInterviewer_Id;
    }

    public void setScheduleInterviewer_Id(int scheduleInterviewer_Id) {
        this.scheduleInterviewer_Id = scheduleInterviewer_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationForm that = (EvaluationForm) o;

        if (getId() != that.getId()) return false;
        if (getRecommendPositionId() != that.getRecommendPositionId()) return false;
        if (getCreatedBy() != that.getCreatedBy()) return false;
        if (getScheduleInterviewer_Id() != that.getScheduleInterviewer_Id()) return false;
        if (getNotes() != null ? !getNotes().equals(that.getNotes()) : that.getNotes() != null) return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(that.getCreatedDate()) : that.getCreatedDate() != null)
            return false;
        return getJsonData() != null ? getJsonData().equals(that.getJsonData()) : that.getJsonData() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getNotes() != null ? getNotes().hashCode() : 0);
        result = 31 * result + getRecommendPositionId();
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + getCreatedBy();
        result = 31 * result + (getJsonData() != null ? getJsonData().hashCode() : 0);
        result = 31 * result + getScheduleInterviewer_Id();
        return result;
    }
}
