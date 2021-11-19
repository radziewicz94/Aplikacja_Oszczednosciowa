package pl.mradziewicz.savemoneyaccount.model

import android.widget.TextView
import androidx.room.PrimaryKey

class Expenses(
    var title: String?,
    var desc: String?
    ) {
    constructor(title: String?, desc: String?, costItemsForMonthlyExpenses: List<CostItems>
    ) : this(title, desc)
}