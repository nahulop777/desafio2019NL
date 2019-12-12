package com.example.myapplication.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleActivity extends AppCompatActivity {

    public static final String KEY_USER = "usuario";


    @BindView(R.id.imagenUser)
    ImageView imageViewImagenUser;
    @BindView(R.id.nombre)
    TextView textViewNombre;
    @BindView(R.id.apellido)
    TextView textViewApellido;
    @BindView(R.id.edad)
    TextView textViewEdad;
    @BindView(R.id.email)
    TextView textViewMail;
    @BindView(R.id.buttonMap)
    Button buttonbuttonMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        final User user = (User) bundle.getSerializable(KEY_USER);

        Glide.with(this).load(user.getPicture().getLarge()).into(imageViewImagenUser);
        textViewNombre.setText(user.getName().getFirst());
        textViewApellido.setText(user.getName().getLast());
        String edad = user.getDob().getAge() + " años de edad";
        textViewEdad.setText(edad);
        textViewMail.setText(user.getEmail());

        buttonbuttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleActivity.this, MapaActivity.class);
                Bundle mapaBundle = new Bundle();
                Double latitud = user.getLocation().getCoordinates().getLatitude();
                Double longitud = user.getLocation().getCoordinates().getLongitude();
                mapaBundle.putDouble(MapaActivity.LATITUD, latitud );
                mapaBundle.putDouble(MapaActivity.LONGITUD, longitud);
                intent.putExtras(mapaBundle);
                startActivity(intent);
            }

        });


    }
}

