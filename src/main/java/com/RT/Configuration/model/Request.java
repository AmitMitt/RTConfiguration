package com.RT.Configuration.model;

public class Request {

    private String name;
    private String displayName;
    private String androidAction;
    private String iosAction;
    private String webAction;
    private String routerLink;
    private String imageUrl;
    private boolean status;
    private String description;
    private String type;
    private String roleName;
    private long priority;
    private boolean isDisable;

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        isDisable = disable;
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

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
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
                ", isDisable=" + isDisable +
                '}';
    }
}
