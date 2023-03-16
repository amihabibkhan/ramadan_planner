package info.ruhulamin.ramadanplanner.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;

import info.ruhulamin.ramadanplanner.Model.ReportModel;

public class DBManager extends SQLiteOpenHelper {
    private static final String DB_NAME = "RamadanPlanner";
    private static final int DB_VERSION = 3;

    public DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE plans (id INTEGER PRIMARY KEY AUTOINCREMENT, plan_for INTEGER, plan_value INTEGER)");
        db.execSQL("CREATE TABLE reports (id INTEGER PRIMARY KEY AUTOINCREMENT, ramadan_id INTEGER, check_list_1 INTEGER, check_list_2 INTEGER, check_list_3 INTEGER, check_list_4 INTEGER, check_list_5 INTEGER, check_list_6 INTEGER, check_list_7 INTEGER, check_list_8 INTEGER, check_list_9 INTEGER," +
                "tilawat_ayah INTEGER, tilawat_sura INTEGER, memorize_ayah INTEGER, memorize_sura INTEGER, fazar_f INTEGER, fazar_s INTEGER, zohor_f INTEGER, zohor_s INTEGER, asor_f INTEGER, asor_s INTEGER, magrib_f INTEGER, magrib_s INTEGER, isha_f INTEGER, isha_s INTEGER, tarabih INTEGER, tahazzud INTEGER," +
                "self_criticism TEXT, achievement TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS plans");
        db.execSQL("DROP TABLE IF EXISTS reports");
        onCreate(db);
    }

    public void updatePlan(int plan_for, String plan_value){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updateValue = new ContentValues();

        updateValue.put("plan_value", plan_value);

        db.update("plans", updateValue, "plan_for = " + plan_for, null);
    }

    public void updateReport(ReportModel newData, int ramadan_id){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updateValue = new ContentValues();

        updateValue.put("check_list_1", newData.getCheck_list_1());
        updateValue.put("check_list_2", newData.getCheck_list_2());
        updateValue.put("check_list_3", newData.getCheck_list_3());
        updateValue.put("check_list_4", newData.getCheck_list_4());
        updateValue.put("check_list_5", newData.getCheck_list_5());
        updateValue.put("check_list_6", newData.getCheck_list_6());
        updateValue.put("check_list_7", newData.getCheck_list_7());
        updateValue.put("check_list_8", newData.getCheck_list_8());
        updateValue.put("check_list_9", newData.getCheck_list_9());

        updateValue.put("fazar_f", newData.getFazar_f());
        updateValue.put("fazar_s", newData.getFazar_s());
        updateValue.put("zohor_f", newData.getZohor_f());
        updateValue.put("zohor_s", newData.getZohor_s());
        updateValue.put("asor_f", newData.getAsor_f());
        updateValue.put("asor_s", newData.getAsor_s());
        updateValue.put("magrib_f", newData.getMagrib_f());
        updateValue.put("magrib_s", newData.getMagrib_s());
        updateValue.put("isha_f", newData.getIsha_f());
        updateValue.put("isha_s", newData.getIsha_s());
        updateValue.put("tarabih", newData.getTarabih());
        updateValue.put("tahazzud", newData.getTahazzud());

        updateValue.put("tilawat_ayah", newData.getTilawat_ayah());
        updateValue.put("tilawat_sura", newData.getTilawat_sura());
        updateValue.put("memorize_ayah", newData.getMemorize_ayah());
        updateValue.put("memorize_sura", newData.getMemorize_sura());
        updateValue.put("self_criticism", newData.getSelf_criticism());
        updateValue.put("achievement", newData.getAchievement());

        db.update("reports", updateValue, "ramadan_id = " + ramadan_id, null);
    }

    public void checkPlanTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "Select * from plans";

        Cursor cursor = db.rawQuery(Query, null);

        if(cursor.getCount() <= 0){
            db.execSQL("DELETE FROM plans");
            addPlanFirstTime();
        }
    }

    public void checkReportTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "Select * from reports";

        Cursor cursor = db.rawQuery(Query, null);

        if(cursor.getCount() <= 0){
            db.execSQL("DELETE FROM reports");
            addReportFirstTime();
        }
    }

    public void addReportFirstTime(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (int i = 1; i <= 30; i++){
            values.put("ramadan_id", i);
            db.insert("reports", null, values);
        }
    }
    public void addPlanFirstTime(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (int i = 1; i <= 20; i++){
            values.put("plan_for", i);
            db.insert("plans", null, values);
        }
    }

    public String getSingleData(int plan_for){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM plans WHERE plan_for = " + plan_for, null);
        String data = null;

        if(cursor!=null && cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                data = cursor.getString(2);
            } while (cursor.moveToNext());
        }

        return data;
    }
    public ReportModel getReportSingleData(int ramadan_id){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM reports WHERE ramadan_id = " + ramadan_id, null);

        ReportModel data = new ReportModel();

        if(cursor!=null && cursor.getCount()>0) {
            cursor.moveToFirst();
            do {
                data.setCheck_list_1(cNARI(cursor.getString(2)));
                data.setCheck_list_2(cNARI(cursor.getString(3)));
                data.setCheck_list_3(cNARI(cursor.getString(4)));
                data.setCheck_list_4(cNARI(cursor.getString(5)));
                data.setCheck_list_5(cNARI(cursor.getString(6)));
                data.setCheck_list_6(cNARI(cursor.getString(7)));
                data.setCheck_list_7(cNARI(cursor.getString(8)));
                data.setCheck_list_8(cNARI(cursor.getString(9)));
                data.setCheck_list_9(cNARI(cursor.getString(10)));

                data.setTilawat_ayah(cursor.getString(11));
                data.setTilawat_sura(cursor.getString(12));
                data.setMemorize_ayah(cursor.getString(13));
                data.setMemorize_sura(cursor.getString(14));


                data.setFazar_f(cNARI(cursor.getString(15)));
                data.setFazar_s(cNARI(cursor.getString(16)));
                data.setZohor_f(cNARI(cursor.getString(17)));
                data.setZohor_s(cNARI(cursor.getString(18)));
                data.setAsor_f(cNARI(cursor.getString(19)));
                data.setAsor_s(cNARI(cursor.getString(20)));
                data.setMagrib_f(cNARI(cursor.getString(21)));
                data.setMagrib_s(cNARI(cursor.getString(22)));
                data.setIsha_f(cNARI(cursor.getString(23)));
                data.setIsha_s(cNARI(cursor.getString(24)));
                data.setTarabih(cNARI(cursor.getString(25)));
                data.setTahazzud(cNARI(cursor.getString(26)));


                data.setSelf_criticism(cursor.getString(27));
                data.setAchievement(cursor.getString(28));

            } while (cursor.moveToNext());
        }

        return data;
    }

    public int cNARI(String item){
        // check null and return integer
        if (item != null){
            return Integer.parseInt(item);
        }
        return 0;
    }

}
