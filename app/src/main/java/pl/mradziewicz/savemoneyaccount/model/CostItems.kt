package pl.mradziewicz.savemoneyaccount.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CostItems (
    var name: String,
    var value: Double,
    @PrimaryKey(autoGenerate = true) var id: Int? = null
    ){
}