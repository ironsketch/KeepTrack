package com.linuxduck.keeptrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.linuxduck.keeptrack.models.Day;
import com.linuxduck.keeptrack.models.User;
import com.linuxduck.keeptrack.models.Weight;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DBH extends SQLiteOpenHelper {
    String lock ="keepTrackDBLock";
    private static final Integer DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "keeptracklinuxdb";

    // TABLE Day
    private static final String TABLE_DAY = "day_t";
    private static final String COL_DAY_ID = "day_id";
    private static final String COL_DAY_DATE = "day_date";

    // TABLE User
    private static final String TABLE_USER = "user_t";
    private static final String COL_USER_ID = "user_id";
    private static final String COL_USER_GOALWEIGHT = "user_goalweight";

    // TABLE Workout
    private static final String TABLE_WORKOUT = "workout_t";
    private static final String COL_WORKOUT_ID = "workout_id";
    private static final String COL_WORKOUT_NAME = "workout_name";
    private static final String COL_WORKOUT_REPS = "workout_reps";
    private static final String COL_WORKOUT_SETS = "workout_sets";
    private static final String COL_WORKOUT_WEIGHT = "workout_weight";
    private static final String COL_WORKOUT_DISTANCE = "workout_distance";
    private static final String COL_WORKOUT_NOTES = "workout_notes";

    // TABLE Chores
    private static final String TABLE_CHORE = "chore_t";
    private static final String COL_CHORE_ID = "chore_id";
    private static final String COL_CHORE_NAME = "chore_name";
    private static final String COL_CHORE_NOTES = "chore_notes";

    // TABLE Food
    private static final String TABLE_FOOD = "food_t";
    private static final String COL_FOOD_ID = "food_id";
    private static final String COL_FOOD_NAME = "food_name";
    private static final String COL_FOOD_CALORIES = "food_calories";
    private static final String COL_FOOD_WW = "food_ww";
    private static final String COL_FOOD_TOTALFAT = "food_totalfat";
    private static final String COL_FOOD_SATURATEDFAT = "food_saturatedfat";
    private static final String COL_FOOD_TRANSFAT = "food_transfat";
    private static final String COL_FOOD_CHOLESTEROL = "food_cholesterol";
    private static final String COL_FOOD_SODIUM = "food_sodium";
    private static final String COL_FOOD_TOTALCARBS = "food_totalcarbs";
    private static final String COL_FOOD_DIETARYFIBER = "food_dietaryfiber";
    private static final String COL_FOOD_TOTALSUGARS = "food_totalsugars";
    private static final String COL_FOOD_PROTIEN = "food_protien";
    private static final String COL_FOOD_NOTES = "food_notes";

    // TABLE XREF Day and Food
    private static final String TABLE_DAY_FOOD = "day_food_t";
    private static final String COL_DAY_FOOD_ID = "day_food_id";
    // private static final String COL_DAY_ID = "day_id";
    // private static final String COL_FOOD_ID = "food_id";
    private static final String COL_DAY_FOOD_QUANTITY = "day_food_quantity";
    private static final String COL_DAY_FOOD_TYPE = "day_food_type"; // breakfast, lunch, dinner, snack
    private static final String COL_DAY_FOOD_FEELS = "day_food_feels"; // How you felt about your selection
    private static final String COL_DAY_FOOD_NOTES =  "day_food_notes";

    // TABLE XREF Day and Chore
    private static final String TABLE_DAY_CHORE = "day_chore_t";
    private static final String COL_DAY_CHORE_ID = "day_chore_id";
    // private static final String COL_DAY_ID = "day_id";
    // private static final String COL_CHORE_ID = "chore_id";
    private static final String COL_DAY_CHORE_DONE = "day_chore_done";
    private static final String COL_DAY_CHORE_NOTES = "day_chore_notes";

    // TABLE XREF Day and Workout
    private static final String TABLE_DAY_WORKOUT = "day_workout_t";
    private static final String COL_DAY_WORKOUT_ID = "day_workout_id";
    // private static final String COL_DAY_ID = "day_id";
    // private static final String COL_WORKOUT_ID = "workout_id";
    private static final String COL_DAY_WORKOUT_SETS = "day_workout_sets";
    private static final String COL_DAY_WORKOUT_REPS = "day_workout_reps";
    private static final String COL_DAY_WORKOUT_WEIGHT = "day_workout_weight";
    private static final String COL_DAY_WORKOUT_DISTANCE = "day_workout_distance";
    private static final String COL_DAY_WORKOUT_DONE = "day_workout_done";
    private static final String COL_DAY_WORKOUT_NOTES = "day_workout_notes";

    // TABLE WEIGHTS
    private static final String TABLE_WEIGHTS = "weights_t";
    private static final String COL_WEIGHTS_ID = "weights_id";
    private static final String COL_WEIGHTS_DATE = "weights_date";
    private static final String COL_WEIGHTS_TIME = "weights_time";
    private static final String COL_WEIGHTS_WEIGHT = "weights_weight";

    public DBH(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableDay = "CREATE TABLE " + TABLE_DAY + "(" +
                COL_DAY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_DAY_DATE +
                " TEXT)";
        String createTableUser = "CREATE TABLE " + TABLE_USER + "(" +
                COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_USER_GOALWEIGHT + " REAL)";
        String createTableWorkout = "CREATE TABLE " + TABLE_WORKOUT + "(" +
                COL_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_WORKOUT_NAME + " TEXT, " + COL_WORKOUT_REPS + " REAL, " +
                COL_WORKOUT_SETS + " REAL, " + COL_WORKOUT_WEIGHT + " REAL, " +
                COL_WORKOUT_DISTANCE + " REAL, " + COL_WORKOUT_NOTES + " TEXT)";
        String createTableChore = "CREATE TABLE " + TABLE_CHORE + "(" +
                COL_CHORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_CHORE_NAME + " TEXT, " + COL_CHORE_NOTES + ")";
        String createTableFood = "CREATE TABLE " + TABLE_FOOD + "(" +
                COL_FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_FOOD_NAME + " TEXT, " + COL_FOOD_CALORIES + " REAL, " +
                COL_FOOD_WW + " INTEGER, " + COL_FOOD_TOTALFAT + " REAL, " +
                COL_FOOD_SATURATEDFAT + " REAL, " + COL_FOOD_TRANSFAT + " REAL, " +
                COL_FOOD_CHOLESTEROL + " REAL, " + COL_FOOD_SODIUM + " REAL, " +
                COL_FOOD_TOTALCARBS + " REAL, " + COL_FOOD_DIETARYFIBER + " REAL, " +
                COL_FOOD_TOTALSUGARS + " REAL, " + COL_FOOD_PROTIEN + " REAL, " +
                COL_FOOD_NOTES + " TEXT)";
        String createTableDayFood = "CREATE TABLE " + TABLE_DAY_FOOD + "(" +
                COL_DAY_FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DAY_ID + " INTEGER, " + COL_FOOD_ID + " INTEGER, " +
                COL_DAY_FOOD_QUANTITY + " REAL, " + COL_DAY_FOOD_TYPE + " TEXT, " +
                COL_DAY_FOOD_FEELS + " TEXT," + COL_DAY_FOOD_NOTES + "TEXT)";
        String createTableDayChore = "CREATE TABLE " + TABLE_DAY_CHORE + "(" +
                COL_DAY_CHORE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DAY_ID + " INTEGER, " + COL_CHORE_ID + " INTEGER, " +
                COL_DAY_CHORE_DONE + " INTEGER, " + COL_DAY_CHORE_NOTES + "TEXT)";
        String createTableDayWorkout = "CREATE TABLE " + TABLE_DAY_WORKOUT + "(" +
                COL_DAY_WORKOUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DAY_ID + " INTEGER, " + COL_WORKOUT_ID + " INTEGER, " +
                COL_DAY_WORKOUT_SETS + " REAL, " + COL_DAY_WORKOUT_REPS + " REAL, " +
                COL_DAY_WORKOUT_WEIGHT + " REAL, " + COL_DAY_WORKOUT_DISTANCE + " REAL, " +
                COL_DAY_WORKOUT_DONE + " INTEGER, " + COL_DAY_WORKOUT_NOTES + " TEXT)";
        String createTableWeights = "CREATE TABLE " + TABLE_WEIGHTS + "(" +
                COL_WEIGHTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_WEIGHTS_DATE + " TEXT, " + COL_WEIGHTS_TIME + " TEXT, " +
                COL_WEIGHTS_WEIGHT + " REAL)";

        db.execSQL(createTableDay);
        db.execSQL(createTableUser);
        db.execSQL(createTableWorkout);
        db.execSQL(createTableChore);
        db.execSQL(createTableFood);
        db.execSQL(createTableDayFood);
        db.execSQL(createTableDayChore);
        db.execSQL(createTableDayWorkout);
        db.execSQL(createTableWeights);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        onCreate(db);
    }

    // TABLE DAY FUNCTIONS
    public Long addDay(String day){
        Long row = -1l;
        synchronized (lock){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_DAY_DATE, day);
            db.insert(TABLE_DAY, null, values);
            db.close();
        }
        return row;
    }

    public ArrayList<Day> getDays(){
        SimpleDateFormat sdp = new SimpleDateFormat("yyyy.MM.dd");
        ArrayList<Day> days = new ArrayList<>();
        synchronized (lock){
            SQLiteDatabase db = this.getWritableDatabase();

            String getDaysQuery = "SELECT * FROM " + TABLE_DAY + " ORDER BY " +
                    COL_DAY_DATE + " DESC";

            Cursor cursor = db.rawQuery(getDaysQuery, null);
            if(cursor.moveToFirst()){
                do {
                    Day day = new Day(
                            cursor.getLong(0),
                            cursor.getString(1)
                    );
                    days.add(day);
                } while (cursor.moveToNext());
            }
            db.close();
        }
        return days;
    }

    // TABLE USER FUNCTIONS
    public Long addUser(Double weight) {
        Long row = -1l;
        synchronized (lock){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_USER_GOALWEIGHT, weight);
            db.insert(TABLE_USER, null, values);
            db.close();
        }
        return row;
    }

    public User getUser() {
        User user = new User();
        synchronized (lock){
            SQLiteDatabase db = this.getWritableDatabase();

            String getDaysQuery = "SELECT * FROM " + TABLE_USER;

            Cursor cursor = db.rawQuery(getDaysQuery, null);
            if(cursor.moveToFirst()){
                do {
                    user = new User(
                            cursor.getLong(0),
                            cursor.getDouble(1)
                    );
                } while (cursor.moveToNext());
            }
            db.close();
        }
        return user;
    }

    public void editGoalWeight(User user) {
        synchronized (lock){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_USER_GOALWEIGHT, user.getGoalWeight());
            db.update(TABLE_USER, values, COL_USER_ID + " = ?",
                    new String[] { String.valueOf(user.getId()) });
        }
    }

    // TABLE WEIGHTS FUNCTIONS
    public Long addWeight(String date, String time, Double weight) {
        Long row = -1l;
        synchronized (lock){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_WEIGHTS_DATE, date);
            values.put(COL_WEIGHTS_TIME, time);
            values.put(COL_WEIGHTS_DATE, weight);
            row = db.insert(TABLE_WEIGHTS, null, values);
            db.close();
        }
        return row;
    }

    public void deleteWeight(Weight weight){
        synchronized (lock){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_WEIGHTS, COL_WEIGHTS_ID + " = ?",
                    new String[] { String.valueOf(weight.getId()) });
            db.close();
        }
    }
}
