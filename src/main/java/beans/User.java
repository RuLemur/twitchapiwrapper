package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by RuLemur on 15.10.2017 in 18:00.
 * TwitchApiWrapper
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String id;
    private String broadcaster_type;
    private String description;
    private String display_name;
    private String email;
    private String login;
    private String offline_image_url;
    private String profile_image_url;
    private String type;
    private String view_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBroadcaster_type() {
        return broadcaster_type;
    }

    public void setBroadcaster_type(String broadcaster_type) {
        this.broadcaster_type = broadcaster_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOffline_image_url() {
        return offline_image_url;
    }

    public void setOffline_image_url(String offline_image_url) {
        this.offline_image_url = offline_image_url;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + login + '\'' +
                ", id=" + id +
                ", displayName='" + display_name + '\'' +
                ", type='" + type + '\'' +
                ", bio='" + description + '\'' +
                ", view_count=" + view_count +
                '}';
    }

}
