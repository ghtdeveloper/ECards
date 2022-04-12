package codec3rd.emartinez.ecards.presenter;

import android.content.Context;

import codec3rd.emartinez.ecards.contract.ContractInterface;
import codec3rd.emartinez.ecards.domain.Employee;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 8:40 PM.
 **/
public class RegisterActivityIPresenter implements ContractInterface.IPresenterRegisterActivity
{
    //Context App
    private Context contextApp = null;
    //private

    /*
       Constructor
    */
    public RegisterActivityIPresenter(Context context)
    {
        contextApp = context;
       // objInteractor = new EmployeeInteractor();
    }


    @Override
    public void addEmployee(Employee employee) {

    }
}
