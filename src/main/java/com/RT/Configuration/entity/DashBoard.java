package com.RT.Configuration.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@SQLDelete(sql = "update DashBoard set deleted=true where id=?")
@Where(clause = "deleted=false")
public class DashBoard implements Comparable<DashBoard>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String displayName;

    @Column
    private String androidAction;

    @Column
    private String iosAction;

    @Column
    private String webAction;

    @Column
    private String routerLink;

    @Column(columnDefinition = "Text")
    private String imageUrl;

    @Column
    private boolean status;

    @Column
    private String description;

    @Column
    private String type;

    @Column
    private String roleName;

    @Column
    private long priority;

    @Column
    private boolean deleted;

    @Column
    private long createdOn;

    @Column
    private long modifiedOn;

    @Column
    private boolean isDisable;

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAndroidAction() {
        return androidAction;
    }

    public void setAndroidAction(String androidAction) {
        this.androidAction = androidAction;
    }

    public String getIosAction() {
        return iosAction;
    }

    public void setIosAction(String iosAction) {
        this.iosAction = iosAction;
    }

    public String getWebAction() {
        return webAction;
    }

    public void setWebAction(String webAction) {
        this.webAction = webAction;
    }

    public String getRouterLink() {
        return routerLink;
    }

    public void setRouterLink(String routerLink) {
        this.routerLink = routerLink;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public long getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(long modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Override
    public int compareTo(DashBoard o) {

        if(this.priority == o.priority){
            return -1;
        }
        else if(this.priority>o.priority){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "DashBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", androidAction='" + androidAction + '\'' +
                ", iosAction='" + iosAction + '\'' +
                ", webAction='" + webAction + '\'' +
                ", routerLink='" + routerLink + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", roleName='" + roleName + '\'' +
                ", priority=" + priority +
                ", deleted=" + deleted +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", isDisable=" + isDisable +
                '}';
    }
}
