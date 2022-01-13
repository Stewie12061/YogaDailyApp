package vn.edu.huflit.yogadaily;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BmiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BmiFragment extends Fragment {
    ImgViewPagerAdapter imgViewPagerAdapter;
    ViewPager viewPager;
    List<ImgYoga> listImg;
    Handler mHandler = new Handler();
    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager.getCurrentItem() ==  listImg.size() - 1){
                viewPager.setCurrentItem(0);
            }
            else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    };

    EditText edtHeightInfo, edtWeightInfo;
    TextView bmitxt, resulttxt;
    SharedPreferences sharedPreferences;
    Button calculate;
    CardView resultcard;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BmiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BmiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BmiFragment newInstance(String param1, String param2) {
        BmiFragment fragment = new BmiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        listImg = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewPager);

        edtHeightInfo = view.findViewById(R.id.edtHeightInfo);
        edtWeightInfo = view.findViewById(R.id.edtWeightInfo);
        bmitxt = view.findViewById(R.id.bmi);
        resulttxt = view.findViewById(R.id.resulttxt);
        calculate = view.findViewById(R.id.calculate);
        resultcard = view.findViewById(R.id.resultcard);

        listImg = DataImg.init_img();
        imgViewPagerAdapter = new ImgViewPagerAdapter(listImg);
        viewPager.setAdapter(imgViewPagerAdapter);

        mHandler.postDelayed(mRunnable, 3000);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        sharedPreferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        edtWeightInfo.setText(sharedPreferences.getString("weight", ""));
        edtHeightInfo.setText(sharedPreferences.getString("height", ""));

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtWeightInfo.length() == 0 || edtHeightInfo.length() == 0) {
                    Toast.makeText(view.getContext(), "Populate Weight and Height to Calculate BMI", Toast.LENGTH_SHORT);
                } else {
                    double heightInCms = Double.parseDouble(edtHeightInfo.getText().toString());
                    double weightInKgs = Double.parseDouble(edtWeightInfo.getText().toString());
                    double bmi = BMICalcUtil.getInstance().calculateBMIMetric(heightInCms, weightInKgs);
                    displayBMI(bmi);
                }
            }

            private void displayBMI(double bmi) {
                resultcard.setVisibility(View.VISIBLE);

                bmitxt.setText(String.format("%.2f", bmi));

                String bmiResult = BMICalcUtil.getInstance().classifyBMI(bmi);
                resulttxt.setText(bmiResult);

                switch (bmiResult) {
                    case BMICalcUtil.BMI_CATEGORY_UNDERWEIGHT:
                        resultcard.setCardBackgroundColor(Color.YELLOW);
                        break;
                    case BMICalcUtil.BMI_CATEGORY_HEALTHY:
                        resultcard.setCardBackgroundColor(Color.GREEN);
                        break;
                    case BMICalcUtil.BMI_CATEGORY_OVERWEIGHT:
                        resultcard.setCardBackgroundColor(Color.YELLOW);
                        break;
                    case BMICalcUtil.BMI_CATEGORY_OBESE:
                        resultcard.setCardBackgroundColor(Color.RED);
                        break;
                }
            }
        });

    }
    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).getSupportActionBar().show();
    }
}

