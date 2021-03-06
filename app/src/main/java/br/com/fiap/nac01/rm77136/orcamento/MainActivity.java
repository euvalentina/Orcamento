package br.com.fiap.nac01.rm77136.orcamento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    TextView txtResultado;
    CheckBox frete;
    RadioGroup grupoMaterial;
    EditText metros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        frete = (CheckBox) findViewById(R.id.frete);
        grupoMaterial = (RadioGroup) findViewById(R.id.grupoMaterial);
        metros = (EditText) findViewById(R.id.metros);
    }

    public void Calcular(View view) {
        double valor = 0;
        int selected = grupoMaterial.getCheckedRadioButtonId();
        switch (selected){
            case R.id.pisoBranco:
                valor = 24.9;
                txtResultado.setText(String.valueOf(valor));
                break;
            case R.id.pisoAlbania:
                valor = 11.9;
                txtResultado.setText(String.valueOf(valor));
                break;
            case R.id.pisoPorcelanato:
                valor = 39.9;
                txtResultado.setText(String.valueOf(valor));
                break;
            case R.id.pisoMosaico:
                valor = 16.9;
                txtResultado.setText(String.valueOf(valor));
                break;
            default:
                Toast.makeText(this, R.string.informe3, Toast.LENGTH_SHORT).show();
        }




        int m = Integer.parseInt(metros.getText().toString());
        valor = valor*(m^2);

        if (metros.equals("")){
            Toast.makeText(this, R.string.informe4, Toast.LENGTH_SHORT).show();
        }
        txtResultado.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(valor)));

        if (frete.isChecked()){
            valor = valor*1.3;
            txtResultado.setText(String.valueOf(NumberFormat.getCurrencyInstance().format(valor)));
        }

    }
}
