package sv.edu.udb.dsm.desafio1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Respuesta extends AppCompatActivity {
    TextView Usuario;

    private TextView txtnom;
    private TextView txtmes;
    private  TextView txtvent;
    private TextView txtpcom;
    private TextView txtcom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        Usuario= (TextView) findViewById(R.id.txtr1);
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        String user=preferences.getString("user", "No existe informacion");
        Usuario.setText(user);

        txtnom=(TextView) findViewById(R.id.txt1);
        txtmes=(TextView) findViewById(R.id.txt2);
        txtvent=(TextView) findViewById(R.id.txt3);
        txtpcom=(TextView) findViewById(R.id.txt4);
        txtcom=(TextView) findViewById(R.id.txt5);

        Bundle bundle = getIntent().getExtras();
        String nombre= bundle.getString("nombre");
        String mes= bundle.getString("mes");
        String venta= bundle.getString("ventas");
        String pcom= bundle.getString("pcomision");
        String com= bundle.getString("comicion");

        txtnom.setText(nombre);
        txtmes.setText(mes);
        txtvent.setText(venta);
        txtpcom.setText(pcom);
        txtcom.setText(com);


    }

    public void Borrar(View view){

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();

        Intent llamar = new Intent(this,MainActivity.class);
        startActivity(llamar);
    }
}