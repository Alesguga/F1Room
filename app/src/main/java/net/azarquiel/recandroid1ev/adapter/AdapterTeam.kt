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
 * Created by pacopulido on 9/10/18.
 */
class AdapterTeam(val context: Context,
                  val layout: Int
                    ) : RecyclerView.Adapter<AdapterTeam.ViewHolder>() {

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

    internal fun setDriverWithTeams(driverWithTeams: List<DriverWithTeam>) {
        this.dataList = driverWithTeams
        notifyDataSetChanged()
    }


    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {
        fun bind(dataItem: DriverWithTeam){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
            val ivrowdetail = itemView.findViewById(R.id.ivrowdetail) as ImageView
            val tvrowdetailapellido = itemView.findViewById(R.id.tvrowdetailapellido) as TextView
            val tvrowdetailcumpleanos = itemView.findViewById(R.id.tvrowdetailcumpleanos) as TextView
            val tvrowdetailpodiums = itemView.findViewById(R.id.tvrowdetailpodiums) as TextView
            val tvrowdetailpuntos = itemView.findViewById(R.id.tvrowdetailpuntos) as TextView

            tvrowdetailapellido.text = dataItem.driver.lastname
            tvrowdetailcumpleanos.text = dataItem.driver.dateofbirth
            tvrowdetailpodiums.text = dataItem.driver.podiums.toString()
            tvrowdetailpuntos.text = dataItem.driver.points.toString()
            // foto de internet a traves de Picasso
            Picasso.get().load(dataItem.driver.imagen).into(ivrowdetail)

            itemView.tag = dataItem

        }

    }
}