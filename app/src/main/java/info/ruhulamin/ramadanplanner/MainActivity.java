package info.ruhulamin.ramadanplanner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout dua, ramadanImportance, at_a_glance, about_app, amarProttoy, montlyPlan, ramadanList, goal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ramadanImportance = (LinearLayout) findViewById(R.id.ramadanImportance);
        montlyPlan = (LinearLayout) findViewById(R.id.montlyPlan);
        amarProttoy = (LinearLayout) findViewById(R.id.amarProttoy);
        goal = (LinearLayout) findViewById(R.id.goal);
        dua = (LinearLayout) findViewById(R.id.dua);
        ramadanList = (LinearLayout) findViewById(R.id.ramadanList);
        at_a_glance = (LinearLayout) findViewById(R.id.at_a_glance);
        about_app = (LinearLayout) findViewById(R.id.about_app);

        Intent ramadanImportanceIntent = new Intent(MainActivity.this, ImportanceActivity.class);
        Intent duaIntent = new Intent(MainActivity.this, DuaActivity.class);
        Intent prottoyIntent = new Intent(MainActivity.this, ProttoyActivity.class);
        Intent planIntent = new Intent(MainActivity.this, MonthlyPlanActivity.class);
        Intent ramadanListIntent = new Intent(MainActivity.this, RamadanListActivity.class);

        ramadanImportance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ramadanImportanceIntent);
            }
        });

        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(duaIntent);
            }
        });

        amarProttoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(prottoyIntent);
            }
        });

        montlyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(planIntent);
            }
        });

        ramadanList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ramadanListIntent);
            }
        });

        goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "কাজ চলমান রয়েছে!", Toast.LENGTH_SHORT).show();
            }
        });
        about_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "কাজ চলমান রয়েছে!", Toast.LENGTH_SHORT).show();
            }
        });
        at_a_glance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "কাজ চলমান রয়েছে!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);
        exitAlert.setTitle("বন্ধ করুন");
        exitAlert.setMessage("আপনি কি এপটি বন্ধ করতে চান?");
        exitAlert.setIcon(R.drawable.logout);
        exitAlert.setPositiveButton("হ্যা! বন্ধ করব", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        exitAlert.setNegativeButton("না! পরে বন্ধ করব", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "ধন্যবাদ", Toast.LENGTH_SHORT).show();
            }
        });
        exitAlert.show();
    }
}