package rss.hyesoo.rss;


import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

public class Feed {
    private URL url;
    private String title;
    private ArrayList<Item> items;

    public Feed(URL url, String title) {
        this.url = url;
        this.items = new ArrayList<>();
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addItem(Item item) {
        items.add(item);
        // System.out.println("Just added one item");
    }

    public void displayItems() {
        for (Item i : items) {
            System.out.println(i.getTitle());
        }
    }

    public ArrayList<String> getItemTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (Item i : items) {
            titles.add(i.getTitle());
        }
        return titles;
    }

    public Item getItem(int pos) {
        return this.items.get(pos);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return this.title;
    }

    //check if the two feed objects are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Feed feed = (Feed) o;

        if (!url.equals(feed.url)) return false;
        return title.equals(feed.title);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }
}