package codec3rd.emartinez.ecards.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import java.util.List;
import codec3rd.emartinez.ecards.contract.ContractInterface;
import codec3rd.emartinez.ecards.domain.Employee;
import codec3rd.emartinez.ecards.view.ui.checkin.RegisterAcivity;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 8:29 PM.
 **/
public class MainActivityIPresenter implements ContractInterface.IPresenterMainActivity
{
    //Context App
    private Context contextApp;


    /*
        Constructors
     */
    public MainActivityIPresenter(Context context)
    {
        contextApp = context;
    }



    @Override
    public void showAddEmployee(Context context, Activity activity)
    {
        context = contextApp;
        Context finalContext = context;
        new Handler().postDelayed(() -> {
            Intent intentActividadLogin = new Intent(finalContext, RegisterAcivity.class);
            activity.startActivity(intentActividadLogin);
            activity.finish();
        }, 1100);

    }

    @Override
    public List<Employee> getAll() {
        return null;
    }


}
