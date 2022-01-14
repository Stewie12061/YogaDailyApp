package vn.edu.huflit.yogadaily;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper {

    Context context;

    String dbName = "YogaDaily.db";

    public DBHelper(Context context) {
        this.context = context;
    }
    private SQLiteDatabase openDB() {
        return context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }

    private void closeDB(SQLiteDatabase db) {
        db.close();
    }

    public void createTable() {
        SQLiteDatabase db = openDB();
        String sqlCategories = "CREATE TABLE IF NOT EXISTS tblCategories (" +
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
        closeDB(db);
    }
    public ArrayList<Categories> getAllCategories() {
        SQLiteDatabase db = openDB();
        ArrayList<Categories> arrayList = new ArrayList<>();
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
        closeDB(db);
        return arrayList;
    }

    public ArrayList<Items> getALLItems() {
        SQLiteDatabase db = openDB();
        ArrayList<Items> arr = new ArrayList<>();
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
        closeDB(db);
        return arr;
    }

    public Items getItemDetail(int idItems){
        SQLiteDatabase db = openDB();
        String sql = "select * from tblItem where ID="+idItems;
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                int id = csr.getInt(0);
                String name = csr.getString(1);
                int image = csr.getInt(2);
                String description = csr.getString(3);
                int categoriesID = csr.getInt(4);
                closeDB(db);
                return new Items(name,description,image,categoriesID,id);
            }
        }
        closeDB(db);
        return null;
    }


    public void insertCategories(Categories categories) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", categories.categoryName);
        contentValues.put("Image", categories.categoryImg);
        SQLiteDatabase db = openDB();
        db.insert("tblCategories", null,contentValues);
        closeDB(db);
    }
    public void insertItem(Items items){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", items.itemName);
        contentValues.put("Description", items.itemDes);
        contentValues.put("Image", items.itemImg);
        contentValues.put("CategoriesID", items.idcategories);
        SQLiteDatabase db = openDB();
        db.insert("tblItem",null, contentValues);
        closeDB(db);
    }

    public int countCategories(){
        SQLiteDatabase db = openDB();
        Cursor cursor = db.query("tblCategories",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            return cursor.getCount();
        }
        return 0;
    }


}
