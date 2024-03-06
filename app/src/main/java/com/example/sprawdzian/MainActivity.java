package com.example.sprawdzian;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText textA = findViewById(R.id.a);
        EditText textB = findViewById(R.id.b);
        EditText textC = findViewById(R.id.c);
        TextView Wynik = findViewById(R.id.delta);

        Button oblicz = findViewById(R.id.oblicz);
        oblicz.setOnClickListener((View v) -> {
            try {
                Double a = Double.parseDouble(textA.getText().toString());
                Double b = Double.parseDouble(textB.getText().toString());
                Double c = Double.parseDouble(textC.getText().toString());

                Double delta = b*b + -4*a*c;

                Wynik.setText("");

                if(delta < 0){
                    Toast.makeText(getBaseContext(),"brak rozwiązań", Toast.LENGTH_SHORT).show();
                }else if(delta == 0){
                    Double x = (-1*b + sqrt(delta))/2;

                    Wynik.setText("X=" + String.format(x.toString()));
                }else if(delta > 0){
                    Double x = (-1*b - sqrt(delta))/2;
                    Double x2 = (-1*b + sqrt(delta))/2;

                    Wynik.setText("X={" + String.format(x.toString()) + ", " + String.format(x2.toString()) + "}");
                }
            }
            catch (NumberFormatException e){
                Toast.makeText(getBaseContext(),"brak danych", Toast.LENGTH_SHORT).show();}

        });

    }
}