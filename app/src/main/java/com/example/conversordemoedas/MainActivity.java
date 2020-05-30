package com.example.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValor = findViewById(R.id.edit_valor);
        this.mViewHolder.valorDolar = findViewById(R.id.valor_dolar);
        this.mViewHolder.valorEuro = findViewById(R.id.valor_euro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.button_calcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);

        this.limparValores();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calcular) {
            String valor = this.mViewHolder.editValor.getText().toString();
            if("".equals(valor)) {
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(valor);

                this.mViewHolder.valorDolar.setText(String.format("%.2f", real/4));
                this.mViewHolder.valorEuro.setText(String.format("%.2f", real/5));
            }
        }
    }

    private void limparValores() {
        this.mViewHolder.valorDolar.setText("");
        this.mViewHolder.valorEuro.setText("");
    }

    private static class ViewHolder {
        EditText editValor;
        TextView valorDolar;
        TextView valorEuro;
        Button buttonCalcular;
    }
}
