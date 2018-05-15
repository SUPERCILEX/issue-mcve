package com.supercilex.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.ktx.OneTimeWorkRequestBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener { schedule() }
    }

    private fun schedule() {
        WorkManager.getInstance().apply {
            for (i in 0..50) {
                beginUniqueWork(
                        i.toString(),
                        ExistingWorkPolicy.KEEP,
                        OneTimeWorkRequestBuilder<MyWorker>()
                                .setConstraints(
                                        Constraints.Builder()
                                                .setRequiredNetworkType(NetworkType.CONNECTED)
                                                .build())
                                .addTag("my-important-work")
                                .build()
                ).enqueue()
            }
        }
    }

    class MyWorker : Worker() {
        override fun doWork(): WorkerResult {
            Thread.sleep(5000)
            return WorkerResult.SUCCESS
        }
    }
}
