package codec3rd.emartinez.ecards.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import codec3rd.emartinez.ecards.R;
import codec3rd.emartinez.ecards.domain.Address;
import codec3rd.emartinez.ecards.view.adapterui.AdapterViewAddress;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 11:03 PM.
 **/
public class AdapterAddresss extends RecyclerView.Adapter<AdapterViewAddress>
{
    //Data
    private final ArrayList<Address> dataSet;


    /*
        Constructor
     */
    public AdapterAddresss(ArrayList<Address> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public AdapterViewAddress onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_address,
                parent,false);
        return new AdapterViewAddress(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewAddress holder, int position)
    {
        // dataModal = dataSet.get(position)
        Address objAddress = dataSet.get(position);
        holder.textViewAvenue.setText(objAddress.addressLine1);
        holder.textViewCity.setText(objAddress.city);
        holder.textViewState.setText(objAddress.state);
        holder.textViewCountry.setText(objAddress.country);
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
