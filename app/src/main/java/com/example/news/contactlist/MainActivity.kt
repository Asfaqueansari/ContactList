package com.example.news.contactlist

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news.contactlist.ui.Contact
import com.example.news.contactlist.ui.ContactAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

            val contactList: MutableList<Contact> = ArrayList()
            val contacts = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null)
            while (contacts!!.moveToNext()) {
                val name =
                    contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number =
                    contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                val obj = Contact()
                obj.name = name
                obj.number = number
                val photo_uri =
                    contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))
                if (photo_uri != null) {
                    obj.image =
                        MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(photo_uri))
                }
                contactList.add(obj)
            }
            recyclerView.adapter = ContactAdapter(contactList, this)
            contacts.close()
        }

}