package com.example.temprature;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtdoC, edtdoF;
    Button btncf, btnfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtdoF = findViewById(R.id.edtdoF);
        edtdoC = findViewById(R.id.edtdoC);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);
        Button btnClear = findViewById(R.id.btnClear);

        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doC = edtdoC.getText().toString().trim();
                if (!doC.isEmpty()) {
                    try {
                        double C = Double.parseDouble(doC);
                        DecimalFormat dcf = new DecimalFormat("#.00");
                        edtdoF.setText(dcf.format(C * 1.8 + 32));
                    } catch (NumberFormatException e) {
                        edtdoF.setText("Invalid input");
                    }
                } else {
                    edtdoF.setText("Please enter Celsius");
                }
            }
        });

        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doF = edtdoF.getText().toString().trim();
                if (!doF.isEmpty()) {
                    try {
                        double F = Double.parseDouble(doF);
                        DecimalFormat dcf = new DecimalFormat("#.00");
                        edtdoC.setText(dcf.format((F - 32) / 1.8));
                    } catch (NumberFormatException e) {
                        edtdoC.setText("Invalid input");
                    }
                } else {
                    edtdoC.setText("Please enter Fahrenheit");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtdoF.setText("");
                edtdoC.setText("");
            }
        });
    }

}