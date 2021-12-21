package com.kotlinexample.covid19casesapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kotlinexample.covid19casesapp.adapter.CovidCasesAdapter
import com.kotlinexample.covid19casesapp.di.App
import com.kotlinexample.covid19casesapp.mvp.contract.CovidCasesContract
import com.kotlinexample.covid19casesapp.R
import com.kotlinexample.covid19casesapp.adapter.BaseAdapter
import com.kotlinexample.covid19casesapp.mvp.contract.presenter.CovidCasesPresenter

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CovidCasesListFragment : BaseListFragment(), CovidCasesContract.View {
    @Inject
    lateinit var presenter: CovidCasesPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cases_list, container, false)
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
        requireActivity().progressBar.visibility = View.VISIBLE

    }

    override fun hideProgress() {
        requireActivity().progressBar.visibility = View.INVISIBLE
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
}