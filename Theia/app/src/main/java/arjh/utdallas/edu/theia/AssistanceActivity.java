package arjh.utdallas.edu.theia;

import android.os.Bundle;
import android.view.Menu;

import arjh.utdallas.edu.theia.basics.activity.BasicMenuActivity;

public class AssistanceActivity extends BasicMenuActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);

        if (result && menu.findItem(R.id.menu_item_people_around_me) != null) {
            // We are already in this activity
            menu.removeItem(R.id.menu_item_people_around_me);
        }

        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);
        setUpActionBar();
    }

}
