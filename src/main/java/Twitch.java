import beans.User;
import com.mb3364.http.AsyncHttpClient;
import com.mb3364.http.StringHttpResponseHandler;
import handlers.UsersResponseHandler;
import resources.AbstractResource;
import resources.UsersResource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by RuLemur on 15.10.2017 in 18:33.
 * TwitchApiWrapper
 */
public class Twitch {
    public static final String DEFAULT_BASE_URL = "https://api.twitch.tv/helix";
    private String clientId; // User's app client Id
    private Map<String, AbstractResource> resources;

    public Twitch() {
        resources = new HashMap<String, AbstractResource>();
        resources.put("users", new UsersResource(DEFAULT_BASE_URL));
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

    private AbstractResource getResource(String key) {
        return resources.get(key);
    }


    public static void main(String[] args) {
       Twitch twitch = new Twitch();
       twitch.setClientId("smo0k1o7t0otmepejy137cg7wrmqz3g");
       twitch.users().get(new UsersResponseHandler() {
           public void onSuccess(List<User> users) {
               System.out.println(users);
           }

           public void onFailure(int statusCode, String statusMessage, String errorMessage) {

           }

           public void onFailure(Throwable throwable) {

           }
       });
    }
}
