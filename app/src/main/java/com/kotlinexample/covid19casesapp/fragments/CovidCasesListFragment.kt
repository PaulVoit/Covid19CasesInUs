package com.kotlinexample.covid19casesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kotlinexample.covid19casesapp.adapter.BaseAdapter
import com.kotlinexample.covid19casesapp.adapter.CovidCasesAdapter
import com.kotlinexample.covid19casesapp.databinding.FragmentCasesListBinding
import com.kotlinexample.covid19casesapp.di.App
import com.kotlinexample.covid19casesapp.mvp.contract.CovidCasesContract
import com.kotlinexample.covid19casesapp.mvp.contract.presenter.CovidCasesPresenter
import javax.inject.Inject

class CovidCasesListFragment : BaseListFragment(), CovidCasesContract.View {

    private var _binding: FragmentCasesListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var presenter: CovidCasesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCasesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CovidCasesAdapter()
    }

    override fun addCovidCase(covidCase: CovidCasesAdapter.Finnhub) {
        viewAdapter.add(covidCase)
    }

    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        _binding?.progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        _binding?.progressBar?.visibility = View.INVISIBLE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}