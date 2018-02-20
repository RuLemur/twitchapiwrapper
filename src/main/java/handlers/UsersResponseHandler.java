package handlers;

import beans.data.UsersData;

/**
 * Created by RuLemur on 15.10.2017 in 22:43.
 * TwitchApiWrapper
 */
public interface UsersResponseHandler extends BaseFailureHandler {
    void onSuccess(UsersData usersData);
}
