package codec3rd.emartinez.ecards.contract;

import android.app.Activity;
import android.content.Context;

import java.util.List;

import codec3rd.emartinez.ecards.domain.Employee;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 7:53 PM.
 **/
public interface ContractInterface
{

    /*
        Views
     */

    interface ViewSplashScreen
    {
        void initView();
    }

    interface ViewMainActivity
    {
        void initView();
        void showAddEmployee();
        void fetchNamesEmployee();
    }

    interface ViewRegisterActivity
    {
        void initView();
        void addEmployee();
        boolean validateFields();
        void showDialogAddAddress();
    }



    /*
        Presenter
     */

    interface IPresenterSplashActivity
    {
        void showSplashActivity(Context context, Activity activity);
    }

    interface IPresenterMainActivity
    {
        void showAddEmployee(Context context, Activity activity);
        List<Employee> getAll();
    }

    interface IPresenterRegisterActivity
    {
        void addEmployee(Employee employee);

    }

}
