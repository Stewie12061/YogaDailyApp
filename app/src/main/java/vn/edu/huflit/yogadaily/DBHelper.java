package vn.edu.huflit.yogadaily;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABSE_NAME = "YogaDaily.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCategories = "CREATE TABLE IF NOT EXISTS tbtCategories (" +
                " CategoriesID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Image INTEGER );";
        String sqlItem = "CREATE TABLE IF NOT EXISTS tblItem (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " Name TEXT," +
                " Description TEXT," +
                " Image INTEGER," +
                " CategoriesID INTEGER );";
        db.execSQL(sqlCategories);
        db.execSQL(sqlItem);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Xoá bảng cũ
        db.execSQL("DROP TABLE IF EXISTS tblCategories");
        db.execSQL("DROP TABLE IF EXISTS tblItem");
        //Tiến hành tạo bảng mới
        onCreate(db);
    }

    public ArrayList<Categories> getAllCategories() {
        ArrayList<Categories> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from tblCategories";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(0);
                    int image = cursor.getInt(1);
                    int idCategories = cursor.getInt(2);
                    arrayList.add(new Categories(name, image, idCategories));
                } while (cursor.moveToNext());
            }
        }
        return arrayList;
    }

    public ArrayList<Items> getALLItems() {
        ArrayList<Items> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from tblItem";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    int id = csr.getInt(0);
                    String name = csr.getString(1);
                    String description = csr.getString(2);
                    int image = csr.getInt(3);
                    int categoriesID = csr.getInt(4);
                    arr.add(new Items(name, description, image, categoriesID, id));
                } while (csr.moveToNext());
            }
        }
        return arr;
    }

//    public Items getItemDetail(int idItems){
//        SQLiteDatabase db = getReadableDatabase();
//        String sql = "select * from tblItem where ID="+idItems;
//        Cursor csr = db.rawQuery(sql, null);
//        if (csr != null) {
//            if (csr.moveToFirst()) {
//                int id = csr.getInt(0);
//                String name = csr.getString(1);
//                int image = csr.getInt(2);
//                String description = csr.getString(3);
//                int categoriesID = csr.getInt(4);
//                return new Items(name,description,image,categoriesID,id);
//            }
//        }
//        return null;
//    }


    public void insertCategories(Categories categories) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", categories.categoryName);
        contentValues.put("Image", categories.categoryImg);
        db.insert("tblCategories", null,contentValues);
        db.close();
    }
    public void insertItem(Items items){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", items.itemName);
        contentValues.put("Description", items.itemDes);
        contentValues.put("Image", items.itemImg);
        contentValues.put("CategoriesID", items.idcategories);
        db.insert("tblItem",null, contentValues);
        db.close();
    }

    public int countCategories(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("tblCategories",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            return cursor.getCount();
        }
        return 0;
    }


}
