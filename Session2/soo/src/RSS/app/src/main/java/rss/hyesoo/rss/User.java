package rss.hyesoo.rss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private static User ourInstance = new User();

    private ArrayList<Feed> feeds;

    public static User getInstance() {
        return ourInstance;
    }

    private User() {
        this.feeds = new ArrayList<>();
    }

    public ArrayList<Feed> getFeeds() {
        return this.feeds;
    }

    public Feed getFeed(int pos) {
        return this.feeds.get(pos);
    }

    public int feedCount() {
        return this.feeds.size();
    }

    public void addFeed(Feed feed) {
        if (!feeds.contains(feed)) {
            this.feeds.add(feed);
        }
    }
}

