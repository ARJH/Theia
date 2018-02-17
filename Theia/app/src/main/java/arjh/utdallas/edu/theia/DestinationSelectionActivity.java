package arjh.utdallas.edu.theia;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

import arjh.utdallas.edu.theia.basics.activity.BasicMenuActivity;

public class DestinationSelectionActivity extends BasicMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_selection);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView destinationsListView = findViewById(R.id.list_view_destinations);

        destinationsListView.setAdapter(
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        Arrays.asList("Restroom", "Drinking Fountain", "Elevator", "Exit")));
    }
}
