package com.coronado.user_registation_app;

//Importações de componentes de UI, intenções e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;


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

        /*
            Conexão com o banco de dados
            1 - Cria uma instância do banco "user-database"
            2 - .allowMainThreadQueries():  Serve para liberar gerações de consulta feitas em
            threads da UI. Por padrão , ROOM proibe isso, o correto seria fazer consultas em
            threads separadas.
         */
        UserDatabase db = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user-database").allowMainThreadQueries().builder();
        // Obtém o objeto DAO ( Data Access Objects) que contém as queries SQL
        UserDao userDao = db.userDao();
        // Recupera todos os usuários salvos no BD e armazena em uma lista
        List<User> userList = userDao.getAllUsers();
        // StringBuilder: forma eficiente de contruir uma String longa dentro de um laço (loop)
        StringBuilder report = new StringBuilder();
        // Loop "for-each" para percorrer cada objeto User dentro da lista recuperada
        for (User user : userList){
            report.append("Nome: ").append(user.getName()).append("\n").append("CPF: ").append(user.getCpf()).append("\n\n");
        }
        // Exibe o relatorio final montado no TextView na tela
        textViewReport.setText(report.toString());
    }

    // Metodo responsavel pela navegação entre as telas do app
    public void voltarParaCadastro(){
        // Inteção para abrir tela de cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Fecha a tela de relatorio para não acumular na pilha de tarefa
    }
}
