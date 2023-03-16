package info.ruhulamin.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.ruhulamin.ramadanplanner.DB.DBManager;

public class MonthlyPlanActivity extends AppCompatActivity {

    DBManager plan_db;
    Button save_plan;
    EditText et_1, et_2, et_3, et_4, et_5, et_6, et_7, et_8, et_9, et_10, et_11, et_12, et_13, et_14, et_15, et_16, et_17, et_18, et_19, et_20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_plan);

        setTitle("মাসিক পরিকল্পনা");

        initIDS();

        plan_db = new DBManager(this);
        plan_db.checkPlanTable();

        setTextToEditText();

        ProgressDialog pDialog = new ProgressDialog(MonthlyPlanActivity.this);
        pDialog.setMessage("প্ল্যান সেইভ হচ্ছে...");
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setCancelable(false);

        Intent mainActivityIntent = new Intent(MonthlyPlanActivity.this, MainActivity.class);

        save_plan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pDialog.show();
                updatePlan();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pDialog.dismiss();
                        Toast.makeText(MonthlyPlanActivity.this, "প্লান সেইভ হয়েছে", Toast.LENGTH_SHORT).show();
                        startActivity(mainActivityIntent);
                        finishAffinity();
                    }
                }, 1000);


            }
        });
    }

    private void setTextToEditText() {
        et_1.setText(plan_db.getSingleData(1));
        et_2.setText(plan_db.getSingleData(2));
        et_3.setText(plan_db.getSingleData(3));
        et_4.setText(plan_db.getSingleData(4));
        et_5.setText(plan_db.getSingleData(5));
        et_6.setText(plan_db.getSingleData(6));
        et_7.setText(plan_db.getSingleData(7));
        et_8.setText(plan_db.getSingleData(8));
        et_9.setText(plan_db.getSingleData(9));
        et_10.setText(plan_db.getSingleData(10));
        et_11.setText(plan_db.getSingleData(11));
        et_12.setText(plan_db.getSingleData(12));
        et_13.setText(plan_db.getSingleData(13));
        et_14.setText(plan_db.getSingleData(14));
        et_15.setText(plan_db.getSingleData(15));
        et_16.setText(plan_db.getSingleData(16));
        et_17.setText(plan_db.getSingleData(17));
        et_18.setText(plan_db.getSingleData(18));
        et_19.setText(plan_db.getSingleData(19));
        et_20.setText(plan_db.getSingleData(20));
    }

    public void updatePlan(){
        String et_1_data = et_1.getText().toString();
        String et_2_data = et_2.getText().toString();
        String et_3_data = et_3.getText().toString();
        String et_4_data = et_4.getText().toString();
        String et_5_data = et_5.getText().toString();
        String et_6_data = et_6.getText().toString();
        String et_7_data = et_7.getText().toString();
        String et_8_data = et_8.getText().toString();
        String et_9_data = et_9.getText().toString();
        String et_10_data = et_10.getText().toString();
        String et_11_data = et_11.getText().toString();
        String et_12_data = et_12.getText().toString();
        String et_13_data = et_13.getText().toString();
        String et_14_data = et_14.getText().toString();
        String et_15_data = et_15.getText().toString();
        String et_16_data = et_16.getText().toString();
        String et_17_data = et_17.getText().toString();
        String et_18_data = et_18.getText().toString();
        String et_19_data = et_19.getText().toString();
        String et_20_data = et_20.getText().toString();

        nullCheckAndUpdate(1, et_1_data);
        nullCheckAndUpdate(2, et_2_data);
        nullCheckAndUpdate(3, et_3_data);
        nullCheckAndUpdate(4, et_4_data);
        nullCheckAndUpdate(5, et_5_data);
        nullCheckAndUpdate(6, et_6_data);
        nullCheckAndUpdate(7, et_7_data);
        nullCheckAndUpdate(8, et_8_data);
        nullCheckAndUpdate(9, et_9_data);
        nullCheckAndUpdate(10, et_10_data);
        nullCheckAndUpdate(11, et_11_data);
        nullCheckAndUpdate(12, et_12_data);
        nullCheckAndUpdate(13, et_13_data);
        nullCheckAndUpdate(14, et_14_data);
        nullCheckAndUpdate(15, et_15_data);
        nullCheckAndUpdate(16, et_16_data);
        nullCheckAndUpdate(17, et_17_data);
        nullCheckAndUpdate(18, et_18_data);
        nullCheckAndUpdate(19, et_19_data);
        nullCheckAndUpdate(20, et_20_data);
    }

    public void nullCheckAndUpdate(int plan_for, String plan_value){
        if (!plan_value.equals("")){
            plan_db.updatePlan(plan_for, plan_value);
        }
    }



    public void initIDS(){
        save_plan = (Button) findViewById(R.id.save_plan);
        et_1 = (EditText) findViewById(R.id.et_1);
        et_2 = (EditText) findViewById(R.id.et_2);
        et_3 = (EditText) findViewById(R.id.et_3);
        et_4 = (EditText) findViewById(R.id.et_4);
        et_5 = (EditText) findViewById(R.id.et_5);
        et_6 = (EditText) findViewById(R.id.et_6);
        et_7 = (EditText) findViewById(R.id.et_7);
        et_8 = (EditText) findViewById(R.id.et_8);
        et_9 = (EditText) findViewById(R.id.et_9);
        et_10 = (EditText) findViewById(R.id.et_10);
        et_11 = (EditText) findViewById(R.id.et_11);
        et_12 = (EditText) findViewById(R.id.et_12);
        et_13 = (EditText) findViewById(R.id.et_13);
        et_14 = (EditText) findViewById(R.id.et_14);
        et_15 = (EditText) findViewById(R.id.et_15);
        et_16 = (EditText) findViewById(R.id.et_16);
        et_17 = (EditText) findViewById(R.id.et_17);
        et_18 = (EditText) findViewById(R.id.et_18);
        et_19 = (EditText) findViewById(R.id.et_19);
        et_20 = (EditText) findViewById(R.id.et_20);
    }
}