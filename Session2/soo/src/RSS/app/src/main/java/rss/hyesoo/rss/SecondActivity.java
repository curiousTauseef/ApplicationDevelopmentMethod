package rss.hyesoo.rss;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;

//Second Activity displays item list
public class SecondActivity extends AppCompatActivity {

    private ItemListAdapter adapter;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extra = getIntent().getExtras();
        pos = extra.getInt("Position");
        adapter = new ItemListAdapter(this, R.layout.activity_second, User.getInstance().getFeed(pos).getItems());
        ListView itemListV = (ListView) findViewById(R.id.ItemLv);
        itemListV.setAdapter(adapter);

        itemListV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(SecondActivity.this, ReadItem.class);
                intent.putExtra("itemURL",User.getInstance().getFeed(pos).getItem(pos).getLink());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
}
