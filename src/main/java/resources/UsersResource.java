package resources;

import beans.User;
import beans.Users;
import handlers.UsersResponseHandler;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        String url = String.format("%s/users/follows?to_id=23161357 ", getBaseUrl());

        http.get(url, new TwitchHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {

                    List<User> value = Arrays.asList(
                            objectMapper.treeToValue(objectMapper.readTree(content).get("data"), User[].class));
                    handler.onSuccess(value);
                } catch (IOException ex) {
                    handler.onFailure(ex);
                }
            }
        });

    }
}
