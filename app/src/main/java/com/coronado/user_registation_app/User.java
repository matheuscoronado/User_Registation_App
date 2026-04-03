package com.coronado.user_registation_app;

// Importa anotações do Room necessários para mapear esta classe como uma entidade do banco de dados
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    // Define o campo 'id' como chave primaria da tabela e configura para ser gerada automaticamente
    @PrimaryKey(autoGenerate = true)
    private int id;

    // Campos que representam as colunas da tabela para armazenar od dados do usuário
    private String name; // Nome do usuário
    private String cpf; // CPF do usuário
    private String email;  // Email do usuário
    private String phone; // Fone do usuário
}
