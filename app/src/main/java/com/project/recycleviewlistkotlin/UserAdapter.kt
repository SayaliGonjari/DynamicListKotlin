package com.project.recycleviewlistkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.lang.StringBuilder

class UserAdapter(var users: List<Model>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater =
            LayoutInflater.from(p0.context).inflate(R.layout.activity_row, p0, false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {

        holder.name.text = users[pos].name
        holder.email.text = users[pos].emailId
        holder.phoneNo.text = users[pos].phone
        var address: String
        address =
            users[pos].address.street + "," + users[pos].address.suite + "," + users[pos].address.city
        holder.address.text = address

    }

    override fun getItemCount() = users.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val email: TextView = itemView.findViewById(R.id.email)
        val phoneNo: TextView = itemView.findViewById(R.id.phooneNo)
        val address: TextView = itemView.findViewById(R.id.address)

    }


}
