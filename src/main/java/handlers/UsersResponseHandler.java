package handlers;

import beans.User;
import beans.Users;

import java.util.List;

/**
 * Created by RuLemur on 15.10.2017 in 22:43.
 * TwitchApiWrapper
 */
public interface UsersResponseHandler extends BaseFailureHandler {
    void onSuccess(List<User> users);
}
