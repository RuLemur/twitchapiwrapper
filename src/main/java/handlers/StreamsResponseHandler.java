package handlers;

import beans.StreamsData;
import beans.UsersData;

/**
 * Created by RuLemur on 17.10.2017 in 13:45.
 * TwitchApiWrapper
 */
public interface StreamsResponseHandler extends BaseFailureHandler {
    void onSuccess(StreamsData streamsData);
}
