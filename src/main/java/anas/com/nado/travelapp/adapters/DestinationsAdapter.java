package anas.com.nado.travelapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import anas.com.nado.travelapp.R;
import anas.com.nado.travelapp.model.Destination;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.DestinationViewHolder>

{

    private List<Destination> destinations;
    private Context context;

    public DestinationsAdapter(List<Destination> destinations, Context context) {
        this.destinations = destinations;
        this.context = context;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public Context getContext() {
        return context;
    }


    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.destination_item,parent,false);
        return new DestinationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        final Destination destination=destinations.get(position);
        holder.destinationTitle.setText(destination.getTitle());
        holder.placesCount.setText(String.valueOf(destination.getPlaceCount()+"places"));
        holder.destinationImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,destination.getTitle(),Toast.LENGTH_LONG).show();
            }
        });
        holder.destinationImage.setImageResource(R.drawable.bording1);
        Picasso.get().load(destination.getFeaturedImageUrl()).fit().into(holder.destinationImage);

    }

    @Override
    public int getItemCount() {
        return destinations.size();
    }

    //------------------------------------


    class DestinationViewHolder extends RecyclerView.ViewHolder{

        TextView destinationTitle;
        TextView placesCount;
        ImageView destinationImage;

         DestinationViewHolder(@NonNull View itemView) {
            super(itemView);

            setupElements();
        }

        private void setupElements() {
            destinationImage=itemView.findViewById(R.id.destination_iamge);
            destinationTitle=itemView.findViewById(R.id.destination_title);
            placesCount=itemView.findViewById(R.id.places_count);

        }
    }
}
