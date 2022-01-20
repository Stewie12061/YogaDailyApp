package vn.edu.huflit.yogadaily;

import java.util.Objects;

public class Categories {
    String categoryName;
    int categoryImg;
    int idCategories;
    int iditems;

//    public Categories(String categoryName, int categoryImg){
//        this.categoryName = categoryName;
//        this.categoryImg = categoryImg;
//    }
    public Categories(String categoryName, int categoryImg, int idCategories){
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
        this.idCategories = idCategories;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(int categoryImg) {
        this.categoryImg = categoryImg;
    }

    public int getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(int idCategories) {
        this.idCategories = idCategories;
    }
    //    public Categories(String categoryName, int categoryImg, int idCategories, int iditems){
//        this.categoryName = categoryName;
//        this.categoryImg = categoryImg;
//        this.idCategories = idCategories;
//        this.iditems = iditems;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Categories that = (Categories) o;
//        return categoryImg == that.categoryImg &&
//                idCategories == that.idCategories &&
//                iditems == that.iditems &&
//                categoryName.equals(that.categoryName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(categoryName, categoryImg, idCategories, iditems);
//    }

}
