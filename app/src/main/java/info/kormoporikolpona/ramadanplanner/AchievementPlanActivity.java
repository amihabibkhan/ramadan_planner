package info.kormoporikolpona.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.kormoporikolpona.ramadanplanner.DB.DBManager;

public class AchievementPlanActivity extends AppCompatActivity {

    DBManager plan_db;
    Button save_achievement;
    EditText long_plan_1, short_plan_1,long_plan_2, short_plan_2,long_plan_3, short_plan_3,long_plan_4, short_plan_4,long_plan_5, short_plan_5,long_plan_6, short_plan_6,long_plan_7, short_plan_7,long_plan_8, short_plan_8,long_plan_9, short_plan_9,long_plan_10, short_plan_10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement_plan);
        setTitle("যা অর্জন করতে চাই");

        initIDS();

        plan_db = new DBManager(this);

        SharedPreferences dbCheck = getSharedPreferences("dbCheck", MODE_PRIVATE);
        Boolean achievementsTable = dbCheck.getBoolean("achievements", true);
        if (achievementsTable){
            try {
                plan_db.addAchievementFirstTime();
            }catch (Exception e){
                Toast.makeText(this, "Something Getting Error!", Toast.LENGTH_SHORT).show();
            }
            SharedPreferences.Editor dbCheckEditor = dbCheck.edit();
            dbCheckEditor.putBoolean("achievements", false);
            dbCheckEditor.apply();
        }

        try {
            setTextToEditText();
        }catch (Exception e){
            Toast.makeText(this, "Something getting error!", Toast.LENGTH_SHORT).show();
        }

        ProgressDialog pDialog = new ProgressDialog(AchievementPlanActivity.this);
        pDialog.setMessage("ডাটা সেইভ হচ্ছে...");
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setCancelable(false);

        save_achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDialog.show();
                updateAchievement();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pDialog.dismiss();
                        Toast.makeText(AchievementPlanActivity.this, "ডাটা সেইভ হয়েছে", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });
    }

    public void updateAchievement(){
        String long_plan_1_data = long_plan_1.getText().toString();
        String short_plan_1_data = short_plan_1.getText().toString();
        String long_plan_2_data = long_plan_2.getText().toString();
        String short_plan_2_data = short_plan_2.getText().toString();
        String long_plan_3_data = long_plan_3.getText().toString();
        String short_plan_3_data = short_plan_3.getText().toString();
        String long_plan_4_data = long_plan_4.getText().toString();
        String short_plan_4_data = short_plan_4.getText().toString();
        String long_plan_5_data = long_plan_5.getText().toString();
        String short_plan_5_data = short_plan_5.getText().toString();
        String long_plan_6_data = long_plan_6.getText().toString();
        String short_plan_6_data = short_plan_6.getText().toString();
        String long_plan_7_data = long_plan_7.getText().toString();
        String short_plan_7_data = short_plan_7.getText().toString();
        String long_plan_8_data = long_plan_8.getText().toString();
        String short_plan_8_data = short_plan_8.getText().toString();
        String long_plan_9_data = long_plan_9.getText().toString();
        String short_plan_9_data = short_plan_9.getText().toString();
        String long_plan_10_data = long_plan_10.getText().toString();
        String short_plan_10_data = short_plan_10.getText().toString();


        nullCheckAndUpdate(1, long_plan_1_data, short_plan_1_data);
        nullCheckAndUpdate(2, long_plan_2_data, short_plan_2_data);
        nullCheckAndUpdate(3, long_plan_3_data, short_plan_3_data);
        nullCheckAndUpdate(4, long_plan_4_data, short_plan_4_data);
        nullCheckAndUpdate(5, long_plan_5_data, short_plan_5_data);
        nullCheckAndUpdate(6, long_plan_6_data, short_plan_6_data);
        nullCheckAndUpdate(7, long_plan_7_data, short_plan_7_data);
        nullCheckAndUpdate(8, long_plan_8_data, short_plan_8_data);
        nullCheckAndUpdate(9, long_plan_9_data, short_plan_9_data);
        nullCheckAndUpdate(10, long_plan_10_data, short_plan_10_data);
    }

    public void nullCheckAndUpdate(int id, String long_plan, String short_plan){
        if (!long_plan.equals("") || !short_plan.equals("")){
            plan_db.updateAchievement(id, long_plan, short_plan);
        }
    }

    private void setTextToEditText() {
        long_plan_1.setText(plan_db.getSingleAchievementData(1, 1));
        short_plan_1.setText(plan_db.getSingleAchievementData(1, 2));
        long_plan_2.setText(plan_db.getSingleAchievementData(2, 1));
        short_plan_2.setText(plan_db.getSingleAchievementData(2, 2));
        long_plan_3.setText(plan_db.getSingleAchievementData(3, 1));
        short_plan_3.setText(plan_db.getSingleAchievementData(3, 2));
        long_plan_4.setText(plan_db.getSingleAchievementData(4, 1));
        short_plan_4.setText(plan_db.getSingleAchievementData(4, 2));
        long_plan_5.setText(plan_db.getSingleAchievementData(5, 1));
        short_plan_5.setText(plan_db.getSingleAchievementData(5, 2));
        long_plan_6.setText(plan_db.getSingleAchievementData(6, 1));
        short_plan_6.setText(plan_db.getSingleAchievementData(6, 2));
        long_plan_7.setText(plan_db.getSingleAchievementData(7, 1));
        short_plan_7.setText(plan_db.getSingleAchievementData(7, 2));
        long_plan_8.setText(plan_db.getSingleAchievementData(8, 1));
        short_plan_8.setText(plan_db.getSingleAchievementData(8, 2));
        long_plan_9.setText(plan_db.getSingleAchievementData(9, 1));
        short_plan_9.setText(plan_db.getSingleAchievementData(9, 2));
        long_plan_10.setText(plan_db.getSingleAchievementData(10, 1));
        short_plan_10.setText(plan_db.getSingleAchievementData(10, 2));

    }

    private void initIDS() {
        save_achievement = (Button) findViewById(R.id.save_achievement);
        long_plan_1 = (EditText) findViewById(R.id.long_plan_1);
        short_plan_1 = (EditText) findViewById(R.id.short_plan_1);
        long_plan_2 = (EditText) findViewById(R.id.long_plan_2);
        short_plan_2 = (EditText) findViewById(R.id.short_plan_2);
        long_plan_3 = (EditText) findViewById(R.id.long_plan_3);
        short_plan_3 = (EditText) findViewById(R.id.short_plan_3);
        long_plan_4 = (EditText) findViewById(R.id.long_plan_4);
        short_plan_4 = (EditText) findViewById(R.id.short_plan_4);
        long_plan_5 = (EditText) findViewById(R.id.long_plan_5);
        short_plan_5 = (EditText) findViewById(R.id.short_plan_5);
        long_plan_6 = (EditText) findViewById(R.id.long_plan_6);
        short_plan_6 = (EditText) findViewById(R.id.short_plan_6);
        long_plan_7 = (EditText) findViewById(R.id.long_plan_7);
        short_plan_7 = (EditText) findViewById(R.id.short_plan_7);
        long_plan_8 = (EditText) findViewById(R.id.long_plan_8);
        short_plan_8 = (EditText) findViewById(R.id.short_plan_8);
        long_plan_9 = (EditText) findViewById(R.id.long_plan_9);
        short_plan_9 = (EditText) findViewById(R.id.short_plan_9);
        long_plan_10 = (EditText) findViewById(R.id.long_plan_10);
        short_plan_10 = (EditText) findViewById(R.id.short_plan_10);
    }
}