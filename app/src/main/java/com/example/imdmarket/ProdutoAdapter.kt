package com.example.imdmarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para a RecyclerView
class ProdutoAdapter(private val produtos: List<ProdutoItem>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    // Criação do ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false) // Inflando o layout do item
        return ProdutoViewHolder(view)
    }

    // Vinculação dos dados ao ViewHolder
    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = produtos[position]
        holder.textViewTitulo.text = produto.titulo  // Acessando a propriedade titulo
        holder.textViewSubtitulo.text = produto.subtitulo  // Acessando a propriedade subtitulo
        holder.textViewDescricao.text = produto.descricao // Acessando e exibindo a descrição do produto
    }

    // Número de itens da lista
    override fun getItemCount(): Int = produtos.size

    // ViewHolder
    class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitulo: TextView = itemView.findViewById(R.id.textViewTitulo)
        val textViewSubtitulo: TextView = itemView.findViewById(R.id.textViewSubtitulo)
        val textViewDescricao: TextView = itemView.findViewById(R.id.textViewDescricao) // Referência ao textViewDescricao
    }
}
