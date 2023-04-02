package info.kormoporikolpona.ramadanplanner;

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
    Dialog  randomDialog;
    LinearLayout dua, ramadanImportance, at_a_glance, about_app, amarProttoy, montlyPlan, ramadanList, habit, achievement_plan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ramadanImportance = (LinearLayout) findViewById(R.id.ramadanImportance);
        montlyPlan = (LinearLayout) findViewById(R.id.montlyPlan);
        amarProttoy = (LinearLayout) findViewById(R.id.amarProttoy);
        habit = (LinearLayout) findViewById(R.id.habit);
        dua = (LinearLayout) findViewById(R.id.dua);
        ramadanList = (LinearLayout) findViewById(R.id.ramadanList);
        at_a_glance = (LinearLayout) findViewById(R.id.at_a_glance);
        about_app = (LinearLayout) findViewById(R.id.about_app);
        achievement_plan = (LinearLayout) findViewById(R.id.achievement_plan);

        Intent ramadanImportanceIntent = new Intent(MainActivity.this, ImportanceActivity.class);
        Intent duaIntent = new Intent(MainActivity.this, DuaActivity.class);
        Intent prottoyIntent = new Intent(MainActivity.this, ProttoyActivity.class);
        Intent planIntent = new Intent(MainActivity.this, MonthlyPlanActivity.class);
        Intent ramadanListIntent = new Intent(MainActivity.this, RamadanListActivity.class);
        Intent atAGlanceIntent = new Intent(MainActivity.this, AtAGlanceActivity.class);
        Intent aboutAppIntent = new Intent(MainActivity.this, AboutActivity.class);
        Intent habitIntent = new Intent(MainActivity.this, HabitActivity.class);
        Intent achievement_planIntent = new Intent(MainActivity.this, AchievementPlanActivity.class);

//        // showing random dialogue
//        Random rand = new Random();
//        int randNumber = rand.nextInt(30) + 1;
//        int randNumber2 = rand.nextInt(2);
//
//        if (randNumber2 == 0){
//            String contentString = new StaticData().bestTask[randNumber];
//            randomDialog = new CustomDialog().customDialog(this, "আজকের সেরা কাজ", contentString, R.drawable.like);
//        } else if (randNumber2 == 1) {
//            String contentString = new StaticData().ayahHadith[randNumber];
//            randomDialog = new CustomDialog().customDialog(this, "আজকের আয়াত/হাদিস", contentString, R.drawable.quran, "শুকরান");
//        } else if(randNumber2 == 2) {
//            String contentString = new StaticData().tips[randNumber];
//            randomDialog = new CustomDialog().customDialog(this,  contentString);
//        }else{
//            randomDialog = new CustomDialog().customDialog(this, "আসসালামু আলাইকুম", "রমাদান প্ল্যানার এ্যাপে আপনাকে স্বাগতম। প্রতিদিনের রিপোর্ট প্রতিদিন দেওয়ার চেষ্টা করুন। কুরআন নাযিলের মাসে বেশি বেশি কুরআন তেলাওয়াত করুন।", R.drawable.like);
//        }
//
//        randomDialog.show();

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

        habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(habitIntent);
            }
        });
        about_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(aboutAppIntent);
            }
        });
        at_a_glance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(atAGlanceIntent);
            }
        });

        achievement_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(achievement_planIntent);
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