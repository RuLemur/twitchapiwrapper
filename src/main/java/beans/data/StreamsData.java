package beans.data;

import beans.entity.Pagination;
import beans.entity.Stream;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by RuLemur on 17.10.2017 in 13:45.
 * TwitchApiWrapper
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamsData {

    List<Stream> data;
    private Pagination pagination;

    public List<Stream> getData() {
        return data;
    }

    public void setData(List<Stream> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
