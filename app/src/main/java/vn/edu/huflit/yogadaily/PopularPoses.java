package vn.edu.huflit.yogadaily;

import java.io.Serializable;

public class PopularPoses implements Serializable {
    String name;
    int image;

    public PopularPoses(String name, int image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
