package com.supercilex.test

import android.text.format.DateUtils
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.supercilex.test.databinding.TimerItemBinding
import java.lang.ref.WeakReference

class TimerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = TimerItemBinding.bind(itemView)
    private val tick = Tick(binding.timer)

    init {
        binding.timer.postDelayed(tick, 1000)
    }

    fun bind(timer: Timer) {
        tick.timer = timer

        binding.timer.text = convertToString(System.currentTimeMillis() - timer.startTime)
    }

    private class Tick(timerView: TextView) : Runnable {
        var timer: Timer? = null

        private val timerViewRef = WeakReference(timerView)

        override fun run() {
            val view = timerViewRef.get() ?: return
            val timer = timer

            if (timer != null) {
                view.text = convertToString(System.currentTimeMillis() - timer.startTime)
            }
            view.postDelayed(this, 100)
        }
    }

    private companion object {
        private fun convertToString(timeInMillis: Long): String {
            return DateUtils.formatElapsedTime(timeInMillis / 1000)
        }
    }
}
