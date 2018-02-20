import beans.data.UsersData;
import handlers.UsersResponseHandler;

public class Main {

    public static void main(String[] args) {
        final Twitch twitch = new Twitch();
        twitch.setClientId("smo0k1o7t0otmepejy137cg7wrmqz3g");
        String channelName = "dreadztv®";
        twitch.users().get(channelName, new UsersResponseHandler() {

            public void onFailure(int statusCode, String statusMessage, String errorMessage) {

            }

            public void onFailure(Throwable throwable) {

            }

            public void onSuccess(UsersData usersData) {
                for (int i = 0; i < usersData.getData().size(); i++) {
                    System.out.println(usersData.getData().get(i).toString());
                }
            }
        });
//        twitch.streams().get(new StreamsResponseHandler() {
//            public void onSuccess(StreamsData streamsData) {
//                for (int i = 0; i < streamsData.getData().size(); i++) {
//                    System.out.println(streamsData.getData().get(i).toString());
//                }
//                System.out.println("\nPAGINATION: " + streamsData.getPagination());
//                String pagination = streamsData.getPagination().toString();
//                twitch.setPagination(pagination);
//            }
//
//            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
//                System.out.println(statusCode);
//            }
//
//            public void onFailure(Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        });

    }
}
