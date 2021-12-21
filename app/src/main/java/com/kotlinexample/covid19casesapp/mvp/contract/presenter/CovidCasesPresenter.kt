package com.kotlinexample.covid19casesapp.mvp.contract.presenter

import com.kotlinexample.covid19casesapp.di.App
import com.kotlinexample.covid19casesapp.rest.FinnhubApi
import com.kotlinexample.covid19casesapp.adapter.CovidCasesAdapter
import com.kotlinexample.covid19casesapp.mvp.contract.CovidCasesContract
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CovidCasesPresenter : CovidCasesContract.Presenter() {
    @Inject
    lateinit var finnhubApi: FinnhubApi

    init {
        App.appComponent.inject(this)
    }

    override fun makeList() {
        view.showProgress()
        subscribe(finnhubApi.getCovidCases()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { Observable.fromIterable(it) }
            .doOnNext {
                view.addCovidCase(
                    CovidCasesAdapter.Finnhub(
                        it.state,
                        it.case,
                        it.death,
                        it.updated
                    )
                )
            }
            .doOnComplete {
                view.hideProgress()
            }
            .subscribe({
                view.hideProgress()
                view.notifyAdapter()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }

    override fun refreshList() {
        view.refresh()
        makeList()
    }
}