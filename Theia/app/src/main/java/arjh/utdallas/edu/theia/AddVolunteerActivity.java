package arjh.utdallas.edu.theia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import arjh.utdallas.edu.theia.basics.activity.BasicMenuActivity;

public class AddVolunteerActivity extends BasicMenuActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_volunteer);
        setUpActionBar();
    }

    @Override
    protected int[] getExcludeMenuIDs() {
        return new int[]{R.id.menu_item_assistance};
    }
}
