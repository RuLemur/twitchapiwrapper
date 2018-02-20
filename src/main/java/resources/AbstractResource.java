package resources;

import beans.entity.Error;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mb3364.http.AsyncHttpClient;
import com.mb3364.http.StringHttpResponseHandler;
import handlers.BaseFailureHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by RuLemur on 15.10.2017 in 22:18.
 * TwitchApiWrapper
 */
public abstract class AbstractResource {

    protected static final ObjectMapper objectMapper = new ObjectMapper(); // can reuse
    protected static final AsyncHttpClient http = new AsyncHttpClient(); // can reuse
    private final String baseUrl; // Base url for twitch rest api

    protected AbstractResource(String baseUrl) {
        this.baseUrl = baseUrl;
        configureObjectMapper();
    }

    private void configureObjectMapper() {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
//        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    }

    public void setAuthAccessToken(String accessToken) {
        if (accessToken != null && accessToken.length() > 0) {
            http.setHeader("Authorization", String.format("OAuth %s", accessToken));
        } else {
            http.removeHeader("Authorization");
        }
    }

    public void setClientId(String clientId) {
        if (clientId != null && clientId.length() > 0) {
            http.setHeader("Client-ID", clientId);
        } else {
            http.removeHeader("Client-ID");
        }
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    protected static abstract class TwitchHttpResponseHandler extends StringHttpResponseHandler {

        private BaseFailureHandler apiHandler;

        public TwitchHttpResponseHandler(BaseFailureHandler apiHandler) {
            this.apiHandler = apiHandler;
        }

        @Override
        public abstract void onSuccess(int statusCode, Map<String, List<String>> headers, String content);

        @Override
        public void onFailure(int statusCode, Map<String, List<String>> headers, String content) {
            try {
                if (content.length() > 0) {
                    Error error = objectMapper.readValue(content, Error.class);
                    apiHandler.onFailure(statusCode, error.getStatusText(), error.getMessage());
                } else {
                    apiHandler.onFailure(statusCode, "", "");
                }
            } catch (IOException e) {
                apiHandler.onFailure(e);
            }
        }

        @Override
        public void onFailure(Throwable throwable) {
            apiHandler.onFailure(throwable);
        }
    }
}

