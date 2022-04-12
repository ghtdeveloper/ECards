package codec3rd.emartinez.ecards.view.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import codec3rd.emartinez.ecards.R;
import codec3rd.emartinez.ecards.contract.ContractInterface;
import codec3rd.emartinez.ecards.presenter.SplashActivityIPresenter;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity implements ContractInterface.ViewSplashScreen
{
    //Object Presenter
    private SplashActivityIPresenter objPresenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Init Objetc
        objPresenter = new SplashActivityIPresenter(this);
        //Views
        initView();

    }

    @Override
    public void initView()
    {
        objPresenter.showSplashActivity(this,this);
    }

}