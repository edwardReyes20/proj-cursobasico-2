package com.altice.curso.currencycalculator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton rbtn_dollar;
    RadioButton rbtn_pesos;
    RadioButton rbtn_euros;
    EditText monto_conversion;
    EditText dollar;
    EditText pesos;
    EditText euros;
    Button btnConvert;
    Button btnVerTasas;
    Button btnLimpiar;

    double valor_tasa_us =  49.3143;
    double valor_tasa_eur = 59.0243 ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dollar = this.findViewById(R.id.etxt_us);
        pesos = this.findViewById(R.id.etxt_dop);
        euros = this.findViewById(R.id.etxt_eur);
        monto_conversion = this.findViewById(R.id.etxt_monto);

        rbtn_dollar = this.findViewById(R.id.rbtn_us);
        rbtn_pesos = this.findViewById(R.id.rbtn_rd);
        rbtn_euros = this.findViewById(R.id.rbtn_eur);

        btnConvert = this.findViewById(R.id.btnConvertir);
        btnVerTasas = this.findViewById(R.id.btnVerTasa);
        btnLimpiar = this.findViewById(R.id.btnLimpiar);

        btnConvert.setOnClickListener(this);
        rbtn_dollar.setOnClickListener(this);
        rbtn_pesos.setOnClickListener(this);
        rbtn_euros.setOnClickListener(this);
        btnVerTasas.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v == btnConvert){
            limpiar();
            if (rbtn_dollar.isChecked()) {
                calcularDolares();

            }

            if (rbtn_pesos.isChecked()) {
                calcularPesos();
            }

            if (rbtn_euros.isChecked()) {
                calculoEuros();
            }

        }

        if (v == btnVerTasas){

            Toast.makeText(this, "El valor del US$: "+ valor_tasa_us + '\n' + "El valor del EUR: " + valor_tasa_eur,Toast.LENGTH_SHORT).show();

        }

        if (v == btnLimpiar ){
            limpiar();
        }

        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(monto_conversion.getWindowToken(), 0);

    }

    @SuppressLint("SetTextI18n")
    public void calcularDolares(){

        double valor_monto;

        valor_monto =Double.parseDouble(monto_conversion.getText().toString());

        pesos.setText(Double.toString(valor_monto * valor_tasa_us));
        euros.setText(Double.toString(valor_monto / valor_tasa_eur));
        dollar.setText(Double.toString(valor_monto));

    }
    @SuppressLint("SetTextI18n")
    public void calcularPesos(){

        double valor_monto;

        valor_monto = Double.parseDouble(monto_conversion.getText().toString());

        dollar.setText(Double.toString(valor_monto / valor_tasa_us));
        euros.setText(Double.toString(valor_monto / valor_tasa_eur));
        pesos.setText(Double.toString(valor_monto));

    }
    @SuppressLint("SetTextI18n")
    public void calculoEuros(){

        double valor_monto;

        valor_monto =Double.parseDouble(monto_conversion.getText().toString());

        pesos.setText(Double.toString(valor_monto * valor_tasa_eur));
        dollar.setText(Double.toString(valor_tasa_eur / valor_monto));
        euros.setText(Double.toString(valor_monto));

    }

    public void limpiar(){

        pesos.setText("");
        dollar.setText("");
        euros.setText("");
    }

}


