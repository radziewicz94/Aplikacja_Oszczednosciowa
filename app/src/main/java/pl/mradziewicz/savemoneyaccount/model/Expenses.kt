package pl.mradziewicz.savemoneyaccount.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Expenses(
    @ColumnInfo var title: String?,
    @ColumnInfo var desc: String?,
    @ColumnInfo var costItems: MutableList<CostItems> = arrayListOf(),
    @PrimaryKey(autoGenerate = true) private val id: Int? = null
    ) {

}