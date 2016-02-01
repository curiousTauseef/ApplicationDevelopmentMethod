package rss.hyesoo.rss;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.net.MalformedURLException;
import java.net.URL;

//first Activity displays feed list and it connects with Second activity by the intent
public class MainActivity extends AppCompatActivity implements MyObserver {

    final MyObserver o = this;
    private FeedListAdapter adapter;
    private ListView feedsListV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            User.getInstance().addFeed(new Feed(new URL("http://feeds.bbci.co.uk/news/rss.xml"), "BBC"));
            User.getInstance().addFeed(new Feed(new URL("http://www.npr.org/rss/rss.php?id=1008"), "NPR"));
            User.getInstance().addFeed(new Feed(new URL("http://www.nasa.gov/rss/dyn/image_of_the_day.rss"), "Nasa News"));
            User.getInstance().addFeed(new Feed(new URL("http://www.techlearning.com/RSS"), "Tech Learning"));
        } catch (MalformedURLException e) {
            System.err.println(e);
        }

        Thread feedReader = new Thread(new FeedReader(User.getInstance().getFeeds(), o));
        feedReader.start();

        adapter = new FeedListAdapter(this, R.layout.activity_main, User.getInstance().getFeeds());
        feedsListV = (ListView) findViewById(R.id.feedsLv);
        feedsListV.setAdapter(adapter);

        feedsListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void updateUI(Runnable rf) {
        final Runnable readFeed = rf;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ListView feedsLV = (ListView) findViewById(R.id.feedsLv);
                ListView itemsLV = (ListView) findViewById(R.id.ItemLv);
                //TextView ItemV = (TextView) findViewById(R.id.itemRow);

            }
        });
    }


}

