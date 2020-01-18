package com.example.myapplication.recyclerview.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.ForecastList
import com.example.myapplication.model.ForecastResult
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastAdapter(private val myDataset: MutableList<ForecastList>)  : RecyclerView.Adapter<ForecastAdapter.MachinViewHolder>() {



    class MachinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val _label = itemView.item_machin_label
        val _desc = itemView.item_machin_desc
        val _icon = itemView.item_machin_icon
        //val _date = itemView.item_machin_date
        //val _avatar = itemView.item_machin_avatar
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ForecastAdapter.MachinViewHolder {
        // create a new view
        var itemView =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_forecast, parent, false)
                    as View
        return MachinViewHolder(itemView)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MachinViewHolder, position: Int) {
        
        val data = myDataset[position]
        
        holder._label.text = data.weather[0].main
        holder._desc.text = " ${data.main.temp.toString()} °C"

        //Glide allow us to get an icon
        Glide.with(holder._icon.context)
            .load("https://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png")
            .into(holder._icon)
    }

    override fun getItemCount() = myDataset.size
}
