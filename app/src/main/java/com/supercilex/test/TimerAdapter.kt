package com.supercilex.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TimerAdapter : RecyclerView.Adapter<TimerViewHolder>() {
    private val timers = mutableMapOf<Int, Timer>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            TimerViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.timer_item, parent, false))

    override fun onBindViewHolder(holder: TimerViewHolder, position: Int) {
        val timer = timers.getOrPut(position) { Timer(System.currentTimeMillis()) }
        holder.bind(timer)
    }

    override fun getItemCount() = Int.MAX_VALUE
}
