package arjh.utdallas.edu.theia;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import arjh.utdallas.edu.theia.basics.activity.BasicMenuActivity;

public class DirectionsActivity extends BasicMenuActivity {

    public static final String EXTRA_DESTINATION_NAME = "directions.activity.destination.name";
    private ListView directionsListView;
    private ItemDeleter task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);
        setUpActionBar();

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        String destination = getIntent().getStringExtra(EXTRA_DESTINATION_NAME);
        ((TextView) findViewById(R.id.text_view_navigating_to))
                .setText(getString(R.string.label_text_view_navigating_to, destination));

        directionsListView = findViewById(R.id.list_view_directions);

        directionsListView.setAdapter(new MyAdapter(new ArrayList<>(Arrays.asList(
                "Head east for 5 feet and take the door on your right",
                "Turn left 90 degrees and walk 5 feet",
                "Turn right 90 degrees and walk straight for 30 feet",
                "Your destination will be on the left"))));
    }

    @Override
    protected void onResume() {
        super.onResume();
        task = new ItemDeleter(directionsListView);
        task.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (task != null) {
            task.cancel(true);
        }
    }

    private static class ItemDeleter extends AsyncTask<Void, Void, Void> {
        @SuppressLint("StaticFieldLeak")
        private final ListView listView;

        ItemDeleter(ListView listView) {
            this.listView = listView;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ListAdapter adapter = listView.getAdapter();
            while (adapter.getCount() > 0) {
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();
            String item = adapter.getItem(0);
            adapter.remove(item);
            Toast.makeText(listView.getContext(), item, Toast.LENGTH_SHORT).show();
        }
    }

    private class MyAdapter extends ArrayAdapter<String> {
        MyAdapter(@NonNull List<String> objects) {
            super(DirectionsActivity.this, android.R.layout.simple_list_item_1, objects);
        }

        @Override
        public boolean isEnabled(int position) {
            return position == 0;
        }
    }

}
