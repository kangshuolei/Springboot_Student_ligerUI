package com.student.model;

public class Course {
    private Integer csId;

    private String csName;

    private String csDescription;

    public Integer getCsId() {
        return csId;
    }

    public void setCsId(Integer csId) {
        this.csId = csId;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName == null ? null : csName.trim();
    }

    public String getCsDescription() {
        return csDescription;
    }

    public void setCsDescription(String csDescription) {
        this.csDescription = csDescription == null ? null : csDescription.trim();
    }
}