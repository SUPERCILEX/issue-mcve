package com.supercilex.test

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import org.jetbrains.anko.find
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findbugs()

        FirebaseFirestore.setLoggingEnabled(true)
        val root = FirebaseFirestore.getInstance().collection("test")

        root.firestore.batch().apply {
            set(root.document(), mapOf("owners" to mapOf("a" to Date())))
            set(root.document(), mapOf("owners" to mapOf("b" to Date())))
            set(root.document(), mapOf("owners" to mapOf("c" to Date())))
            commit()
        }

        //////////////// INSTRUCTIONS ////////////////
        // 1. Open app
        // 2. Go offline and look for StrictMode logs
        // 3. If you don't see anything, press the button somewhere along

        query(root)
        find<Button>(R.id.button).setOnClickListener { query(root) }
    }

    private fun query(root: CollectionReference) {
        root.orderBy("uid").addSnapshotListener { _, e ->
            if (e != null) {
                Log.e("TAG", "Error fetching documents", e)
                return@addSnapshotListener
            }
        }
    }

    private fun findbugs() {
        if (BuildConfig.DEBUG) {
            val vmBuilder = StrictMode.VmPolicy.Builder()
                    .detectActivityLeaks()
                    .detectLeakedClosableObjects()
                    .detectLeakedRegistrationObjects()
                    .detectLeakedSqlLiteObjects()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                vmBuilder.detectCleartextNetwork()
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vmBuilder.detectContentUriWithoutPermission()
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                vmBuilder.detectFileUriExposure()
            }
            StrictMode.setVmPolicy(vmBuilder.penaltyLog().build())

            StrictMode.setThreadPolicy(
                    StrictMode.ThreadPolicy.Builder()
                            .detectAll()
                            .penaltyDeath()
                            .penaltyLog()
                            .build()
            )
        }
    }
}
