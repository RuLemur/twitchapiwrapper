import beans.StreamsData;
import beans.User;
import beans.UsersData;
import com.mb3364.http.AsyncHttpClient;
import com.mb3364.http.StringHttpResponseHandler;
import handlers.StreamsResponseHandler;
import handlers.UsersResponseHandler;
import resources.AbstractResource;
import resources.StreamsResource;
import resources.UsersResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuLemur on 15.10.2017 in 18:33.
 * TwitchApiWrapper
 */
public class Twitch {
    private static final String DEFAULT_BASE_URL = "https://api.twitch.tv/helix";
    private String clientId; // User's app client Id
    private Map<String, AbstractResource> resources;
    private String pagination;

    public Twitch() {
        resources = new HashMap<String, AbstractResource>();
        resources.put("users", new UsersResource(DEFAULT_BASE_URL));
        resources.put("streams", new StreamsResource(DEFAULT_BASE_URL));
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
        for (AbstractResource r : resources.values()) {
            r.setClientId(clientId);
        }
    }

    public UsersResource users() {
        return (UsersResource) getResource("users");
    }

    public StreamsResource streams() {
        return (StreamsResource) getResource("streams");
    }

    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    private AbstractResource getResource(String key) {
        return resources.get(key);
    }

    public String getPagination() {
        return pagination;
    }

}
