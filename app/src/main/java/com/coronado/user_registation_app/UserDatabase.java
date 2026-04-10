package com.coronado.user_registation_app;

// Importa as anotações e classes da biblioteca Room e do Android
import android.content.Context; // Classe que representa o contexto da aplicação (necessário para acessar recursos)

import androidx.room.Database; // Anotação para marcar a classe como um banco de dados Room
import androidx.room.Room;
import androidx.room.RoomDatabase; // Classe base que representa o BD

/*
    Anotação @Database define que a classe representa o banco de dados Room
    Ela especifica as entidades (tabelas) que o banco irá conter e a versão do banco
*/
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    // Instância única (singleton) do BD
    private static UserDatabase instance;

    // Metodo abstrato que será implementado pelo Room
    // Serve para acessar as operações do BD definidos no UserDAO
    public abstract UserDao userDao();

    /*
    Metodo que retorna a instância do BD
    O uso do 'synchronized' garante que apenas uma thread possa acessar este metodo por vez,
    evitando que duas instâncias do BD sejam criadas acidentalmente
    */
    public static synchronized UserDatabase getInstance(Context context){
        // Vereficar se já existe uma instância de BD
        if (instance == null){
        /*
            Cria a instância do BD usuando Room

            Context - Usa o contexto da aplicação para evitar vazamento de memoria
            fallbackToDestructiveMigration - Se houver mudança de versão e não houver migração,
            o BD será recriado do zero
        */
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class, "user-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        // Retorna a instância criada
        return instance;
    }
}
