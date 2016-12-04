package com.example.myotive.codemash_common.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelyotive_hr on 12/3/16.
 */

public class Session {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("SessionTime")
    @Expose
    private String sessionTime;
    @SerializedName("SessionStartTime")
    @Expose
    private DateTime sessionStartTime;
    @SerializedName("SessionEndTime")
    @Expose
    private DateTime sessionEndTime;
    @SerializedName("Rooms")
    @Expose
    private List<String> rooms = null;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Abstract")
    @Expose
    private String _abstract;
    @SerializedName("SessionType")
    @Expose
    private String sessionType;
    @SerializedName("Tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("Speakers")
    @Expose
    private List<Speaker> speakers = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public DateTime getSessionStartTime() {
        return sessionStartTime;
    }

    public void setSessionStartTime(DateTime sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
    }

    public DateTime getSessionEndTime() {
        return sessionEndTime;
    }

    public void setSessionEndTime(DateTime sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
