package Adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    var txt_name : TextView
    init {
        txt_name = itemView.txt_item
    }
}