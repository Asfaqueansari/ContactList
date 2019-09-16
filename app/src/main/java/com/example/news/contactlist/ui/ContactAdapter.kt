package com.example.news.contactlist.ui

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.news.contactlist.NavigateActivity
import com.example.news.contactlist.R
import kotlinx.android.synthetic.main.activity_navigate.view.*
import kotlinx.android.synthetic.main.layout_contact_list.view.*


class ContactAdapter(items : List<Contact>,ctx: Context): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
             private  var list:List<Contact> = items
             private var context:Context=ctx

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.name.text=list[position].name
        holder.number.text=list[position].number
        if(list[position].image!=null)
            holder.profile.setImageBitmap(list[position].image)
        else
            holder.profile.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_person_black_24dp))

        holder.click.setOnClickListener{
            NavigateActivity.start(context)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        return ContactAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_contact_list, parent, false))
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v){
        val name=v.txtName!!
        val number=v.txtNumber!!
        val profile=v.imageView!!
        val click = v.imageNavigate
}

}