package Adapters

import Model.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ilhomjon.h54smsandphonecontact.R

class MyAdapter(internal var context: Context, internal var itemList:MutableList<Item>)
    :RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        Glide.with(context).load(itemList[position].image).into(holder.image)
        holder.txt_name.text = itemList[position].name
    }

    override fun getItemCount(): Int = itemList.size
}