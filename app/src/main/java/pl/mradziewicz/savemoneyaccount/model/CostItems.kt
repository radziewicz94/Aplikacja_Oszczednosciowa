package pl.mradziewicz.savemoneyaccount.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CostItems (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var value: Double
        ){
}