package info.ruhulamin.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProttoyActivity extends AppCompatActivity {

    Button ameen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prottoy);
        getSupportActionBar().hide();

        ameen = (Button) findViewById(R.id.ameen);

        Intent mainActivityIntent = new Intent(ProttoyActivity.this, MainActivity.class);

        ameen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainActivityIntent);
                finishAffinity();
            }
        });
    }
}