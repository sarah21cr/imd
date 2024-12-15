package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_principal)

        // Ajustar o padding do layout principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configuração dos botões
        val buttonCadastro = findViewById<Button>(R.id.buttonCadastro)
        val buttonAlteracao = findViewById<Button>(R.id.buttonAlteracao)
        val buttonDeletarProduto = findViewById<Button>(R.id.buttonDeletarProduto)
        val buttonListagem = findViewById<Button>(R.id.buttonListagem)

        buttonCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroProdutoActivity::class.java))
        }


        buttonDeletarProduto.setOnClickListener {
            startActivity(Intent(this, DeletarProdutoActivity::class.java))
        }

        buttonListagem.setOnClickListener {
            startActivity(Intent(this, ListarProdutosActivity::class.java))
        }
    }
}
