package beans.entity;

public class Pagination {
    private String cursor;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    @Override
    public String toString() {
        return cursor;
    }
}
