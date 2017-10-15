package resources;

import beans.Users;
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

    public void get(final UsersResponseHandler handler) {
        String url = String.format("%s/users?login=thewide001", getBaseUrl());

        http.get(url, new TwitchHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    Users value = objectMapper.readValue(content, Users.class);
                    handler.onSuccess(value.getUserList());
                } catch (IOException ex) {
                    handler.onFailure(ex);
                }
            }
        });
    }
}
