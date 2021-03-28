package anas.com.nado.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import anas.com.nado.travelapp.adapters.DestinationsAdapter;
import anas.com.nado.travelapp.model.Destination;


public class HomeScreen extends AppCompatActivity {

    private static final String TAG ="AMX" ;
    public String destinationAPI;

    public RequestQueue requestQueue; //==> object from API volley

    public List<Destination> destinations;//==> destinations

    public DestinationsAdapter destinationsAdapter;
    public RecyclerView destinationsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupEmplements();
        destinationsAdapter = new DestinationsAdapter( destinations , HomeScreen.this);
        destinationsRecyclerView.setAdapter( destinationsAdapter );
        fetchDestinations();

    }

    private void fetchDestinations() {
        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(
                Request.Method.GET,
                destinationAPI,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            //JSONArray data = response.getJSONArray();
                            for( int i = 0; i < response.length(); i++ ){

                                    JSONObject jsonObject = response.getJSONObject(i);
                                    Destination destination = new Destination(
                                            jsonObject.getInt( "id" ),
                                            jsonObject.getString( "title" ),
                                            jsonObject.getString( "featured_image"),
                                            // TODO : Replace from API
                                            25
                                    );
                                    destinations.add( destination );
                                    destinationsAdapter.notifyDataSetChanged();



                                //TODO :Display in Recycler View
//                                destinationsAdapter.setOnClickItemListener(new DestinationsAdapter.DestinstionClickListener() {
//                                    @Override
//                                    public void onDestinationClickListener(int position) {
//                                        Intent intent = new Intent( HomeScreen.this , DestinationPlaces.class );
//                                        Destination destination = destinations.get( position );
//                                        intent.putExtra( "destination_title" , destination.getTitle() );
//                                        startActivity( intent );
//                                    }
//                                }
//                                );
                            }
                        } catch (JSONException e) {
                            // TODO : Handle Errors
                            e.printStackTrace();
                            Log.v("JSON ERROR", e.getLocalizedMessage());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle Errors
                        error.printStackTrace();
                        Log.d(TAG, "onErrorResponse: REQUEST FAILED");
                    }
                }

        );

        requestQueue.add( jsonObjectRequest );


    }

    private void setupEmplements() {
        setContentView(R.layout.activity_home_screen);
        destinationAPI=getString(R.string.api_base);
        requestQueue= Volley.newRequestQueue(this);
        destinations=new ArrayList<Destination>();
        destinationsRecyclerView=findViewById(R.id.destinations_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        destinationsRecyclerView.setLayoutManager(layoutManager);

        Log.d(TAG,"setupElements destination API " + destinationAPI);

        Log.d(TAG,"setupElements destination API " + destinationAPI);



    }
}
