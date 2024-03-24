package net.azarquiel.recandroid1ev.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.azarquiel.recandroid1ev.model.DriverRepository
import net.azarquiel.recandroid1ev.model.DriverWithTeam

class DriverViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: DriverRepository = DriverRepository(application)

    fun getAllDrivers(): LiveData<List<DriverWithTeam>> {
        return repository.getAllDrivers()
    }

}