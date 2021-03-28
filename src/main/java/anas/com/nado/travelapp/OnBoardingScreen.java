package anas.com.nado.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import anas.com.nado.travelapp.adapters.OnBoardingAdapter;
import anas.com.nado.travelapp.datasupplier.OnBoardingSupplier;
import anas.com.nado.travelapp.model.OnBoardingModel;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager viewPager;
    List<OnBoardingModel> onBoardingModel;
    PagerAdapter pagerAdapter;
    LinearLayout indicatorsContainer;
    TextView[]dots;
    ViewPager.OnPageChangeListener listener;
    Button getStarted;
    private static final String HOME_TAG = "anas.com.nado.HOME_SCREEN" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();//fun for hide statusBar _ or TitleBAr // for hide ActionBar go to style
        setContentView(R.layout.activity_on_boarding_screen);
        //getActionBar().hide();

        // Nope i don't hear you
        //ok  wait


        //updateSeen();

        viewPager=findViewById(R.id.onboarding_pageview);
        onBoardingModel=OnBoardingSupplier.getOnBoardingObjects();
        pagerAdapter=new OnBoardingAdapter(onBoardingModel,this);


        viewPager.setAdapter(pagerAdapter);

        indicatorsContainer=findViewById(R.id.dots_container);
        addPageIndicaters(0);


        addOnPageChangeListener();
        viewPager.addOnPageChangeListener(listener);

        addGetStartedButton();
       // indicatorsContainer=findViewById(R.id.dots_container);
      //  addPageIndicaters();//to5d text view (dots)

    }

    private void addGetStartedButton() {

        getStarted=findViewById(R.id.button);

        final Intent intent=new Intent(this,HomeScreen.class);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateSeen();
                startActivity(intent);
            }
        });
    }

    private void addOnPageChangeListener(){

         listener= new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addPageIndicaters(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    private void addPageIndicaters(int position) {// Controll on dash

        indicatorsContainer.removeAllViews();
        dots=new TextView[onBoardingModel.size()];

        for(int i=0 ; i<dots.length ; i++){
             dots[i]=new TextView(this);
             dots[i].setText(Html.fromHtml("&mdash;"));// change icons of swap
             dots[i].setTextSize(30);
             dots[i].setTextColor(getResources().getColor(R.color.brandGray));
             indicatorsContainer.addView(dots[i]);


        }
        dots[position].setTextColor(getResources().getColor(R.color.colorwhitOrang));
    }

    private void hideStatusBar() {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    private void updateSeen() {

        SharedPreferences sharedPreferences = getSharedPreferences(DeciderActivity.MyPREFERENCES, Context.MODE_PRIVATE);// ms2ool 3n 8ra2a
        SharedPreferences.Editor editor = sharedPreferences.edit(); //ms2ool 3n edit
        editor.putBoolean("seen", true);
        editor.apply();
    }
}
