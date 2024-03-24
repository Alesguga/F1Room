package net.azarquiel.recandroid1ev.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import net.azarquiel.recandroid1ev.R
import net.azarquiel.recandroid1ev.model.DriverWithTeam

/**
 * Created by pacopulido
 */
class AdapterDriver(val context: Context,
                    val layout: Int
) : RecyclerView.Adapter<AdapterDriver.ViewHolder>() {

    private var dataList: List<DriverWithTeam> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    internal fun setDriverWithTeam(driverWithTeam: List<DriverWithTeam>) {
        this.dataList = driverWithTeam
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: DriverWithTeam){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val ivrowteams = itemView.findViewById(R.id.ivrowteams) as ImageView
            val tvrowteams = itemView.findViewById(R.id.tvrowteams) as TextView


            tvrowteams.text = dataItem.team.nombre



            // foto de internet a traves de Picasso
            Picasso.get().load(dataItem.team.imagen).into(ivrowteams)

            itemView.tag = dataItem

        }

    }
}