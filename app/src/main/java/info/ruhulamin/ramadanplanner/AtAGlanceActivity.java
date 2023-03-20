package info.ruhulamin.ramadanplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import info.ruhulamin.ramadanplanner.DB.DBManager;
import info.ruhulamin.ramadanplanner.Model.AknojoreModel;

public class AtAGlanceActivity extends AppCompatActivity {

    TextView check_list_1_output,check_list_2_output,check_list_3_output,check_list_4_output,check_list_5_output,check_list_6_output,check_list_7_output,check_list_8_output,check_list_9_output,
            memorize_sura_output,tilawat_sura_output, memorize_ayat_output, tilawat_ayat_output,
            fazr_f_output, fazr_s_output, zohor_f_output, zohor_s_output, asor_f_output, asor_s_output, magrib_f_output, magrib_s_output, isha_f_output, isha_s_output, tarabih_output, tahazzud_output;
    DBManager dbManager;
    AknojoreModel aknojore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_a_glance);

        setTitle("একনজরে এবারের রমাদান");

        initIDS();

        dbManager = new DBManager(this);
        AknojoreModel aknojore = dbManager.getEknojore();
//        Gson gson = new Gson();
//        String s = gson.toJson(aknojore);
//        Log.d("my_data", s);

        check_list_1_output.setText("" + aknojore.getCheck_list_1());
        check_list_2_output.setText("" + aknojore.getCheck_list_2());
        check_list_3_output.setText("" + aknojore.getCheck_list_3());
        check_list_4_output.setText("" + aknojore.getCheck_list_4());
        check_list_5_output.setText("" + aknojore.getCheck_list_5());
        check_list_6_output.setText("" + aknojore.getCheck_list_6());
        check_list_7_output.setText("" + aknojore.getCheck_list_7());
        check_list_8_output.setText("" + aknojore.getCheck_list_8());
        check_list_9_output.setText("" + aknojore.getCheck_list_9());
        memorize_sura_output.setText("" + aknojore.getMemorize_sura());
        tilawat_sura_output.setText("" + aknojore.getTilawat_sura());
        memorize_ayat_output.setText("" + aknojore.getMemorize_ayah());
        tilawat_ayat_output.setText("" + aknojore.getTilawat_ayah());
        fazr_f_output.setText("" + aknojore.getFazar_f());
        fazr_s_output.setText("" + aknojore.getFazar_s());
        zohor_f_output.setText("" + aknojore.getZohor_f());
        zohor_s_output.setText("" + aknojore.getZohor_s());
        asor_f_output.setText("" + aknojore.getAsor_f());
        asor_s_output.setText("" + aknojore.getAsor_s());
        magrib_f_output.setText("" + aknojore.getMagrib_f());
        magrib_s_output.setText("" + aknojore.getMagrib_s());
        isha_f_output.setText("" + aknojore.getIsha_f());
        isha_s_output.setText("" + aknojore.getIsha_s());
        tarabih_output.setText("" + aknojore.getTarabih());
        tahazzud_output.setText("" + aknojore.getTahazzud());

    }

    public void initIDS(){
        check_list_1_output = (TextView) findViewById(R.id.check_list_1_output);
        check_list_2_output = (TextView) findViewById(R.id.check_list_2_output);
        check_list_3_output = (TextView) findViewById(R.id.check_list_3_output);
        check_list_4_output = (TextView) findViewById(R.id.check_list_4_output);
        check_list_5_output = (TextView) findViewById(R.id.check_list_5_output);
        check_list_6_output = (TextView) findViewById(R.id.check_list_6_output);
        check_list_7_output = (TextView) findViewById(R.id.check_list_7_output);
        check_list_8_output = (TextView) findViewById(R.id.check_list_8_output);
        check_list_9_output = (TextView) findViewById(R.id.check_list_9_output);
        memorize_sura_output = (TextView) findViewById(R.id.memorize_sura_output);
        tilawat_sura_output = (TextView) findViewById(R.id.tilawat_sura_output);
        memorize_ayat_output = (TextView) findViewById(R.id.memorize_ayat_output);
        tilawat_ayat_output = (TextView) findViewById(R.id.tilawat_ayat_output);
        fazr_f_output = (TextView) findViewById(R.id.fazr_f_output);
        fazr_s_output = (TextView) findViewById(R.id.fazr_s_output);
        zohor_f_output = (TextView) findViewById(R.id.zohor_f_output);
        zohor_s_output = (TextView) findViewById(R.id.zohor_s_output);
        asor_f_output = (TextView) findViewById(R.id.asor_f_output);
        asor_s_output = (TextView) findViewById(R.id.asor_s_output);
        magrib_f_output = (TextView) findViewById(R.id.magrib_f_output);
        magrib_s_output = (TextView) findViewById(R.id.magrib_s_output);
        isha_f_output = (TextView) findViewById(R.id.isha_f_output);
        isha_s_output = (TextView) findViewById(R.id.isha_s_output);
        tarabih_output = (TextView) findViewById(R.id.tarabih_output);
        tahazzud_output = (TextView) findViewById(R.id.tahazzud_output);
    }
}

