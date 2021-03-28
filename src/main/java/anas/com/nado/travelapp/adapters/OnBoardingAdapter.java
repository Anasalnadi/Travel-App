package anas.com.nado.travelapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import anas.com.nado.travelapp.R;
import anas.com.nado.travelapp.model.OnBoardingModel;

public class OnBoardingAdapter extends PagerAdapter {

    List<OnBoardingModel> pagesModel;
    Context context;
     LayoutInflater layoutinflater;

    public OnBoardingAdapter(List<OnBoardingModel> pagesModel, Context context) {
        this.pagesModel = pagesModel;
        this.context = context;
    }


    @Override
    public int getCount() {
        return pagesModel.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object; // object r7 ekon nos5a mn onboarding.xml ,, view r7 ekon refrances l page 7ale
                               // true 8om b e3adt alrsm ,, false e3adt rsm nfse m3 mo7tweat jdeda

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // t8om b tjhez shasha Jdeda
        layoutinflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutinflater.inflate(R.layout.onboarding,container,false);

        ImageView imageView=view.findViewById(R.id.page_image);
        TextView titleTextView=view.findViewById(R.id.page_title);
        TextView descriptionTextView=view.findViewById(R.id.page_description);

        OnBoardingModel onBoardingModel= pagesModel.get(position);
        imageView.setImageResource(onBoardingModel.getImage());
        titleTextView.setText(onBoardingModel.getTitle());
        descriptionTextView.setText(onBoardingModel.getDescription());

        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((View) object);
    }
}
