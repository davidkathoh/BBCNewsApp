package com.example.bbcnewsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bbcnewsapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(),NewsAdapter.OnNewsClicklistener {



    private val newsViewModel: NewsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return  inflater.inflate(R.layout.fragment_first, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = NewsAdapter(this)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        newsViewModel.quantity.observe(viewLifecycleOwner) {
            adapter.setdata(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun onClick(position: Int) {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}