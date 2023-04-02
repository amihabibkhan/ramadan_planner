package info.kormoporikolpona.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import info.kormoporikolpona.ramadanplanner.Model.RamadanIdAndTitle;

public class RamadanListActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout ramadan_1, ramadan_2, ramadan_3, ramadan_4, ramadan_5, ramadan_6, ramadan_7, ramadan_8, ramadan_9, ramadan_10, ramadan_11, ramadan_12,
    ramadan_13, ramadan_14, ramadan_15, ramadan_16, ramadan_17, ramadan_18, ramadan_19, ramadan_20, ramadan_21, ramadan_22, ramadan_23, ramadan_24,
    ramadan_25, ramadan_26, ramadan_27, ramadan_28, ramadan_29, ramadan_30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramadan_list);

        setTitle("রমাদান তালিকা");

        initIDS();
        ramadan_1.setOnClickListener(this);
        ramadan_2.setOnClickListener(this);
        ramadan_3.setOnClickListener(this);
        ramadan_4.setOnClickListener(this);
        ramadan_5.setOnClickListener(this);
        ramadan_6.setOnClickListener(this);
        ramadan_7.setOnClickListener(this);
        ramadan_8.setOnClickListener(this);
        ramadan_9.setOnClickListener(this);
        ramadan_10.setOnClickListener(this);
        ramadan_11.setOnClickListener(this);
        ramadan_12.setOnClickListener(this);
        ramadan_13.setOnClickListener(this);
        ramadan_14.setOnClickListener(this);
        ramadan_15.setOnClickListener(this);
        ramadan_16.setOnClickListener(this);
        ramadan_17.setOnClickListener(this);
        ramadan_18.setOnClickListener(this);
        ramadan_19.setOnClickListener(this);
        ramadan_20.setOnClickListener(this);
        ramadan_21.setOnClickListener(this);
        ramadan_22.setOnClickListener(this);
        ramadan_23.setOnClickListener(this);
        ramadan_24.setOnClickListener(this);
        ramadan_25.setOnClickListener(this);
        ramadan_26.setOnClickListener(this);
        ramadan_27.setOnClickListener(this);
        ramadan_28.setOnClickListener(this);
        ramadan_29.setOnClickListener(this);
        ramadan_30.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();

        RamadanIdAndTitle get_day = idCheckAndGetData(id);

        Intent reportIntent = new Intent(RamadanListActivity.this, RamadanReportActivity.class);
        Gson gson = new Gson();
        String myJson = gson.toJson(get_day);
        reportIntent.putExtra("ramadan", myJson);
        startActivity(reportIntent);
    }




    public RamadanIdAndTitle idCheckAndGetData(int id){
        int ramadan;
        String ramadan_title;

        switch (id){
            case R.id.ramadan_2:
                ramadan = 2;
                ramadan_title = "রমাদান: ২য় দিন";
                break;
            case R.id.ramadan_3:
                ramadan = 3;
                ramadan_title = "রমাদান: ৩য় দিন";
                break;
            case R.id.ramadan_4:
                ramadan = 4;
                ramadan_title = "রমাদান: ৪র্থ দিন";
                break;
            case R.id.ramadan_5:
                ramadan = 5;
                ramadan_title = "রমাদান: ৫ম দিন";
                break;
            case R.id.ramadan_6:
                ramadan = 6;
                ramadan_title = "রমাদান: ৬ষ্ঠ দিন";
                break;
            case R.id.ramadan_7:
                ramadan = 7;
                ramadan_title = "রমাদান: ৭ম দিন";
                break;
            case R.id.ramadan_8:
                ramadan = 8;
                ramadan_title = "রমাদান: ৮ম দিন";
                break;
            case R.id.ramadan_9:
                ramadan = 9;
                ramadan_title = "রমাদান: ৯ম দিন";
                break;
            case R.id.ramadan_10:
                ramadan = 10;
                ramadan_title = "রমাদান: ১০ম দিন";
                break;
            case R.id.ramadan_11:
                ramadan = 11;
                ramadan_title = "রমাদান: ১১তম দিন";
                break;
            case R.id.ramadan_12:
                ramadan = 12;
                ramadan_title = "রমাদান: ১২তম দিন";
                break;
            case R.id.ramadan_13:
                ramadan = 13;
                ramadan_title = "রমাদান: ১৩তম দিন";
                break;
            case R.id.ramadan_14:
                ramadan = 14;
                ramadan_title = "রমাদান: ১৪তম দিন";
                break;
            case R.id.ramadan_15:
                ramadan = 15;
                ramadan_title = "রমাদান: ১৫তম দিন";
                break;
            case R.id.ramadan_16:
                ramadan = 16;
                ramadan_title = "রমাদান: ১৬তম দিন";
                break;
            case R.id.ramadan_17:
                ramadan = 17;
                ramadan_title = "রমাদান: ১৭তম দিন";
                break;
            case R.id.ramadan_18:
                ramadan = 18;
                ramadan_title = "রমাদান: ১৮তম দিন";
                break;
            case R.id.ramadan_19:
                ramadan = 19;
                ramadan_title = "রমাদান: ১৯তম দিন";
                break;
            case R.id.ramadan_20:
                ramadan = 20;
                ramadan_title = "রমাদান: ২০তম দিন";
                break;
            case R.id.ramadan_21:
                ramadan = 21;
                ramadan_title = "রমাদান: ২১তম দিন";
                break;
            case R.id.ramadan_22:
                ramadan = 22;
                ramadan_title = "রমাদান: ২২তম দিন";
                break;
            case R.id.ramadan_23:
                ramadan = 23;
                ramadan_title = "রমাদান: ২৩তম দিন";
                break;
            case R.id.ramadan_24:
                ramadan = 24;
                ramadan_title = "রমাদান: ২৪তম দিন";
                break;
            case R.id.ramadan_25:
                ramadan = 25;
                ramadan_title = "রমাদান: ২৫তম দিন";
                break;
            case R.id.ramadan_26:
                ramadan = 26;
                ramadan_title = "রমাদান: ২৬তম দিন";
                break;
            case R.id.ramadan_27:
                ramadan = 27;
                ramadan_title = "রমাদান: ২৭তম দিন";
                break;
            case R.id.ramadan_28:
                ramadan = 28;
                ramadan_title = "রমাদান: ২৮তম দিন";
                break;
            case R.id.ramadan_29:
                ramadan = 29;
                ramadan_title = "রমাদান: ২৯তম দিন";
                break;
            case R.id.ramadan_30:
                ramadan = 30;
                ramadan_title = "রমাদান: ৩০তম দিন";
                break;
            default:
                ramadan = 1;
                ramadan_title = "রমাদান: ১ম দিন";
        }

        RamadanIdAndTitle ramadanIdAndTitle = new RamadanIdAndTitle();
        ramadanIdAndTitle.setRamadanId(ramadan);
        ramadanIdAndTitle.setRamadaTitle(ramadan_title);
        return ramadanIdAndTitle;
    }


    private void initIDS() {
        ramadan_1 = (LinearLayout) findViewById(R.id.ramadan_1);
        ramadan_2 = (LinearLayout) findViewById(R.id.ramadan_2);
        ramadan_3 = (LinearLayout) findViewById(R.id.ramadan_3);
        ramadan_4 = (LinearLayout) findViewById(R.id.ramadan_4);
        ramadan_5 = (LinearLayout) findViewById(R.id.ramadan_5);
        ramadan_6 = (LinearLayout) findViewById(R.id.ramadan_6);
        ramadan_7 = (LinearLayout) findViewById(R.id.ramadan_7);
        ramadan_8 = (LinearLayout) findViewById(R.id.ramadan_8);
        ramadan_9 = (LinearLayout) findViewById(R.id.ramadan_9);
        ramadan_10 = (LinearLayout) findViewById(R.id.ramadan_10);
        ramadan_11 = (LinearLayout) findViewById(R.id.ramadan_11);
        ramadan_12 = (LinearLayout) findViewById(R.id.ramadan_12);
        ramadan_13 = (LinearLayout) findViewById(R.id.ramadan_13);
        ramadan_14 = (LinearLayout) findViewById(R.id.ramadan_14);
        ramadan_15 = (LinearLayout) findViewById(R.id.ramadan_15);
        ramadan_16 = (LinearLayout) findViewById(R.id.ramadan_16);
        ramadan_17 = (LinearLayout) findViewById(R.id.ramadan_17);
        ramadan_18 = (LinearLayout) findViewById(R.id.ramadan_18);
        ramadan_19 = (LinearLayout) findViewById(R.id.ramadan_19);
        ramadan_20 = (LinearLayout) findViewById(R.id.ramadan_20);
        ramadan_21 = (LinearLayout) findViewById(R.id.ramadan_21);
        ramadan_22 = (LinearLayout) findViewById(R.id.ramadan_22);
        ramadan_23 = (LinearLayout) findViewById(R.id.ramadan_23);
        ramadan_24 = (LinearLayout) findViewById(R.id.ramadan_24);
        ramadan_25 = (LinearLayout) findViewById(R.id.ramadan_25);
        ramadan_26 = (LinearLayout) findViewById(R.id.ramadan_26);
        ramadan_27 = (LinearLayout) findViewById(R.id.ramadan_27);
        ramadan_28 = (LinearLayout) findViewById(R.id.ramadan_28);
        ramadan_29 = (LinearLayout) findViewById(R.id.ramadan_29);
        ramadan_30 = (LinearLayout) findViewById(R.id.ramadan_30);
    }


}