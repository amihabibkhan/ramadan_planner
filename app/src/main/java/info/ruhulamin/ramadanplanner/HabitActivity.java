package info.ruhulamin.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.ruhulamin.ramadanplanner.DB.DBManager;

public class HabitActivity extends AppCompatActivity {

    DBManager plan_db;
    Button save_habit;
    EditText habit_1, solve_1,habit_2, solve_2,habit_3, solve_3,habit_4, solve_4,habit_5, solve_5,habit_6, solve_6,habit_7, solve_7,habit_8, solve_8,habit_9, solve_9,habit_10, solve_10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit);
        setTitle("অভ্যাস পরিবর্তন");

        initIDS();

        plan_db = new DBManager(this);

        SharedPreferences dbCheck = getSharedPreferences("dbCheck", MODE_PRIVATE);
        Boolean habitTable = dbCheck.getBoolean("habitTable", true);
        if (habitTable){
            try {
                plan_db.addHabitFirstTime();
            }catch (Exception e){
                Toast.makeText(this, "Something Getting Error!", Toast.LENGTH_SHORT).show();
            }
            SharedPreferences.Editor dbCheckEditor = dbCheck.edit();
            dbCheckEditor.putBoolean("habitTable", false);
            dbCheckEditor.apply();
        }
        setTextToEditText();

        ProgressDialog pDialog = new ProgressDialog(HabitActivity.this);
        pDialog.setMessage("ডাটা সেইভ হচ্ছে...");
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setCancelable(false);

        save_habit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDialog.show();
                updateHabit();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pDialog.dismiss();
                        Toast.makeText(HabitActivity.this, "ডাটা সেইভ হয়েছে", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

    }

    private void setTextToEditText() {
        habit_1.setText(plan_db.getSingleHabitData(1, 1));
        solve_1.setText(plan_db.getSingleHabitData(1, 2));

        habit_2.setText(plan_db.getSingleHabitData(2, 1));
        solve_2.setText(plan_db.getSingleHabitData(2, 2));

        habit_3.setText(plan_db.getSingleHabitData(3, 1));
        solve_3.setText(plan_db.getSingleHabitData(3, 2));
        habit_4.setText(plan_db.getSingleHabitData(4, 1));
        solve_4.setText(plan_db.getSingleHabitData(4, 2));
        habit_5.setText(plan_db.getSingleHabitData(5, 1));
        solve_5.setText(plan_db.getSingleHabitData(5, 2));
        habit_6.setText(plan_db.getSingleHabitData(6, 1));
        solve_6.setText(plan_db.getSingleHabitData(6, 2));
        habit_7.setText(plan_db.getSingleHabitData(7, 1));
        solve_7.setText(plan_db.getSingleHabitData(7, 2));
        habit_8.setText(plan_db.getSingleHabitData(8, 1));
        solve_8.setText(plan_db.getSingleHabitData(8, 2));
        habit_9.setText(plan_db.getSingleHabitData(9, 1));
        solve_9.setText(plan_db.getSingleHabitData(9, 2));
        habit_10.setText(plan_db.getSingleHabitData(10, 1));
        solve_10.setText(plan_db.getSingleHabitData(10, 2));

    }

    public void updateHabit(){
        String habit_1_data = habit_1.getText().toString();
        String solve_1_data = solve_1.getText().toString();
        String habit_2_data = habit_2.getText().toString();
        String solve_2_data = solve_2.getText().toString();
        String habit_3_data = habit_3.getText().toString();
        String solve_3_data = solve_3.getText().toString();
        String habit_4_data = habit_4.getText().toString();
        String solve_4_data = solve_4.getText().toString();
        String habit_5_data = habit_5.getText().toString();
        String solve_5_data = solve_5.getText().toString();
        String habit_6_data = habit_6.getText().toString();
        String solve_6_data = solve_6.getText().toString();
        String habit_7_data = habit_7.getText().toString();
        String solve_7_data = solve_7.getText().toString();
        String habit_8_data = habit_8.getText().toString();
        String solve_8_data = solve_8.getText().toString();
        String habit_9_data = habit_9.getText().toString();
        String solve_9_data = solve_9.getText().toString();
        String habit_10_data = habit_10.getText().toString();
        String solve_10_data = solve_10.getText().toString();


        nullCheckAndUpdate(1, habit_1_data, solve_1_data);
        nullCheckAndUpdate(2, habit_2_data, solve_2_data);
        nullCheckAndUpdate(3, habit_3_data, solve_3_data);
        nullCheckAndUpdate(4, habit_4_data, solve_4_data);
        nullCheckAndUpdate(5, habit_5_data, solve_5_data);
        nullCheckAndUpdate(6, habit_6_data, solve_6_data);
        nullCheckAndUpdate(7, habit_7_data, solve_7_data);
        nullCheckAndUpdate(8, habit_8_data, solve_8_data);
        nullCheckAndUpdate(9, habit_9_data, solve_9_data);
        nullCheckAndUpdate(10, habit_10_data, solve_10_data);
    }

    public void nullCheckAndUpdate(int id, String habit, String solve){
        if (!habit.equals("") || !solve.equals("")){
            plan_db.updateHabits(id, habit, solve);
        }
    }


    private void initIDS() {
        save_habit = (Button) findViewById(R.id.save_habit);
        habit_1 = (EditText) findViewById(R.id.habit_1);
        solve_1 = (EditText) findViewById(R.id.solve_1);
        habit_2 = (EditText) findViewById(R.id.habit_2);
        solve_2 = (EditText) findViewById(R.id.solve_2);
        habit_3 = (EditText) findViewById(R.id.habit_3);
        solve_3 = (EditText) findViewById(R.id.solve_3);
        habit_4 = (EditText) findViewById(R.id.habit_4);
        solve_4 = (EditText) findViewById(R.id.solve_4);
        habit_5 = (EditText) findViewById(R.id.habit_5);
        solve_5 = (EditText) findViewById(R.id.solve_5);
        habit_6 = (EditText) findViewById(R.id.habit_6);
        solve_6 = (EditText) findViewById(R.id.solve_6);
        habit_7 = (EditText) findViewById(R.id.habit_7);
        solve_7 = (EditText) findViewById(R.id.solve_7);
        habit_8 = (EditText) findViewById(R.id.habit_8);
        solve_8 = (EditText) findViewById(R.id.solve_8);
        habit_9 = (EditText) findViewById(R.id.habit_9);
        solve_9 = (EditText) findViewById(R.id.solve_9);
        habit_10 = (EditText) findViewById(R.id.habit_10);
        solve_10 = (EditText) findViewById(R.id.solve_10);
    }
}