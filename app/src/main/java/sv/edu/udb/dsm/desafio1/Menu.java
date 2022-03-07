package sv.edu.udb.dsm.desafio1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class Menu extends AppCompatActivity {

    TextView Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Usuario= (TextView) findViewById(R.id.txtm1);
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);


        String user=preferences.getString("user", "No existe informacion");
        Usuario.setText(user);


    }


    public void Borrar(View view){

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();

        Intent llamar = new Intent(this,MainActivity.class);
        startActivity(llamar);
    }

    public void Ejercicio2(View view){
        Intent llamar = new Intent(this,Ejercicio2.class);
        startActivity(llamar);
    }

    public void Ejercicio1(View view){
        Intent llamar = new Intent(this,Ejercicio1.class);
        startActivity(llamar);
    }

}