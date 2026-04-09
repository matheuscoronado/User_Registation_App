package com.coronado.user_registation_app;

//Importações de componentes de UI, intenções e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class ReportActivity extends AppCompatActivity {
    //Campo de texto onde os dados do banco serão exibidos
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        // Define o layout XML dessa tela de relatorio
        setContentView(R.layout.activity_report);
        // Mapeamento do TextView do XML para o java
        textViewReport = findViewById(R.id.textViewReport);
        // Encontra o botão e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        // O botão de retorno utilizando expressão lambda
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());
    }

    // Metodo responsavel pela navegação entre as telas do app
    public void voltarParaCadastro(){
        // Inteção para abrir tela de cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Fecha a tela de relatorio para não acumular na pilha de tarefa
    }
}
