package vn.edu.huflit.yogadaily;

import java.util.ArrayList;

public class Utilities {
    public static ArrayList<Items> data;
    public static ArrayList<Items> getInstance(){
        if(data == null) {
            data = new ArrayList<>();
        }
        return data;
    }

    public  static ArrayList<Items> dataHomeFromCate;
    public  static ArrayList<Items> getInstanceFromCate(){
        if(dataHomeFromCate == null){
            dataHomeFromCate = new ArrayList<>();
        }
        return dataHomeFromCate;
    }

}
