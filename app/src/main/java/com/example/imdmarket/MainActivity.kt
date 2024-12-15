package com.example.imdmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val produtos = listOf(
                ProdutoItem("12345", "Produto 1", "Subtítulo do Produto 1", "Descrição do Produto 1"),
                ProdutoItem("12346", "Produto 2", "Subtítulo do Produto 2", "Descrição do Produto 2"),
                ProdutoItem("12347", "Produto 3", "Subtítulo do Produto 3", "Descrição do Produto 3"),
                ProdutoItem("12348", "Produto 4", "Subtítulo do Produto 4", "Descrição do Produto 4"),
                ProdutoItem("12349", "Produto 5", "Subtítulo do Produto 5", "Descrição do Produto 5")
            )
            val recyclerView: RecyclerView = findViewById(R.id.recyclerViewProdutos)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ProdutoAdapter(produtos) // Passando a lista de produtos para o adaptador
        }
    }
}
