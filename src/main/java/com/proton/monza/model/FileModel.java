package com.proton.monza.model;

import java.util.Date;
import java.util.List;

public class FileModel {
    private String fileName;
    private List<String> content;
    private Date uploadDate;
    private Integer referenceYear;

    public FileModel(String fileName, List<String> content, Date uploadDate, Integer referenceYear) {
        this.fileName = fileName;
        this.content = content;
        this.uploadDate = uploadDate;
        this.referenceYear = referenceYear;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getReferenceYear() {
        return referenceYear;
    }

    public void setReferenceYear(Integer referenceYear) {
        this.referenceYear = referenceYear;
    }
}
