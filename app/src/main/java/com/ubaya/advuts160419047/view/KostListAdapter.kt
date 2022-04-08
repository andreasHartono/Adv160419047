package com.ubaya.advuts160419047.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.advuts160419047.R
import com.ubaya.advuts160419047.model.Kost
import com.ubaya.advuts160419047.util.loadImage
import kotlinx.android.synthetic.main.kost_list_item.view.*

class KostListAdapter(val kostList:ArrayList<Kost>) : RecyclerView
.Adapter<KostListAdapter.KostListViewHolder>() {
    class KostListViewHolder(var view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KostListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.kost_list_item, parent, false)
        return KostListViewHolder(view)
    }

    override fun onBindViewHolder(holder: KostListViewHolder, position: Int) {
        val kost = kostList[position]
        with(holder.view) {
            textNama.text = kost.name
            textAlamat.text = kost.alamat
            btnDetail.setOnClickListener {
                val action = kost.id?.let {
                    id -> MainFragmentDirections.mainkostdetailkost(id.toInt())
                }
                //val action = DetailKostFragmentDirections.detailkostmainkost()
                if(action != null) {
                    Navigation.findNavController(it).navigate(action)
                }
            }
            imageKost.loadImage(kost.photoUrl, progressLoadKostFoto)
        }
    }

    override fun getItemCount() = kostList.size

    fun updateKostList(newKostList: ArrayList<Kost>) {
        kostList.clear()
        kostList.addAll(newKostList)
        notifyDataSetChanged()
    }
}