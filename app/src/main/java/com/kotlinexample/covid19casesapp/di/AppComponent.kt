package com.kotlinexample.covid19casesapp.di

import com.kotlinexample.covid19casesapp.fragments.CovidCasesListFragment
import com.kotlinexample.covid19casesapp.activities.MainActivity
import com.kotlinexample.covid19casesapp.mvp.contract.presenter.CovidCasesPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule :: class, RestModule :: class, MvpModule :: class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: CovidCasesListFragment)
    fun inject(presenter: CovidCasesPresenter)
  //  fun inject(presenter: LatestChartPresenter)
   // fun inject(chart: LatestChart)
  //  fun inject(activity: ChartActivity)
}