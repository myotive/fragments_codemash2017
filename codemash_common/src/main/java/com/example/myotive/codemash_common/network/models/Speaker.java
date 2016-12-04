package com.example.myotive.codemash_common.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Created by michaelyotive_hr on 12/3/16.
 */

public class Speaker {
    @SerializedName("Id")
    @Expose
    private UUID id;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("Biography")
    @Expose
    private String biography;
    @SerializedName("GravatarUrl")
    @Expose
    private String gravatarUrl;
    @SerializedName("TwitterLink")
    @Expose
    private String twitterLink;
    @SerializedName("GitHubLink")
    @Expose
    private String gitHubLink;
    @SerializedName("LinkedInProfile")
    @Expose
    private String linkedInProfile;
    @SerializedName("BlogUrl")
    @Expose
    private String blogUrl;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getGravatarUrl() {
        return gravatarUrl;
    }

    public void setGravatarUrl(String gravatarUrl) {
        this.gravatarUrl = gravatarUrl;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        this.gitHubLink = gitHubLink;
    }

    public String getLinkedInProfile() {
        return linkedInProfile;
    }

    public void setLinkedInProfile(String linkedInProfile) {
        this.linkedInProfile = linkedInProfile;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }
}
