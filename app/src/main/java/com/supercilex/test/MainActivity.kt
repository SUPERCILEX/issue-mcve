package com.supercilex.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore
import org.jetbrains.anko.find
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseFirestore.setLoggingEnabled(true)
        val root = FirebaseFirestore.getInstance().collection("test")

        root.firestore.batch().apply {
            set(root.document(), mapOf("owners" to mapOf("a" to Date())))
            set(root.document(), mapOf("owners" to mapOf("b" to Date())))
            set(root.document(), mapOf("owners" to mapOf("c" to Date())))
            commit()
        }

        root.orderBy("uid").addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.e("TAG", "Error fetching documents", e)
                return@addSnapshotListener
            }

            find<TextView>(R.id.text).text = snapshot.map { it.data }.joinToString()
        }
    }
}
