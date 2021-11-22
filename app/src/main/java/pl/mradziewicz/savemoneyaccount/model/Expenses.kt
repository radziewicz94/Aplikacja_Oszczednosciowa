package pl.mradziewicz.savemoneyaccount.model

class Expenses(
    var title: String?,
    var desc: String?,
    var costItems: MutableList<CostItems> = arrayListOf()
    ) {

}