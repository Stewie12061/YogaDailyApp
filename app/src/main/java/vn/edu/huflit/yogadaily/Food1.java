package vn.edu.huflit.yogadaily;

public class Food1 {
    String foodName1;
    String foodDes1;
    int foodImg1;


    public Food1(String foodName1, String foodDes1, int foodImg1){
        this.foodName1 = foodName1;
        this.foodDes1 = foodDes1;
        this.foodImg1 = foodImg1;
    }

    public String getFoodName1() {
        return foodName1;
    }

    public void setFoodName1(String foodName1) {
        this.foodName1 = foodName1;
    }

    public String getFoodDes1() {
        return foodDes1;
    }

    public void setFoodDes1(String foodDes1) {
        this.foodDes1 = foodDes1;
    }

    public int getFoodImg() {
        return foodImg1;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg1 = foodImg;
    }
}
