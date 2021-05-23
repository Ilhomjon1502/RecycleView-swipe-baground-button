package com.ilhomjon.h54smsandphonecontact

import Adapters.MyAdapter
import Helper.MyButton
import Helper.MySwipeHelper
import Listener.MyButtonClickListener
import Model.Item
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : MyAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_toast.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler_toast.layoutManager = layoutManager

        //add swipe
        val swipe = object : MySwipeHelper(this, recycler_toast, 200){
            override fun instantiateMyButton(
                viewHolder: RecyclerView.ViewHolder,
                buffer: MutableList<MyButton>
            ) {
                //add button
                buffer.add(
                    MyButton(this@MainActivity,
                        "delete",
                        30,
                        0,
                        Color.parseColor("#FF3C30"),
                        object : MyButtonClickListener {
                            override fun onClick(position: Int) {
                                Toast.makeText(this@MainActivity, "Delete id $position", Toast.LENGTH_SHORT).show()
                            }
                        })
                )
                buffer.add(
                    MyButton(this@MainActivity,
                        "Update",
                        30,
                        R.drawable.ic_edit,
                        Color.parseColor("#FFAB00"),
                        object : MyButtonClickListener {
                            override fun onClick(position: Int) {
                                Toast.makeText(this@MainActivity, "Update id $position", Toast.LENGTH_SHORT).show()
                            }
                        })
                )
            }

        }


        generetItem()
    }

    private fun generetItem() {
        var itemList = ArrayList<Item>()
        for (i in 0..10)
        itemList.add(Item("Ilhomjon $i"))

        adapter = MyAdapter(this, itemList)
        recycler_toast.adapter = adapter
    }
}