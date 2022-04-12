package codec3rd.emartinez.ecards.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import codec3rd.emartinez.ecards.R;
import codec3rd.emartinez.ecards.domain.Employee;
import codec3rd.emartinez.ecards.view.adapterui.AdapterViewEmployee;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 11:03 PM.
 **/
public class AdapterEmployee extends RecyclerView.Adapter<AdapterViewEmployee>
{
    //Data
    private final ArrayList<Employee> dataSet;


    /*
        Constructor
     */
    public AdapterEmployee(ArrayList<Employee> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public AdapterViewEmployee onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_employees,
                parent,false);
        return new AdapterViewEmployee(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewEmployee holder, int position)
    {
        // dataModal = dataSet.get(position)
        Employee objEmployee = dataSet.get(position);
        holder.textViewValueFirstName.setText(objEmployee.firstName);
        holder.textViewValueLastName.setText(objEmployee.lastName);
        holder.textViewValueJobTiitle.setText(objEmployee.jobTitle);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
