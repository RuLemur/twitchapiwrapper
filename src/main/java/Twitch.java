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

    private AbstractResource getResource(String key) {
        return resources.get(key);
    }


    public static void main(String[] args) {
        Twitch twitch = new Twitch();
        twitch.setClientId("smo0k1o7t0otmepejy137cg7wrmqz3g");
//       twitch.users().get(new UsersResponseHandler() {
//           public void onSuccess(UsersData usersData) {
//               System.out.println(usersData.getData().get(0).toString());
//           }
//           public void onFailure(int statusCode, String statusMessage, String errorMessage) {
//
//           }
//
//           public void onFailure(Throwable throwable) {
//
//           }
//       });

        twitch.streams().get(new StreamsResponseHandler() {
            public void onSuccess(StreamsData streamsData) {
                for (int i = 0; i < streamsData.getData().size(); i++) {
                    System.out.println(streamsData.getData().get(i).toString());
                }
                System.out.println("\nPAGINATION: " + streamsData.getPagination());

            }

            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode);
            }

            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
