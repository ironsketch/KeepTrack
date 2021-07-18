package com.linuxduck.keeptrack;

import android.database.sqlite.SQLiteDatabase;

public class DBH extends SQLiteDatabase {
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
    private static final String COL_USER_NOTES = "user_notes";

    // TABLE Workout
    private static final String TABLE_WORKOUT = "workout_t";
    private static final String COL_WORKOUT_ID = "workout_id";
    private static final String COL_WORKOUT_NAME = "workout_name";
    private static final String COL_WORKOUT_REPS = "workout_reps";
    private static final String COL_WORKOUT_WEIGHT = "workout_weight";
    private static final String COL_WORKOUT_TIME = "workout_time";
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
    private static final String TABLE_DAY_FOOD = "day_food";
    private static final String COL_DAY_FOOD_ID = "day_food_id";
    // private static final String COL_DAY_ID = "day_id";
    // private static final String COL_FOOD_ID = "food_id";
    private static final String COL_HOWMANY = "day_food_howmany";
    private static final String COL_TYPE = "day_food_type"; // breakfast, lunch, dinner, snack
    
}
