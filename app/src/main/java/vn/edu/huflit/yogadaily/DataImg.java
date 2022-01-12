package vn.edu.huflit.yogadaily;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class DataImg extends Application {

    public static List<ImgYoga> init_img(){

        List<ImgYoga> list = new ArrayList<>();

        list.add(new ImgYoga(R.drawable.yoga_ad_1));
        list.add(new ImgYoga(R.drawable.yoga_ad_2));
        list.add(new ImgYoga(R.drawable.yoga_ad_3));
        list.add(new ImgYoga(R.drawable.yoga_ad_4));
        list.add(new ImgYoga(R.drawable.yoga_ad_5));

        return list;
    }




}
