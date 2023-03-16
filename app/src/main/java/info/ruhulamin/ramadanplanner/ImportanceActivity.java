package info.ruhulamin.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ImportanceActivity extends AppCompatActivity {

    Button goToMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importance);
        setTitle("রমাদ্বান প্ল্যানার");

        goToMainActivity = (Button) findViewById(R.id.goToMainActivity);
        Intent mainActivityIntent = new Intent(ImportanceActivity.this, MainActivity.class);

        goToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mainActivityIntent);
                finishAffinity();
            }
        });
    }
}