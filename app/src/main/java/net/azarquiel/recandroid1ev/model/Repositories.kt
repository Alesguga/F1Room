package net.azarquiel.recandroid1ev.model

import android.app.Application
import androidx.lifecycle.LiveData


class DriverRepository(application: Application) {

    val driverDao = F1DB.getDatabase(application).driverDao()

    // select
    fun getAllDrivers(): LiveData<List<DriverWithTeam>> {
        return driverDao.getAllDrivers()
    }

}
