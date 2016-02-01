package rss.hyesoo.rss;


import java.util.ArrayList;


public class FeedReader implements Runnable, MyObserver {

    private ArrayList<Feed> feeds;
    private MyObserver observer;

    public FeedReader(ArrayList<Feed> feeds, MyObserver o) {
        this.feeds = feeds;
        this.observer = o;
    }

    @Override
    public void run() {
        int size = feeds.size();
        for (Feed f : feeds) {
            Thread[] readFeed = new Thread[size];
            for (int i = 0; i < readFeed.length; i++) {
                readFeed[i] = new Thread(new ReadFeed(f.getUrl(), f, observer));
                readFeed[i].start();
            }
            observer.updateUI(this);
        }
    }

    public void updateUI(Runnable rf) {
    }
}
