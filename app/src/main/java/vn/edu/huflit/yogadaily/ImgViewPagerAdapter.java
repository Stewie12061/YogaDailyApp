package vn.edu.huflit.yogadaily;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ImgViewPagerAdapter extends PagerAdapter {

    private List<ImgYoga> list;

    public ImgViewPagerAdapter(List<ImgYoga> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_page,container,false);
        ImageView imageView = view.findViewById(R.id.yoga_img_1);
        ImgYoga imgYoga = list.get(position);
        imageView.setImageResource(imgYoga.getImageId());

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
