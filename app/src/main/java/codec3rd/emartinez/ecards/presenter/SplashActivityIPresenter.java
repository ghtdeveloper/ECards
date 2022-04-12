package codec3rd.emartinez.ecards.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import codec3rd.emartinez.ecards.contract.ContractInterface;
import codec3rd.emartinez.ecards.view.ui.main.MainActivity;

/**
 * ***Creado por: Edison Martinez,
 * ***Fecha:11,Monday,2022,
 * ***Hora: 7:56 PM.
 **/
public class SplashActivityIPresenter implements ContractInterface.IPresenterSplashActivity
{
    //Context App
    private final Context contextApp;

    /*
        Constructor
     */
    public SplashActivityIPresenter(Context context)
    {
        contextApp = context;
    }


    /*
        Show The Main Activity
     */
    @Override
    public void showSplashActivity(Context context, Activity activity)
    {
        context = contextApp;
        Context finalContext = context;
        new Handler().postDelayed(() -> {
            Intent intentActividadLogin = new Intent(finalContext, MainActivity.class);
            activity.startActivity(intentActividadLogin);
            activity.finish();
        }, 1100);
    }


}
