package com.example.legends

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.legends.databinding.ItemListLegendBinding

class AdapterLegends(private val iconList:List<IconsL>, val onClick :(icon:IconsL)->Unit  ):RecyclerView.Adapter<AdapterLegends.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemListLegendBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()=iconList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(iconList[position])
    }
    inner class Holder(private val binding:ItemListLegendBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(icon:IconsL){
         binding.apply {
             icon.apply {
                 tvlive.text=live
                 tvname.text=name
                 Glide.with(ivphoto).load(photo).into(ivphoto)
             }
         }
           itemView.setOnClickListener {
               onClick(icon)
           }

       }

    }
}