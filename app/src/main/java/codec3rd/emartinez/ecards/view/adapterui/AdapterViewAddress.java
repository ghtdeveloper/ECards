package codec3rd.emartinez.ecards.view.adapterui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import codec3rd.emartinez.ecards.R;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:12,Tuesday,2022,
 * ***Hora: 12:29 AM.
 **/
public class AdapterViewAddress  extends RecyclerView.ViewHolder
{
    //Views
    public TextView textViewAvenue;
    public TextView textViewState;
    public TextView textViewCity;
    public TextView textViewCountry;

    public AdapterViewAddress(@NonNull View itemView) {
        super(itemView);
        textViewAvenue = itemView.findViewById(R.id.textAvenueValue);
        textViewState = itemView.findViewById(R.id.textStateValue);
        textViewCity = itemView.findViewById(R.id.textValueCity);
        textViewCountry = itemView.findViewById(R.id.textCountryValue);

    }
}
