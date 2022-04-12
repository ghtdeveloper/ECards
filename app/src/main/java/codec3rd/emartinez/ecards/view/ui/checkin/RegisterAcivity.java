package codec3rd.emartinez.ecards.view.ui.checkin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Objects;

import codec3rd.emartinez.ecards.R;
import codec3rd.emartinez.ecards.adapters.AdapterAddresss;
import codec3rd.emartinez.ecards.contract.ContractInterface;
import codec3rd.emartinez.ecards.domain.Address;
import codec3rd.emartinez.ecards.domain.Employee;
import codec3rd.emartinez.ecards.presenter.RegisterActivityIPresenter;
import codec3rd.emartinez.ecards.repositories.room.database.AppDatabase;
import codec3rd.emartinez.ecards.view.ui.main.MainActivity;

public class RegisterAcivity extends AppCompatActivity  implements ContractInterface.
        ViewRegisterActivity
{
    //Objects
    private RegisterActivityIPresenter objPresenter = null;
    private AdapterAddresss objAdapter = null;
    private ArrayList<Address> dataList;
    private AlertDialog dialog;
    private AppDatabase db;
    //Views
    private TextInputEditText textInputEditTextFirstName;
    private TextInputEditText textInputEditTextLastName;
    private TextInputEditText textInputEditTextJobTitle;
    private TextInputEditText textInputEditTextPersonalID;
    private RecyclerView rvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        //Init Objetcts
        objPresenter = new RegisterActivityIPresenter(this);
        db = Room.databaseBuilder(this,AppDatabase.class,"ECards")
                .allowMainThreadQueries().build();
        //Init Views
        initView();
    }

    @Override
    public void initView()
    {
        //Config Toolbar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add Employee");
        getSupportActionBar().setIcon(R.drawable.ic_arrow_white_black_26dp);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvAddress = findViewById(R.id.rvAddress);
        rvAddress.setLayoutManager(new LinearLayoutManager(this));
        Button btnSave = findViewById(R.id.btnSave);
        textInputEditTextFirstName = findViewById(R.id.txtFirstName);
        textInputEditTextLastName = findViewById(R.id.txtLastName);
        textInputEditTextJobTitle = findViewById(R.id.txtjopTitle);
        textInputEditTextPersonalID = findViewById(R.id.txtPersonalID);
        TextView textViewAddAddress = findViewById(R.id.textViewAddAdress);
        //Listener
        btnSave.setOnClickListener(view -> addEmployee());
        textViewAddAddress.setOnClickListener(view -> showDialogAddAddress());
    }

    @Override
    public void addEmployee()
    {
        if(validateFields())
        {
            Log.d("VALIDATE","ALL OK");
            db.employeeDao().addEmployee(new Employee(Objects.
                    requireNonNull(textInputEditTextFirstName.
                    getText()).toString(), Objects.requireNonNull(textInputEditTextLastName.
                    getText()).toString(), Objects.requireNonNull(textInputEditTextPersonalID.
                    getText()).toString(), textInputEditTextPersonalID.getText().toString()));

            Toast.makeText(this, "Successfully registered employee!",
                    Toast.LENGTH_SHORT).show();

            showMainActivity();
        }
    }

    private void showMainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean validateFields()
    {
       if(Objects.requireNonNull(textInputEditTextFirstName.getText()).toString().trim().isEmpty())
       {
           Toast.makeText(this,"check that there are no empty fields",
                   Toast.LENGTH_LONG).show();
           return false;
       }
       else if(Objects.requireNonNull(textInputEditTextLastName.getText()).toString().
               trim().isEmpty())
       {
           Toast.makeText(this,"check that there are no empty fields",
                   Toast.LENGTH_LONG).show();
           return false;
       }

       else if(Objects.requireNonNull(textInputEditTextPersonalID.getText()).toString().
               trim().isEmpty())
       {
           Toast.makeText(this,"check that there are no empty fields",
                   Toast.LENGTH_LONG).show();
           return false;
       }

       else if(Objects.requireNonNull(textInputEditTextJobTitle.getText()).toString().
               trim().isEmpty())
       {
           Toast.makeText(this,"check that there are no empty fields",
                   Toast.LENGTH_LONG).show();
           return false;
       }
       else{
           return  true;
       }
    }

    @Override
    public void showDialogAddAddress()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.layout_add_address,null);
        builder.setView(dialogView);
        //Cast a las vistas
        EditText txtAvenue = dialogView.findViewById(R.id.txtAvenue);
        EditText txtCity = dialogView.findViewById(R.id.txtCity);
        EditText txtState = dialogView.findViewById(R.id.txtState);
        EditText txtCountry = dialogView.findViewById(R.id.txtCountry);
        Button btnSave = dialogView.findViewById(R.id.btnAddAdressDialog);

        //Listeners
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.employeeDao().addAddress(new Address(txtAvenue.getText().toString(),
                        txtCity.getText().toString(),txtState.getText().toString(),
                        txtCountry.getText().toString()));
                //objAdapter = new
                dialog.dismiss();
            }
        });

        dialog = builder.create();
        dialog.getLayoutInflater();
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataList = new ArrayList<>();
        if(db.employeeDao().getEmployeeWithAddress().isEmpty())
        {
            Log.d("Address","There is not address");
        }else
        {
            //dataList.addAll(db.employeeDao().getEmployeeWithAddress());
        }
    }
}