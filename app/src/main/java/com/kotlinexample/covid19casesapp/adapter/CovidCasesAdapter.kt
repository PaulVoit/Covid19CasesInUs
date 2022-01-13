package com.kotlinexample.covid19casesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlinexample.covid19casesapp.databinding.RecyclerViewItemBinding


class CovidCasesAdapter : BaseAdapter<CovidCasesAdapter.CovidCasesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidCasesViewHolder {
        val binding =
            RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CovidCasesViewHolder(binding)
    }

    class CovidCasesViewHolder(viewBinding: RecyclerViewItemBinding) : BaseViewHolder(viewBinding) {
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
                viewBinding.tvCurrentState.text = item.state
                viewBinding.tvCurrentCases.text = item.case.toString()
                viewBinding.tvCurrentDeath.text = item.death.toString()
                viewBinding.tvDateOfUpdate.text = item.updated
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
