package codec3rd.emartinez.ecards.view.adapterui;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import codec3rd.emartinez.ecards.R;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 10:55 PM.
 **/
public class AdapterViewEmployee extends RecyclerView.ViewHolder
{
    //Vistas
    public TextView textViewValueFirstName;
    public TextView textViewValueLastName;
    public TextView textViewValueJobTiitle;

    public AdapterViewEmployee(@NonNull View itemView)
    {
        super(itemView);
        textViewValueFirstName = itemView.findViewById(R.id.textFirstNameValue);
        textViewValueLastName = itemView.findViewById(R.id.textLastNameValue);
        textViewValueJobTiitle = itemView.findViewById(R.id.textJobTitleValue);
    }
}
