package vn.edu.huflit.yogadaily;

import android.media.Image;

import java.util.Objects;

public class Items {
    String itemName;
    String itemDes;
    int itemImg;
    int idcategories;
    int idItems;

    public Items(String itemName, String itemDes, int itemImg){
        this.itemName = itemName;
        this.itemDes = itemDes;
        this.itemImg = itemImg;
    }
    public Items(String itemName, String itemDes, int itemImg, int idcategories){
        this.itemName = itemName;
        this.itemDes = itemDes;
        this.itemImg = itemImg;
        this.idcategories = idcategories;
    }

    public Items(String itemName, String itemDes, int itemImg, int idcategories, int idItems){
        this.itemName = itemName;
        this.itemDes = itemDes;
        this.itemImg = itemImg;
        this.idcategories = idcategories;
        this.idItems = idItems;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemImg == items.itemImg &&
                idcategories == items.idcategories &&
                idItems == items.idItems &&
                itemName.equals(items.itemName) &&
                itemDes.equals(items.itemDes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemDes, itemImg, idcategories, idItems);
    }

}
