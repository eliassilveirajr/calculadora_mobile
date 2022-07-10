package ads.prog_mobile.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numero_zero, numero_um, numero_dois, numero_tres, numero_quatro, numero_cinco, numero_seis, numero_sete, numero_oito, numero_nove, ponto, somar, subtrair, multiplicar, dividir, resultado, apagar;

    private TextView tv_expressao, tv_resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        numero_zero.setOnClickListener(this);
        numero_um.setOnClickListener(this);
        numero_dois.setOnClickListener(this);
        numero_tres.setOnClickListener(this);
        numero_quatro.setOnClickListener(this);
        numero_cinco.setOnClickListener(this);
        numero_seis.setOnClickListener(this);
        numero_sete.setOnClickListener(this);
        numero_oito.setOnClickListener(this);
        numero_nove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        dividir.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        subtrair.setOnClickListener(this);
        somar.setOnClickListener(this);
    }

    private void iniciarComponentes(){
        numero_zero = findViewById(R.id.btn_zero);
        numero_um = findViewById(R.id.btn_um);
        numero_dois = findViewById(R.id.btn_dois);
        numero_tres = findViewById(R.id.btn_tres);
        numero_quatro = findViewById(R.id.btn_quatro);
        numero_cinco = findViewById(R.id.btn_cinco);
        numero_seis = findViewById(R.id.btn_seis);
        numero_sete = findViewById(R.id.btn_sete);
        numero_oito = findViewById(R.id.btn_oito);
        numero_nove = findViewById(R.id.btn_nove);
        ponto = findViewById(R.id.btn_ponto);
        apagar = findViewById(R.id.btn_apagar);
        dividir = findViewById(R.id.btn_dividr);
        multiplicar = findViewById(R.id.btn_multiplicar);
        subtrair = findViewById(R.id.btn_subtrair);
        somar = findViewById(R.id.btn_somar);
        tv_expressao = findViewById(R.id.txt_expressao);
        tv_resultado = findViewById(R.id.txt_resultado);
    }

    public void adicionarExpressao(String string, boolean limpar_dados){
        if (tv_resultado.getText().equals("")){
            tv_expressao.setText("");
        }
        if(limpar_dados){
            tv_resultado.setText("");
            tv_expressao.append(string);
        }else{
            tv_expressao.append(resultado.getText());
            tv_expressao.append(string);
            tv_resultado.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_zero:
                adicionarExpressao("0", true);
                break;
            case R.id.btn_um:
                adicionarExpressao("1", true);
                break;
            case R.id.btn_dois:
                adicionarExpressao("2", true);
                break;
            case R.id.btn_tres:
                adicionarExpressao("3", true);
                break;
            case R.id.btn_quatro:
                adicionarExpressao("4", true);
                break;
            case R.id.btn_cinco:
                adicionarExpressao("5", true);
                break;
            case R.id.btn_seis:
                adicionarExpressao("6", true);
                break;
            case R.id.btn_sete:
                adicionarExpressao("7", true);
                break;
            case R.id.btn_oito:
                adicionarExpressao("8", true);
                break;
            case R.id.btn_nove:
                adicionarExpressao("9", true);
                break;
            case R.id.btn_ponto:
                adicionarExpressao(".", true);
                break;
            case R.id.btn_dividr:
                adicionarExpressao("/", false);
                break;
            case R.id.btn_multiplicar:
                adicionarExpressao("*", false);
                break;
            case R.id.btn_subtrair:
                adicionarExpressao("-", false);
                break;
        }
    }
}