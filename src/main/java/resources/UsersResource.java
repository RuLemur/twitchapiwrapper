package resources;

import beans.UsersData;
import com.mb3364.http.RequestParams;
import handlers.StreamsResponseHandler;
import handlers.UsersResponseHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by RuLemur on 15.10.2017 in 22:23.
 * TwitchApiWrapper
 */
public class UsersResource extends AbstractResource {


    public UsersResource(String baseUrl) {
        super(baseUrl);
    }

    public void get(String channelName, final UsersResponseHandler handler) {
        String url = String.format("%s/users", getBaseUrl());
        RequestParams params = new RequestParams();
        params.put("login",channelName);
        http.get(url, params, new TwitchHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    UsersData usersData = objectMapper.readValue(content, UsersData.class);
                    handler.onSuccess(usersData);
                } catch (IOException ex) {
                    handler.onFailure(ex);
                }
            }
        });

    }
}
