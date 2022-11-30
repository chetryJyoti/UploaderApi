package com.moreOpp.dataUploader.UploaderApi.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Internships")
public class Internship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inId;

    @Column(nullable = false)
    private String companyName;

    private String internshipTitle;

    private boolean active;

    private String workLocation;

    private String stipend;

    private String description;

    private String linkToRegister;

    private Date createdOn;

    private String lastDayToRegister;

    private String eligibility;

    private String bannerImgLink;

    public Internship() {
    }

    public Long getInId() {
        return inId;
    }

    public void setInId(Long inId) {
        this.inId = inId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInternshipTitle() {
        return internshipTitle;
    }

    public void setInternshipTitle(String internshipTitle) {
        this.internshipTitle = internshipTitle;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public String getStipend() {
        return stipend;
    }

    public void setStipend(String stipend) {
        this.stipend = stipend;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkToRegister() {
        return linkToRegister;
    }

    public void setLinkToRegister(String linkToRegister) {
        this.linkToRegister = linkToRegister;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastDayToRegister() {
        return lastDayToRegister;
    }

    public void setLastDayToRegister(String lastDayToRegister) {
        this.lastDayToRegister = lastDayToRegister;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getBannerImgLink() {
        return bannerImgLink;
    }

    public void setBannerImgLink(String bannerImgLink) {
        this.bannerImgLink = bannerImgLink;
    }
}
