package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CadastroProdutoActivity : AppCompatActivity() {

    // Lista de produtos para exibir na RecyclerView
    private val produtos = mutableListOf<ProdutoItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_produto)

        // Configura o RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProdutos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ProdutoAdapter(produtos)
        recyclerView.adapter = adapter

        // Pegando referências dos campos de entrada e botões
        val editTextCodigoProduto = findViewById<EditText>(R.id.editTextCodigoProduto)
        val editTextNomeProduto = findViewById<EditText>(R.id.editTextNomeProduto)
        val editTextDescricaoProduto = findViewById<EditText>(R.id.editTextDescricaoProduto)
        val editTextEstoqueProduto = findViewById<EditText>(R.id.editTextEstoqueProduto)

        val buttonSalvar = findViewById<Button>(R.id.buttonSalvar)
        val buttonLimpar = findViewById<Button>(R.id.buttonLimpar)

        // Lógica para o botão "Salvar"
        buttonSalvar.setOnClickListener {
            val codigoProduto = editTextCodigoProduto.text.toString()
            val nomeProduto = editTextNomeProduto.text.toString()
            val descricaoProduto = editTextDescricaoProduto.text.toString()
            val estoqueProdutoText = editTextEstoqueProduto.text.toString()

            if (codigoProduto.isNotEmpty() && nomeProduto.isNotEmpty() && descricaoProduto.isNotEmpty() && estoqueProdutoText.isNotEmpty()) {

                val estoqueProduto = try {
                    estoqueProdutoText.toInt()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor, insira um número válido para o estoque.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Criação do ProdutoItem
                val produtoItem = ProdutoItem(
                    "1",
                    titulo = "$codigoProduto - $nomeProduto",
                    subtitulo = "Estoque: $estoqueProduto",
                    "descricaoProduto"
                )

                // Adiciona o ProdutoItem na lista
                produtos.add(produtoItem)

                // Atualiza o adaptador para mostrar a lista atualizada
                adapter.notifyDataSetChanged()

                // Exibindo mensagem de sucesso
                Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_LONG).show()

                // Limpa os campos
                editTextCodigoProduto.text.clear()
                editTextNomeProduto.text.clear()
                editTextDescricaoProduto.text.clear()
                editTextEstoqueProduto.text.clear()

            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica para o botão "Limpar"
        buttonLimpar.setOnClickListener {
            editTextCodigoProduto.text.clear()
            editTextNomeProduto.text.clear()
            editTextDescricaoProduto.text.clear()
            editTextEstoqueProduto.text.clear()
        }
    }
}
