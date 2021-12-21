package com.kotlinexample.covid19casesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlinexample.covid19casesapp.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*


class CovidCasesAdapter : BaseAdapter<CovidCasesAdapter.CovidCasesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidCasesViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CovidCasesViewHolder(v)
    }

    class CovidCasesViewHolder(view: View) : BaseViewHolder(view) {
        var state: String = ""
        var case: Int = 0
        var death: Int = 0
        var dateOfUpdate: String = ""


        init {
            itemView.setOnClickListener {

            }
        }

        override fun bind(item: Any) {
            let {
                item as Finnhub
                view.tvCurrentState.text = item.state
                view.tvCurrentCases.text = item.case.toString()
                view.tvCurrentDeath.text = item.death.toString()
                view.tvDateOfUpdate.text = item.updated
                state = item.state
                case = item.case
                death = item.death
                dateOfUpdate = item.updated
            }
        }
    }

    data class Finnhub(
        val state: String,
        val case: Int,
        val death: Int,
        val updated: String
    )
}
