package rss.hyesoo.rss;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class ReadFeed implements Runnable {

    private URL URL;
    private Feed feed;
    private MyObserver observer;
    private String title = "title";
    private String link = "link";
    private String description = "description";
    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;

    public ReadFeed(URL URL, Feed feed, MyObserver observer) {
        this.URL = URL;
        this.feed = feed;
        this.observer = observer;
    }

    public String getTitle() {
        return title;
    }

    public java.net.URL getURL() {
        return URL;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text = null;

        try {
            event = myParser.getEventType();
            Item item = null;
            boolean checkItem = true;
            boolean newItem = false;

            while (event != XmlPullParser.END_DOCUMENT) {
                String name = myParser.getName();
                if(checkItem){
                    item = new Item();
                    checkItem = false;
                }

                switch (event) {
                    case XmlPullParser.START_TAG:
                        if (name.equals("item")) {
                            newItem = true;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        switch (name) {
                            case "title":
                                if (newItem) {
                                    item.setTitle(text);
                                    // System.out.println("Just set title :" + text);
                                }
                                break;
                            case "description":
                                if (newItem) {
                                    item.setDescription(text);
                                    // System.out.println("Just set description:" + text);
                                }
                                break;
                            case "link":
                                if (newItem) {
                                    item.setLink(text);
                                    // System.out.println("Just set link:" + text);
                                }
                                break;
                        }
                        break;
                }

                if(item.itemReady()){
                    feed.addItem(item);
                    newItem = false;
                    checkItem = true;
                }
                //create item and add to an array list
                event = myParser.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override

    public void run() {
        try {
            System.out.println("You have URL connection: this.URL!" + this.URL);


            URLConnection myConn = this.URL.openConnection();
            myConn.connect();
            InputStream stream = myConn.getInputStream();

            xmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myparser = xmlFactoryObject.newPullParser();

            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(stream, null);

            parseXMLAndStoreIt(myparser);
            stream.close();
            //observer.updateUI(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}