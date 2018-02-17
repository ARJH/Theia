package arjh.utdallas.edu.theia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private Runnable action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        action = new Runnable() {
            @Override
            public void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, DestinationSelectionActivity.class));
            }
        };

        handler.postDelayed(action, 5000);
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (action != null) {
            handler.removeCallbacks(action);
        }
    }
}
