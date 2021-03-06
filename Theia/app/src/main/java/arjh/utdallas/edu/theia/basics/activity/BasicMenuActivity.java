package arjh.utdallas.edu.theia.basics.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import arjh.utdallas.edu.theia.AssistanceActivity;
import arjh.utdallas.edu.theia.R;

/**
 * Contains basic menu features that will be used across many activities.
 */
public abstract class BasicMenuActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.basic_menu, menu);

        int[] excludeMenuIDs = getExcludeMenuIDs();
        if (excludeMenuIDs != null) {
            for (int excludeID : excludeMenuIDs) {
                if (menu.findItem(excludeID) != null) {
                    menu.removeItem(excludeID);
                }
            }
        }

        return true;
    }

    protected int[] getExcludeMenuIDs() {
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_where_am_i) {
            Toast.makeText(this,
                    getString(R.string.toast_you_are_at, "Floor 2, Room 2.801"),
                    Toast.LENGTH_SHORT)
                    .show();
        } else if (item.getItemId() == R.id.menu_item_assistance) {
            startActivity(new Intent(this, AssistanceActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    protected void setUpActionBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
