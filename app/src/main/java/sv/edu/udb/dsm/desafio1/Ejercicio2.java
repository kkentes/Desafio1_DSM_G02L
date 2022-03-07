package sv.edu.udb.dsm.desafio1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ejercicio2 extends AppCompatActivity {
    TextView Usuario;

    private EditText A;
    private EditText B;
    private EditText C;

    private TextView rx1;
    private TextView rx2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        Usuario= (TextView) findViewById(R.id.txte2);
        SharedPreferences preferences=getSharedPreferences
                ("credenciales", Context.MODE_PRIVATE);

        String user=preferences.getString("user", "No existe informacion");
        Usuario.setText(user);

        A=findViewById(R.id.num1);
        B=findViewById(R.id.num2);
        C=findViewById(R.id.num3);

        rx1=findViewById(R.id.rx1);
        rx2=findViewById(R.id.rx2);

    }

    public void Borrar(View view){

        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();

        Intent llamar = new Intent(this,MainActivity.class);
        startActivity(llamar);
    }


    public  void Calcular(View view){

        String valor1=A.getText().toString();
        String valor2=B.getText().toString();
        String valor3=C.getText().toString();

        int nro1=   Integer.parseInt(valor1);
        int nro2=   Integer.parseInt(valor2);
        int nro3=   Integer.parseInt(valor3);


        double pot = (Math.pow(nro2,2)-(4*nro1*nro3));
        double fracp = (-nro2+Math.sqrt(pot))/(2*nro1);
        double fracn = (-nro2-Math.sqrt(pot))/(2*nro1);

        String resu1=String.valueOf(fracp);
        String resu2=String.valueOf(fracn);

        rx1.setText(resu1);
        rx2.setText(resu2);


    }
}