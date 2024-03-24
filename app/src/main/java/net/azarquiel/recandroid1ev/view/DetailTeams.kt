package net.azarquiel.recandroid1ev.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.azarquiel.recandroid1ev.R
import net.azarquiel.recandroid1ev.adapter.AdapterDriver
import net.azarquiel.recandroid1ev.adapter.AdapterTeam
import net.azarquiel.recandroid1ev.databinding.ActivityDetailTeamsBinding
import net.azarquiel.recandroid1ev.model.Driver
import net.azarquiel.recandroid1ev.model.DriverWithTeam
import net.azarquiel.recandroid1ev.viewmodel.DriverViewModel

class DetailTeams : AppCompatActivity() {
    private lateinit var rvdrivers: RecyclerView
    private lateinit var adapter: AdapterTeam
    private lateinit var driverWithTeam: DriverWithTeam

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_teams)
        rvdrivers = findViewById<RecyclerView>(R.id.rvdrivers)

        initRV()
        driverWithTeam = intent.getSerializableExtra("driverwithteam") as DriverWithTeam

        val teamId = 1 // Reemplaza esto con el ID del equipo deseado

        val driverViewModel = ViewModelProvider(this).get(DriverViewModel::class.java)

        driverViewModel.getAllDrivers().observe(this, Observer { drivers ->
            val filteredDrivers = drivers?.filter { it.team.id == teamId }
            filteredDrivers?.let { adapter.setDriverWithTeams(it) }
        })

    }

    private fun initRV() {
        adapter = AdapterTeam (this, R.layout.rowdetailteams)
        rvdrivers.adapter = adapter
        rvdrivers.layoutManager = LinearLayoutManager(this)
    }
    fun onClickWeb(v: View) {
        val webpulsada = v.tag as DriverWithTeam
        val intent = Intent(this, ActivityWeb::class.java)
        intent.putExtra("link", webpulsada.driver.link)
        startActivity(intent)
    }



}