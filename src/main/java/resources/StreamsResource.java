package resources;

import beans.StreamsData;
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
public class StreamsResource extends AbstractResource {

    public StreamsResource(String baseUrl) {
        super(baseUrl);
    }

    public void get(final StreamsResponseHandler handler) {
        String url = String.format("%s/streams", getBaseUrl());
        RequestParams params = new RequestParams();
        params.put("first", "100");
//        params.put("login", "lemur_ru");
        http.get(url,params, new TwitchHttpResponseHandler(handler) {
            @Override
            public void onSuccess(int statusCode, Map<String, List<String>> headers, String content) {
                try {
                    StreamsData streamsData = objectMapper.readValue(content, StreamsData.class);
                    handler.onSuccess(streamsData);
                } catch (IOException ex) {
                    handler.onFailure(ex);
                }
            }
        });

    }
}
