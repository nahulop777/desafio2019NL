package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserContainer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FragmentHome.notificador {

    private FragmentHome fragmentHome;
    private FragmentManager fragmentManager;
    @BindView(R.id.fragmentContainerMainActivity)
    CoordinatorLayout coordinatorLayout;
    private UserContainer userContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);

        handleIntent(getIntent());

        fragmentHome = new FragmentHome();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction unaTransaccion = fragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.fragmentContainerMainActivity, fragmentHome);
        unaTransaccion.commit();

    }

    @Override
    public void mandarNotificacion(User user) {

        Intent intent = new Intent(this, DetalleActivity.class);
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(DetalleActivity.KEY_USER,user);
        intent.putExtras(bundle2);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

        }
    }
}
