package net.azarquiel.recandroid1ev.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.io.Serializable

@Entity(tableName = "team")
data class Team(
    @PrimaryKey var id: Int,
    var nombre:String,
    var imagen:String,
    var link:String):Serializable

@Entity(tableName = "driver",
    foreignKeys = [ForeignKey(entity = Team::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("team"))])
data class Driver(
    @PrimaryKey  var id: Int,
    var firstname:String,
    var lastname:String,
    var imagen:String,
    var podiums:Int,
    var points:Float,
    var dateofbirth:String,
    var link:String,
    var team:Int
    ):Serializable
data class DriverWithTeam(
    @Embedded val driver: Driver,
    @Relation(
        parentColumn = "team",
        entityColumn = "id"
    )
    val team: Team
):Serializable
