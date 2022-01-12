package vn.edu.huflit.yogadaily;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class DataHomeItem extends Application {

    public static ArrayList<PopularPoses> init_item(Context context){
        ArrayList<PopularPoses> arrayList = new ArrayList<>();

        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_1),R.drawable.tuthe_yoga_1));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_2),R.drawable.tuthe_yoga_2));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_3),R.drawable.tuthe_yoga_3));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_4),R.drawable.tuthe_yoga_4));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_5),R.drawable.tuthe_yoga_5));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_6),R.drawable.tuthe_yoga_6));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_7),R.drawable.tuthe_yoga_7));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_8),R.drawable.tuthe_yoga_8));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_9),R.drawable.tuthe_yoga_9));
        arrayList.add(new PopularPoses(context.getString(R.string.name_pose_10),R.drawable.tuthe_yoga_10));


        return arrayList;
    }
}
