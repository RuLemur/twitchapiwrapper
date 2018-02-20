package beans.data;

import beans.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by RuLemur on 16.10.2017 in 1:27.
 * TwitchApiWrapper
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersData {

    List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
