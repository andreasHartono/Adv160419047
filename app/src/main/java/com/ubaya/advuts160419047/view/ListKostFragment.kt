package com.ubaya.advuts160419047.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.advuts160419047.R

/**
 * A simple [Fragment] subclass.
 * Use the [ListKostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListKostFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_kost, container, false)
    }
}