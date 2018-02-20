package handlers;

import beans.data.StreamsData;

/**
 * Created by RuLemur on 17.10.2017 in 13:45.
 * TwitchApiWrapper
 */
public interface StreamsResponseHandler extends BaseFailureHandler {
    void onSuccess(StreamsData streamsData);
}
