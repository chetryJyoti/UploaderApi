package com.moreOpp.dataUploader.UploaderApi.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scholarships")
public class Scholarship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sId;

    @Column(nullable = false)
    private String title;

    private String description;

    private String linkToRegister;

    private Date createdOn;

    private String lastDayToRegister;

    private String eligibility;

    private String bannerImgLink;

    private boolean active;

    public Scholarship() {
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
