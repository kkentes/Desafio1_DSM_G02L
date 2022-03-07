package sv.edu.udb.dsm.desafio1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    EditText campousuario, campoPass;
    TextView txtUsuario, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campousuario= (EditText) findViewById(R.id.User);
        campoPass= (EditText) findViewById(R.id.Pass);
        txtUsuario= (TextView) findViewById(R.id.txtuser);
        txtPass= (TextView) findViewById(R.id.txtpass);

        cargar();
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn1:
                guardar();
                break;
                case R.id.btn2:
                    Intent intent=new Intent(this, Menu.class);
                    startActivity(intent);
                    break;
        }
    }

    private void guardar(){
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        String usuario=campousuario.getText().toString();
        String pass=campoPass.getText().toString();

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("user",usuario);
        editor.putString("pass", pass);


        editor.commit();

    }

    private void cargar(){
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        String user=preferences.getString("user", "No existe informacion");
        String pass=preferences.getString("pass", "No existe informacion");


    }
}