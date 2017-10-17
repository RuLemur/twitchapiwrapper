package beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by RuLemur on 17.10.2017 in 13:45.
 * TwitchApiWrapper
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamsData {

    List<Stream> data;

    public List<Stream> getData() {
        return data;
    }

    public void setData(List<Stream> data) {
        this.data = data;
    }
}
