package com.bold.recyclerview_activity_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerContact : RecyclerView
    private lateinit var contactAdapter: ContactAdapter
    private var contacts =ArrayList<Contact>()


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        recyclerContact= findViewById(R.id.recyclerView)
        initData()


        contactAdapter= ContactAdapter(contacts)
        recyclerContact.adapter=contactAdapter

        recyclerContact.layoutManager=LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)


    }
    private fun initData(){


    }
    inner class MYContactClickListener :ContactAdapter.OnContactClickListener {
        override fun onMessageClick(position: Int, contacts: Contact, view: View) {
            Toast.makeText(this@MainActivity,"add contact",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main,menu)
        val addContact  = menu?.findItem(R.id.menuInfo)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this,AddContact::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}