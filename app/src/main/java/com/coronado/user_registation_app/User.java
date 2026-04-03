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

    // Construtor da classe que será usado para criar novo objeto
    public User(String name, String cpf, String email, String phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    // Metodos getter e setter para acessar e modificar os dados do objeto User
    public int getId(){return id;}

    // Define o ID do usuário (usado pelo Room para preencher automaticamente)
    public void setId(int id) {this.id = id;}


    // Retorna o nome do usuário
    public String getName(){return name;}

    // Retorna o cpf do usuário
    public String getCpf(){return cpf;}

    // Retorna o email do usuário
    public String getEmail(){return email;}

    // Retorna o fone do usuário
    public String getPhone(){return phone;}

}
