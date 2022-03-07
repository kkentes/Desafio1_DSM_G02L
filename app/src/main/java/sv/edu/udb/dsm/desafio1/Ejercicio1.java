package sv.edu.udb.dsm.desafio1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio1 extends AppCompatActivity {
    TextView Usuario;

    private EditText nombre;
    private EditText cod;
    private EditText ventas;
    private EditText mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        Usuario= (TextView) findViewById(R.id.txte1);
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        String user=preferences.getString("user", "No existe informacion");
        Usuario.setText(user);

        nombre=(EditText) findViewById(R.id.txtnombre);
        cod=(EditText) findViewById(R.id.txtcodigo);
        ventas=(EditText) findViewById(R.id.txtventa);
        mes=(EditText) findViewById(R.id.txtmes);
    }

    public void Borrar(View view){

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();

        Intent llamar = new Intent(this,MainActivity.class);
        startActivity(llamar);
    }


    public  void enviar(View view) {

        String valor=ventas.getText().toString();
        int nro=Integer.parseInt(valor);

        if (nro<500){
            double resp = nro;
            String resu=String.valueOf(resp);
            String pcomision = "0%";

            Intent i=new Intent(this,Respuesta.class);
            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("codigo",cod.getText().toString());
            i.putExtra("ventas",ventas.getText().toString());
            i.putExtra("mes",mes.getText().toString());
            i.putExtra("comicion",resu);
            i.putExtra("pcomision",pcomision);

            startActivity(i);
        }
        else if ( nro > 500 && nro < 1000){
            double resp = nro * 0.05;
            String resu=String.valueOf(resp);
            String pcomision = "5%";

            Intent i=new Intent(this,Respuesta.class);
            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("codigo",cod.getText().toString());
            i.putExtra("ventas",ventas.getText().toString());
            i.putExtra("mes",mes.getText().toString());
            i.putExtra("comicion",resu);
            i.putExtra("pcomision",pcomision);
            startActivity(i);
        }
        else if (nro > 1000 && nro < 2000){
            double resp = nro * 0.10;
            String resu=String.valueOf(resp);
            String pcomision = "10%";

            Intent i=new Intent(this,Respuesta.class);
            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("codigo",cod.getText().toString());
            i.putExtra("ventas",ventas.getText().toString());
            i.putExtra("mes",mes.getText().toString());
            i.putExtra("comicion",resu);
            i.putExtra("pcomision",pcomision);
            startActivity(i);
        }
        else if (nro > 2000 && nro < 3000){
            double resp = nro * 0.15;
            String resu=String.valueOf(resp);
            String pcomision = "15%";

            Intent i=new Intent(this,Respuesta.class);
            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("codigo",cod.getText().toString());
            i.putExtra("ventas",ventas.getText().toString());
            i.putExtra("mes",mes.getText().toString());
            i.putExtra("comicion",resu);
            i.putExtra("pcomision",pcomision);

            startActivity(i);
        }
        else if (nro > 3000 && nro < 4000){
            double resp = nro * 0.20;
            String resu=String.valueOf(resp);
            String pcomision = "20%";

            Intent i=new Intent(this,Respuesta.class);
            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("codigo",cod.getText().toString());
            i.putExtra("ventas",ventas.getText().toString());
            i.putExtra("mes",mes.getText().toString());
            i.putExtra("comicion",resu);
            i.putExtra("pcomision",pcomision);
            startActivity(i);
        }
        else if (nro >= 4000){
            double resp = nro * 0.30;
            String resu=String.valueOf(resp);
            String pcomision = "30%";

            Intent i=new Intent(this,Respuesta.class);
            i.putExtra("nombre",nombre.getText().toString());
            i.putExtra("codigo",cod.getText().toString());
            i.putExtra("ventas",ventas.getText().toString());
            i.putExtra("mes",mes.getText().toString());
            i.putExtra("comicion",resu);
            i.putExtra("pcomision",pcomision);
            startActivity(i);
        }

        Intent llamar = new Intent(this,Respuesta.class);
        startActivity(llamar);


    }
}