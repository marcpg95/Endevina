package com.example.endevina2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numeroEscrito;
    EditText nombreEscrito;
    Button endevina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final int random = (int)(Math.random()*5)+1;
        numeroEscrito = findViewById(R.id.numero);
        nombreEscrito = findViewById(R.id.nombre);
        endevina= findViewById(R.id.button);
        String nombreIntroducido=nombreEscrito.getText().toString();

        endevina.setOnClickListener(new View.OnClickListener(){
            int intentos=0;

            @Override
            public void onClick(View v) {
                int numeroIntroducido = Integer.parseInt((numeroEscrito.getText().toString()));


                    if (numeroIntroducido>=100){
                        Toast.makeText( MainActivity.this,  "El numero ha de ser menor a 100" , Toast.LENGTH_LONG).show();
                    }
                    else if(numeroIntroducido<1){
                        Toast.makeText( MainActivity.this,  "El numero ha de ser major a 0" , Toast.LENGTH_LONG).show();
                    }
                    else if(numeroIntroducido!=random){
                        intentos++;
                        if (numeroIntroducido>random) {
                            Toast.makeText(MainActivity.this, "Has fallat torna a intentar-ho , el numero a endevinar es mes petit", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Has fallat torna a intentar-ho , el numero a endevinar es mes gran", Toast.LENGTH_LONG).show();

                        }

                    }

                    else{
                    Toast.makeText( MainActivity.this,  "Has encertat enorabona, has necesitat "+intentos+" intents" , Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Ranking.class);
                        intent.putExtra("nombre", nombreEscrito.getText().toString());
                        intent.putExtra("intentos",intentos);
                        startActivity(intent);

                    }

            }
        });



    }


}
