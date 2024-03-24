package net.azarquiel.recandroid1ev.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import net.azarquiel.recandroid1ev.R
import net.azarquiel.recandroid1ev.adapter.AdapterDriver
import net.azarquiel.recandroid1ev.databinding.ActivityMainBinding
import net.azarquiel.recandroid1ev.model.DriverWithTeam
import net.azarquiel.recandroid1ev.util.Util
import net.azarquiel.recandroid1ev.viewmodel.DriverViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: AdapterDriver
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        Util.inyecta(this, "f1.sqlite")
        initRV()

        val DriverViewModel = ViewModelProvider(this).get(DriverViewModel::class.java)
        DriverViewModel.getAllDrivers().observe(this, Observer { drivers ->
            // Update the cached copy of the products in the adapter.
            drivers?.let { adapter.setDriverWithTeam(it) }
        })
    }

    private fun initRV() {
        adapter = AdapterDriver (this, R.layout.rowteams)
        binding.cm.rvteams.adapter = adapter
        binding.cm.rvteams.layoutManager = LinearLayoutManager(this)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    fun onClickTeam(v: View){
        val teampulsado = v.tag as DriverWithTeam
        val intent = Intent (this,DetailTeams::class.java)
        intent.putExtra("driverwithteam", teampulsado)
        startActivity(intent)

    }
}