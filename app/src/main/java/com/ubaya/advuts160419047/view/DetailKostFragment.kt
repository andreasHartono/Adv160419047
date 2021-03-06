package com.ubaya.advuts160419047.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.advuts160419047.R
import com.ubaya.advuts160419047.util.loadImage
import com.ubaya.advuts160419047.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_kost.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.kost_list_item.*

/**
 * A simple [Fragment] subclass.
 * Use the [DetailKostFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailKostFragment : Fragment() {
    private lateinit var viewModel : DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val getId = DetailKostFragmentArgs.fromBundle(requireArguments()).kostID
            viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            viewModel.fetch(getId)

            observeViewModel()
        }

    }

    private fun observeViewModel() {
        viewModel.kostLiveData.observe(viewLifecycleOwner) {
            val kost = it
            Log.d("cobares",kost.toString())
            kost?.let {
                textDetailNama.text = it[0].name
                textDetailAlamat.text = "Alamat: " +it[0].alamat
                textFasilitas.text = "Fasilitas: " + it[0].fasilitas
                textDetailHarga.text = "Harga: Rp." + it[0].harga.toString()
                imageDetailKost.loadImage(it[0].photoUrl, progressLoadDetailKost)
            }
        }
    }


}