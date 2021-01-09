package com.supercilex.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.supercilex.test.databinding.ButtonFragmentBinding

class ButtonFragment : Fragment(R.layout.button_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = ButtonFragmentBinding.bind(view)

        binding.list.adapter = TimerAdapter()
        binding.list.scrollToPosition(10_000)
    }
}
