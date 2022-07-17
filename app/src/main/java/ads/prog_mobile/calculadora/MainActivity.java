package ads.prog_mobile.calculadora;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import ads.prog_mobile.calculadora.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numero_zero, numero_um, numero_dois, numero_tres, numero_quatro, numero_cinco,
            numero_seis, numero_sete, numero_oito, numero_nove, parentese_esquerdo, parentese_direito,
            ponto, somar, subtrair, multiplicar, dividir, igual, apagar;

    private TextView tv_expressao, tv_expressao_visual, tv_resultado;


    float x1, x2, y1, y2;

    @Override
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1<x2){
                    Intent i = new Intent(MainActivity.this, HistoricoActivity.class);
                    startActivity(i);
                }else if(x1>x2){
                    Intent i = new Intent(MainActivity.this, HistoricoActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

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
        parentese_esquerdo.setOnClickListener(this);
        parentese_direito.setOnClickListener(this);
        ponto.setOnClickListener(this);
        dividir.setOnClickListener(this);
        multiplicar.setOnClickListener(this);
        subtrair.setOnClickListener(this);
        somar.setOnClickListener(this);

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }
                tv_resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(tv_expressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;


                    //DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
                    Historico h = new Historico();

                    if (resultado == (double)longResult){
                        tv_resultado.setText((CharSequence) String.valueOf(longResult));
                        h.setOperacao(tv_expressao.getText().toString());
                        h.setResultado(tv_resultado.getText().toString());
                        //databaseHelper.createHistorico(h);
                    }else{
                        tv_resultado.setText((CharSequence) String.valueOf(resultado));
                        h.setOperacao(tv_expressao.getText().toString());
                        h.setResultado(tv_resultado.getText().toString());
                        //databaseHelper.createHistorico(h);
                    }
                }catch (Exception e){
                    tv_resultado.setText("Operação");
                    tv_expressao.setText("inválida");

                }

            }
        });
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
        parentese_esquerdo = findViewById(R.id.btn_parentese_esquerdo);
        parentese_direito = findViewById(R.id.btn_parentese_direito);
        ponto = findViewById(R.id.btn_ponto);
        apagar = findViewById(R.id.btn_apagar);
        dividir = findViewById(R.id.btn_dividr);
        multiplicar = findViewById(R.id.btn_multiplicar);
        subtrair = findViewById(R.id.btn_subtrair);
        somar = findViewById(R.id.btn_somar);
        igual = findViewById(R.id.btn_resultado);
        tv_expressao = findViewById(R.id.txt_expressao);
        tv_resultado = findViewById(R.id.txt_resultado);
    }

    public void adicionarExpressao(String string, boolean limpar_dados){

        if (tv_resultado.getText().equals("")){
            tv_expressao.setText(" ");
        }
        if(limpar_dados){
            tv_resultado.setText(" ");
            tv_expressao.append(string);
        }else{
            tv_expressao.append(tv_resultado.getText());
            tv_expressao.append(string);
            tv_resultado.setText(" ");
        }
    }

    public void limparExpressao(){

        if (tv_resultado.getText() != " "){
            tv_expressao.setText("");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_zero:
                limparExpressao();
                adicionarExpressao("0", true);
                break;
            case R.id.btn_um:
                limparExpressao();
                adicionarExpressao("1", true);
                break;
            case R.id.btn_dois:
                limparExpressao();
                adicionarExpressao("2", true);
                break;
            case R.id.btn_tres:
                limparExpressao();
                adicionarExpressao("3", true);
                break;
            case R.id.btn_quatro:
                limparExpressao();
                adicionarExpressao("4", true);
                break;
            case R.id.btn_cinco:
                limparExpressao();
                adicionarExpressao("5", true);
                break;
            case R.id.btn_seis:
                limparExpressao();
                adicionarExpressao("6", true);
                break;
            case R.id.btn_sete:
                limparExpressao();
                adicionarExpressao("7", true);
                break;
            case R.id.btn_oito:
                limparExpressao();
                adicionarExpressao("8", true);
                break;
            case R.id.btn_nove:
                limparExpressao();
                adicionarExpressao("9", true);
                break;
            case R.id.btn_parentese_esquerdo:
                limparExpressao();
                adicionarExpressao("(", true);
                break;
            case R.id.btn_parentese_direito:
                limparExpressao();
                adicionarExpressao(")", true);
                break;
            case R.id.btn_ponto:
                limparExpressao();
                adicionarExpressao(".", true);
                break;
            case R.id.btn_dividr:
                limparExpressao();
                adicionarExpressao("/", false);
                break;
            case R.id.btn_multiplicar:
                limparExpressao();
                adicionarExpressao("*", false);
                break;
            case R.id.btn_subtrair:
                limparExpressao();
                adicionarExpressao("-", false);
                break;
            case R.id.btn_somar:
                limparExpressao();
                adicionarExpressao("+", false);
                break;
        }
    }
}