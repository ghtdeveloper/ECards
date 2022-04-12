package codec3rd.emartinez.ecards.view.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

import codec3rd.emartinez.ecards.R;
import codec3rd.emartinez.ecards.adapters.AdapterEmployee;
import codec3rd.emartinez.ecards.contract.ContractInterface;
import codec3rd.emartinez.ecards.domain.Employee;
import codec3rd.emartinez.ecards.presenter.MainActivityIPresenter;
import codec3rd.emartinez.ecards.repositories.room.database.AppDatabase;

public class MainActivity extends AppCompatActivity implements ContractInterface.ViewMainActivity
{
    //Objects
    private MainActivityIPresenter objPresenter = null;
    private AdapterEmployee objAdapter = null;
    private ArrayList<Employee> dataList;
    private AppDatabase db;
    //Views
    private RecyclerView rvEmployees;
    private ImageView imgViewNoData;
    private TextView textViewNoData;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Init Objects
        objPresenter = new MainActivityIPresenter(this);
        db = Room.databaseBuilder(this,AppDatabase.class,"ECards")
                .allowMainThreadQueries().build();
        //Init Views
        initView();
    }

    @Override
    public void initView()
    {
        FloatingActionButton btnAddEmployee = findViewById(R.id.floatingActionButton);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Employees");
        rvEmployees = findViewById(R.id.rvEmployees);
        imgViewNoData = findViewById(R.id.imgNoData);
        textViewNoData = findViewById(R.id.textViewNoData);
        rvEmployees.setLayoutManager(new LinearLayoutManager(this));
        //Listeners
        btnAddEmployee.setOnClickListener(view -> showAddEmployee());
        //fetchNamesEmployee();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchNamesEmployee();
    }

    @Override
    public void showAddEmployee() {objPresenter.showAddEmployee(this,this); }

    @Override
    public void fetchNamesEmployee()
    {
        dataList = new ArrayList<>();

        if(db.employeeDao().getAll().isEmpty())
        {
            imgViewNoData.setVisibility(View.VISIBLE);
            textViewNoData.setVisibility(View.VISIBLE);
        }else
        {
            dataList.addAll(db.employeeDao().getAll());
            imgViewNoData.setVisibility(View.INVISIBLE);
            textViewNoData.setVisibility(View.INVISIBLE);
            objAdapter = new AdapterEmployee(dataList);
            rvEmployees.setAdapter(objAdapter);
            rvEmployees.setVisibility(View.VISIBLE);

        }
    }

}