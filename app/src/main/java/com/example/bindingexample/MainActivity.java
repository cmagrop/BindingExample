package com.example.bindingexample;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.bindingexample.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;//enlazador de vistas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //configuracion de enlazado de vistas
        //configurar la variable binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = binding.etPassword.getText().toString();
                if(password.length()>=5)
                {
                    binding.enviarButton.setEnabled(true);

                    Toast.makeText(getApplicationContext(),"debe ser mayor a 5 el largo del password",Toast.LENGTH_LONG);
                }
                else
                {
                    binding.enviarButton.setEnabled(false);
                }
            }
        });

        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();







        /*Button getEnviarButton = findViewById(R.id.enviarButton);
        boolean opc=true;
        EditText pass = findViewById(R.id.et_password);
        String passString = pass.getText().toString();



        if(passString.length()>=5) //opc:true
        {
            getEnviarButton.setEnabled(true);


        }
        else
        {
            getEnviarButton.setEnabled(false);
        }

        getEnviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lo que se hará
            }
        });
       */
    }
}