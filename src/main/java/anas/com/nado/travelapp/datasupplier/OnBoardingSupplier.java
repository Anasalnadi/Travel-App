package anas.com.nado.travelapp.datasupplier;

import java.util.ArrayList;
import java.util.List;

import anas.com.nado.travelapp.R;
import anas.com.nado.travelapp.model.OnBoardingModel;

public class OnBoardingSupplier {


    public static List<OnBoardingModel> getOnBoardingObjects(){

        ArrayList<OnBoardingModel>objects=new ArrayList<OnBoardingModel>();

        objects.add(new OnBoardingModel(R.drawable.cha1 ,"Plan Trip" ,"you can select the date and also we can  help you by suggesting to set a good schedule" ));
        objects.add(new OnBoardingModel(R.drawable.cha2 ,"Find abest Deal" ,"Found a flight that matches your destination and schedule? Book it instanly in just afew taps" ));
        objects.add(new OnBoardingModel(R.drawable.cha3 ,"Enjoy your Trip" ,"East discovering new place and share these bettween  your friend and travel togather" ));

        return objects;
    }
}
