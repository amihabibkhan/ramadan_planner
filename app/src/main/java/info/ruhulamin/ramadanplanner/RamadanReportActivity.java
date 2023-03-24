package info.ruhulamin.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Calendar;

import info.ruhulamin.ramadanplanner.CustomDialog.CustomDialog;
import info.ruhulamin.ramadanplanner.DB.DBManager;
import info.ruhulamin.ramadanplanner.Model.RamadanIdAndTitle;
import info.ruhulamin.ramadanplanner.Model.ReportModel;
import info.ruhulamin.ramadanplanner.StaticData.StaticData;

public class RamadanReportActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    DBManager plan_db;
    int ramadan_id;
    Button save_report;
    AppCompatButton tips_today,best_task_today, ayah_hadith_today;
    CheckBox check_list_1, check_list_2, check_list_3, check_list_4, check_list_5, check_list_6, check_list_7, check_list_8, check_list_9;
    CheckBox fazar_f, fazar_s, zohor_f, zohor_s, asor_f, asor_s, magrib_f, magrib_s, isha_f, isha_s, tarabih, tahazzud;
    EditText tilawat_ayah, tilawat_sura, memorize_ayah, memorize_sura, self_criticism, achievement;
    TextView date_of_the_day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramadan_report);
        Intent receivedIntent = getIntent();
        Gson gson = new Gson();
        RamadanIdAndTitle ramadanIdAndTitle = gson.fromJson(receivedIntent.getStringExtra("ramadan"), RamadanIdAndTitle.class);
        setTitle(ramadanIdAndTitle.getRamadaTitle());
        ramadan_id = ramadanIdAndTitle.getRamadanId();
        // type casting
        initIDS();
        plan_db = new DBManager(this);

        SharedPreferences dbCheck = getSharedPreferences("dbCheck", MODE_PRIVATE);
        Boolean reportTable = dbCheck.getBoolean("reportTable", true);
        if (reportTable){
            try {
                plan_db.addReportFirstTime();
            }catch (Exception e){
                Toast.makeText(this, "Something Getting Error!", Toast.LENGTH_SHORT).show();
            }
            SharedPreferences.Editor dbCheckEditor = dbCheck.edit();
            dbCheckEditor.putBoolean("reportTable", false);
            dbCheckEditor.apply();
        }

        ReportModel getData = plan_db.getReportSingleData(ramadan_id);

        try {
            setContentToView(getData);
        }catch (Exception e){
            Toast.makeText(this, "Something Getting error!", Toast.LENGTH_SHORT).show();
        }

        String tips_today_string = new StaticData().tips[ramadan_id-1];
        String best_task_string = new StaticData().bestTask[ramadan_id-1];
        String ayahHadith = new StaticData().ayahHadith[ramadan_id-1];

        Dialog  tipsDialog = new CustomDialog().customDialog(this, tips_today_string);
        Dialog  bestTaskDialog = new CustomDialog().customDialog(this, "আজকের সেরা কাজ", best_task_string, R.drawable.like);
        Dialog  ayahHadithDialog = new CustomDialog().customDialog(this, "আজকের আয়াত/হাদিস", ayahHadith, R.drawable.quran);

        tips_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipsDialog.show();
            }
        });
        best_task_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bestTaskDialog.show();
            }
        });
        ayah_hadith_today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ayahHadithDialog.show();
            }
        });

        ProgressDialog pDialog = new ProgressDialog(RamadanReportActivity.this);
        pDialog.setMessage("রিপোর্ট সেইভ হচ্ছে...");
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.setCancelable(false);

        save_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDialog.show();
                updateReport();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pDialog.dismiss();
                        Toast.makeText(RamadanReportActivity.this, "রিপোর্ট সেইভ হয়েছে", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

        date_of_the_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tipsDialog.show();
            }
        }, 500);
    }

    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );

        datePickerDialog.show();
    }

    public void setContentToView(ReportModel data){
        check_list_1.setChecked(returnCheckBoolean(data.getCheck_list_1()));
        check_list_2.setChecked(returnCheckBoolean(data.getCheck_list_2()));
        check_list_3.setChecked(returnCheckBoolean(data.getCheck_list_3()));
        check_list_4.setChecked(returnCheckBoolean(data.getCheck_list_4()));
        check_list_5.setChecked(returnCheckBoolean(data.getCheck_list_5()));
        check_list_6.setChecked(returnCheckBoolean(data.getCheck_list_6()));
        check_list_7.setChecked(returnCheckBoolean(data.getCheck_list_7()));
        check_list_8.setChecked(returnCheckBoolean(data.getCheck_list_8()));
        check_list_9.setChecked(returnCheckBoolean(data.getCheck_list_9()));

        fazar_f.setChecked(returnCheckBoolean(data.getFazar_f()));
        fazar_s.setChecked(returnCheckBoolean(data.getFazar_s()));
        zohor_f.setChecked(returnCheckBoolean(data.getZohor_f()));
        zohor_s.setChecked(returnCheckBoolean(data.getZohor_s()));
        asor_f.setChecked(returnCheckBoolean(data.getAsor_f()));
        asor_s.setChecked(returnCheckBoolean(data.getAsor_s()));
        magrib_f.setChecked(returnCheckBoolean(data.getMagrib_f()));
        magrib_s.setChecked(returnCheckBoolean(data.getMagrib_s()));
        isha_f.setChecked(returnCheckBoolean(data.getIsha_f()));
        isha_s.setChecked(returnCheckBoolean(data.getIsha_s()));
        tarabih.setChecked(returnCheckBoolean(data.getTarabih()));
        tahazzud.setChecked(returnCheckBoolean(data.getTahazzud()));

        tilawat_ayah.setText(data.getTilawat_ayah());
        tilawat_sura.setText(data.getTilawat_sura());
        memorize_ayah.setText(data.getMemorize_ayah());
        memorize_sura.setText(data.getMemorize_sura());
        self_criticism.setText(data.getSelf_criticism());
        achievement.setText(data.getAchievement());
        date_of_the_day.setText(data.getDate() != null ? data.getDate() : "DD-MM-YYYY");
    }

    public boolean returnCheckBoolean(int value){
        if (value == 1){
            return true;
        }
        return false;
    }

    public void updateReport(){

        ReportModel inputtedData = new ReportModel();

        inputtedData.setCheck_list_1(check_list_1.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_2(check_list_2.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_3(check_list_3.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_4(check_list_4.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_5(check_list_5.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_6(check_list_6.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_7(check_list_7.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_8(check_list_8.isChecked() ? 1 : 0);
        inputtedData.setCheck_list_9(check_list_9.isChecked() ? 1 : 0);

        inputtedData.setFazar_f(fazar_f.isChecked() ? 1 : 0);
        inputtedData.setFazar_s(fazar_s.isChecked() ? 1 : 0);
        inputtedData.setZohor_f(zohor_f.isChecked() ? 1 : 0);
        inputtedData.setZohor_s(zohor_s.isChecked() ? 1 : 0);
        inputtedData.setAsor_f(asor_f.isChecked() ? 1 : 0);
        inputtedData.setAsor_s(asor_s.isChecked() ? 1 : 0);
        inputtedData.setMagrib_f(magrib_f.isChecked() ? 1 : 0);
        inputtedData.setMagrib_s(magrib_s.isChecked() ? 1 : 0);
        inputtedData.setIsha_f(isha_f.isChecked() ? 1 : 0);
        inputtedData.setIsha_s(isha_s.isChecked() ? 1 : 0);
        inputtedData.setTarabih(tarabih.isChecked() ? 1 : 0);
        inputtedData.setTahazzud(tahazzud.isChecked() ? 1 : 0);

        inputtedData.setTilawat_ayah(tilawat_ayah.getText().toString());
        inputtedData.setTilawat_sura(tilawat_sura.getText().toString());
        inputtedData.setMemorize_ayah(memorize_ayah.getText().toString());
        inputtedData.setMemorize_sura(memorize_sura.getText().toString());
        inputtedData.setSelf_criticism(self_criticism.getText().toString());
        inputtedData.setAchievement(achievement.getText().toString());
        inputtedData.setDate(date_of_the_day.getText().toString());

//        Gson t = new Gson();
//        String my_t = t.toJson(inputtedData);
//
//        Log.d("myData", my_t);
        plan_db.updateReport(inputtedData, ramadan_id);
    }

    public void initIDS (){
        tips_today = (AppCompatButton) findViewById(R.id.tips_today);
        best_task_today = (AppCompatButton) findViewById(R.id.best_task_today);
        ayah_hadith_today = (AppCompatButton) findViewById(R.id.ayah_hadith_today);

        check_list_1 = (CheckBox) findViewById(R.id.check_list_1);
        check_list_2 = (CheckBox) findViewById(R.id.check_list_2);
        check_list_3 = (CheckBox) findViewById(R.id.check_list_3);
        check_list_4 = (CheckBox) findViewById(R.id.check_list_4);
        check_list_5 = (CheckBox) findViewById(R.id.check_list_5);
        check_list_6 = (CheckBox) findViewById(R.id.check_list_6);
        check_list_7 = (CheckBox) findViewById(R.id.check_list_7);
        check_list_8 = (CheckBox) findViewById(R.id.check_list_8);
        check_list_9 = (CheckBox) findViewById(R.id.check_list_9);
        fazar_f = (CheckBox) findViewById(R.id.fazar_f);
        fazar_s = (CheckBox) findViewById(R.id.fazar_s);
        zohor_f = (CheckBox) findViewById(R.id.zohor_f);
        zohor_s = (CheckBox) findViewById(R.id.zohor_s);
        asor_f = (CheckBox) findViewById(R.id.asor_f);
        asor_s = (CheckBox) findViewById(R.id.asor_s);
        magrib_f = (CheckBox) findViewById(R.id.magrib_f);
        magrib_s = (CheckBox) findViewById(R.id.magrib_s);
        isha_f = (CheckBox) findViewById(R.id.isha_f);
        isha_s = (CheckBox) findViewById(R.id.isha_s);
        tarabih = (CheckBox) findViewById(R.id.tarabih);
        tahazzud = (CheckBox) findViewById(R.id.tahazzud);

        tilawat_ayah = (EditText) findViewById(R.id.tilawat_ayah);
        tilawat_sura = (EditText) findViewById(R.id.tilawat_sura);
        memorize_ayah = (EditText) findViewById(R.id.memorize_ayah);
        memorize_sura = (EditText) findViewById(R.id.memorize_sura);
        self_criticism = (EditText) findViewById(R.id.self_criticism);
        achievement = (EditText) findViewById(R.id.achievement);

        save_report = (Button) findViewById(R.id.save_report);

        date_of_the_day = (TextView) findViewById(R.id.date_of_the_day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String dateString =  day + "-" + (month + 1) + "-" + year;
        date_of_the_day.setText(dateString);
    }
}




