package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by RuLemur on 15.10.2017 in 22:59.
 * TwitchApiWrapper
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "data")
public class Users {

    List<User> userList;

    public List<User> getUserList() {
        return userList;
    }
}
