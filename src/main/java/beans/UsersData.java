package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by RuLemur on 16.10.2017 in 1:27.
 * TwitchApiWrapper
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersData {

    List<Users> data;

    public List<Users> getData() {
        return data;
    }

    public void setData(List<Users> data) {
        this.data = data;
    }
}
