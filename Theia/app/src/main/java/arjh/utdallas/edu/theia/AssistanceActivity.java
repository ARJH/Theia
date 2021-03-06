package arjh.utdallas.edu.theia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import arjh.utdallas.edu.theia.basics.activity.BasicMenuActivity;

public class AssistanceActivity extends BasicMenuActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);
        setUpActionBar();
    }

    public void onButtonCallVolunteerClicked(View view) {
        startActivity(new Intent(this, AddVolunteerActivity.class));
    }

    @Override
    protected int[] getExcludeMenuIDs() {
        return new int[]{R.id.menu_item_assistance};
    }
}
