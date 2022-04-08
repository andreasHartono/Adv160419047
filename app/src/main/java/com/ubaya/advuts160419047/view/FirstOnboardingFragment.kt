package com.ubaya.advuts160419047.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.ubaya.advuts160419047.R
import kotlinx.android.synthetic.main.fragment_first_onboarding.view.*
import kotlinx.android.synthetic.main.fragment_onboarding.*

/**
 * A simple [Fragment] subclass.
 * Use the [FirstOnboardingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstOnboardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_first_onboarding, container, false)

        val vpager = activity?.findViewById<ViewPager2>(R.id.viewPagerOnboarding)
        v.buttonNext.setOnClickListener {
            vpager?.currentItem = 1
        }
        return v
    }
}