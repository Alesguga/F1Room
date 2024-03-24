package net.azarquiel.recandroid1ev.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction


@Dao
interface TeamDao {
    @Query("SELECT * from team ORDER BY nombre ASC")
    fun getAllTeams(): LiveData<List<Team>>
}
@Dao
interface DriverDao {
    @Transaction
    @Query("SELECT * from driver ORDER BY lastname ASC")
    fun getAllDrivers(): LiveData<List<DriverWithTeam>>
}