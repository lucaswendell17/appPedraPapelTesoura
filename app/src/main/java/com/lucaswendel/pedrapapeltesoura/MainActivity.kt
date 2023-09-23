package com.lucaswendel.pedrapapeltesoura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selecionarPedra(view: View){
        verificarGanhador("pedra")
    }

    fun selecionarPapel(view: View){
        verificarGanhador("papel")
    }

    fun selecionarTesoura(view: View){
        verificarGanhador("tesoura")
    }

    fun gerarEscolhaAleatoria(): String {

        val opcoes: Array<String> = arrayOf("pedra", "papel", "tesoura")

        val numeroAleatorio : Int = Random().nextInt(3)

        val escolhaApp : String = opcoes[numeroAleatorio]

        val imagemApp : ImageView = findViewById(R.id.image_escolha_app)

        when(escolhaApp){
            "pedra" -> imagemApp.setImageResource(R.drawable.pedra)
            "papel" -> imagemApp.setImageResource(R.drawable.papel)
            "tesoura" -> imagemApp.setImageResource(R.drawable.tesoura)
        }

        return escolhaApp
    }

    fun verificarGanhador(escolhaUsuario: String){

        val escolhaApp : String = gerarEscolhaAleatoria()

        val textResultado : TextView = findViewById(R.id.text_resultado)

        if(
            (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
            (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){
            textResultado.text = "Você perdeu!"
        } else if (
            (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
            (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
            (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){
            textResultado.text = "Você ganhou! :)"
        } else {
            textResultado.text = "Empatamos!"
        }
    }

}