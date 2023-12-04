package com.bold.recyclerview_activity_assignment

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(
    private var contacts: ArrayList<Contact>
):RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    interface OnContactClickListener {
        fun onMessageClick(position : Int, contacts : Contact, view : View)
    }

    inner class ContactHolder(view: View):RecyclerView.ViewHolder(view){
        var image:ImageView
        var username:TextView
        var usernumber:TextView
        var userEmail:TextView


        init {
            image=view.findViewById(R.id.image)
            username=view.findViewById(R.id.username)
            usernumber=view.findViewById(R.id.usernumber)
            userEmail=view.findViewById(R.id.useremail)



        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contact_main_activity, null)
        return ContactHolder(view)
    }

    override fun getItemCount()=contacts.size


    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.image.setImageResource(contacts[position].image)
        holder.username.text=contacts[position].name
        holder.usernumber.text=contacts[position].number
        holder.userEmail.text=contacts[position].email

    }
}