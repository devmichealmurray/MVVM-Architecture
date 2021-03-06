package com.devmmurray.mvvm_architecture.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devmmurray.mvvm_architecture.R
import com.devmmurray.mvvm_architecture.data.model.User
import kotlinx.android.synthetic.main.item_layout.view.*

class DataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(user: User) {
        itemView.textViewUserName.text = user.name
        itemView.textViewUserEmail.text = user.email
        Glide.with(itemView.imageViewAvatar.context)
            .load(user.avatar)
            .into(itemView.imageViewAvatar)
    }
}

class MainAdapter(private val users: ArrayList<User>): RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout, parent, false))


    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun addData(list: List<User>) {
        users.addAll(list)
    }
}