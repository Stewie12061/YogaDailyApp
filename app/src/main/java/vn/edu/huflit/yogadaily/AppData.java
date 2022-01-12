package vn.edu.huflit.yogadaily;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class AppData extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static ArrayList<Items> init_data(Context context){
        ArrayList<Items> tmp = new ArrayList<>();

        tmp.add(new Items(context.getString(R.string.poses_abs_name_1),
                context.getString(R.string.poses_abs_des_1),
                R.drawable.poses_abs_1, 1,1));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_2),
                context.getString(R.string.poses_abs_des_2),
                R.drawable.poses_abs_2, 1,2));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_3),
                context.getString(R.string.poses_abs_des_3),
                R.drawable.poses_abs_3, 1,3));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_4),
                context.getString(R.string.poses_abs_des_4),
                R.drawable.poses_abs_4, 1,4));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_5),
                context.getString(R.string.poses_abs_des_5),
                R.drawable.poses_abs_5, 1,5));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_6),
                context.getString(R.string.poses_abs_des_6),
                R.drawable.poses_abs_6, 1,6));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_7),
                context.getString(R.string.poses_abs_des_7),
                R.drawable.poses_abs_7, 1,7));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_8),
                context.getString(R.string.poses_abs_des_8),
                R.drawable.poses_abs_8, 1,8));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_9),
                context.getString(R.string.poses_abs_des_9),
                R.drawable.poses_abs_9, 1,9));
        tmp.add(new Items(context.getString(R.string.poses_abs_name_10),
                context.getString(R.string.poses_abs_des_10),
                R.drawable.poses_abs_10, 1,10));

        return tmp;
    }

    public  static ArrayList<Categories> init_data(){
        ArrayList<Categories> tmp = new ArrayList<>();

        tmp.add(new Categories("Poses For Your Abs",R.drawable.poses_abs_categories,1));
        tmp.add(new Categories("Poses For Your Arms",R.drawable.poses_arm_categories,2));
        tmp.add(new Categories("Poses For Your Hips",R.drawable.poses_hip_categories,3));
        tmp.add(new Categories("Poses For Your Knees",R.drawable.poses_knee_categories,4));
        tmp.add(new Categories("Poses For Your Backs",R.drawable.poses_back_categories,5));
        tmp.add(new Categories("Poses For Your Legs",R.drawable.poses_leg_categories,6));

        return tmp;
    }
}
