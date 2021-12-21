package com.kotlinexample.covid19casesapp.mvp.contract

import com.kotlinexample.covid19casesapp.adapter.CovidCasesAdapter

class CovidCasesContract {
    interface View : BaseContract.View {
        fun addCovidCase(covidCase: CovidCasesAdapter.Finnhub)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter : BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}