package beans.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by RuLemur on 17.10.2017 in 13:40.
 * TwitchApiWrapper
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stream {

    private long id;
    private String user_id;
    private String game_id;
    private List<String> community_ids;
    private String type;
    private String title;
    private String viewer_count;
    private Date started_at;
    private String language;
    private String thumbnail_url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = userId;
    }

    public String getGameId() {
        return game_id;
    }

    public void setGameId(String gameId) {
        this.game_id = gameId;
    }

    public List<String> getCommunity_ids() {
        return community_ids;
    }

    public void setCommunity_ids(List<String> community_ids) {
        this.community_ids = community_ids;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewer_count() {
        return viewer_count;
    }

    public void setViewer_count(String viewer_count) {
        this.viewer_count = viewer_count;
    }

    public Date getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Date started_at) {
        this.started_at = started_at;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    @Override
    public String toString() {
        return "Stream{" +
                " id=" + id +
                ", type='" + type + '\'' +
                ", bio='" + title + '\'' +
                ", view_count=" + viewer_count +
//                ", start_Date=" + started_at.toString() +
                '}';
    }
}
