package arjh.utdallas.edu.theia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

import arjh.utdallas.edu.theia.basics.activity.BasicMenuActivity;

public class DestinationSelectionActivity extends BasicMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_selection);
        setUpActionBar();

        ((TextView) findViewById(R.id.text_view_welcome_to))
                .setText(getString(R.string.label_text_view_welcome_to, "JSOM Building"));

        ListView destinationsListView = findViewById(R.id.list_view_destinations);

        destinationsListView.setAdapter(
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        Arrays.asList("Restroom", "Drinking Fountain", "Elevator", "Exit")));

        destinationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DestinationSelectionActivity activity = DestinationSelectionActivity.this;
                CharSequence destinationName = ((TextView) view).getText();

                Intent intent = new Intent(activity, DirectionsActivity.class);
                intent.putExtra(DirectionsActivity.EXTRA_DESTINATION_NAME, destinationName);

                activity.startActivity(intent);
            }
        });
    }

}
