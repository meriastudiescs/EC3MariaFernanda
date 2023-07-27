package com.example.evaluacioncontinua03.ui.fragments

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.evaluacioncontinua03.databinding.ItemFactBinding
import com.example.evaluacioncontinua03.model.Fact

/*private val notes*/
class RVFactListAdapter(var facts : List<Fact>) : RecyclerView.Adapter<FactVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactVH {
        val binding = ItemFactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FactVH(binding)
    }

    override fun getItemCount(): Int = facts.size

    override fun onBindViewHolder(holder: FactVH, position: Int) {
        holder.bind(facts[position])
    }
}

class FactVH(private val binding : ItemFactBinding) : ViewHolder(binding.root) {
    fun bind(fact: Fact) {
        binding.txtFactTitle.text = fact.title
        binding.txtContentFact.text = fact.content
        val labelString = fact.labels.joinToString( " | " )
        binding.txtLablesFact.text = labelString
        binding.txtCreatedonFact.text = fact.createdOn
        binding.cvItemFact.setCardBackgroundColor(ColorStateList.valueOf(fact.getColor()))
    }
}