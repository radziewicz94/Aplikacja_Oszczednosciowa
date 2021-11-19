package pl.mradziewicz.savemoneyaccount.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mradziewicz.savemoneyaccount.model.CostItems

class CostItemsViewModel: ViewModel() {
    var expenseItemLiveData = MutableLiveData<ArrayList<CostItems>>()
    var expenseItemList = ArrayList<CostItems>()

    fun add(costItems: CostItems){
        if(costItems.name?.length!! > 26)
        {
            wordLenghtConversion(costItems)
        }
        expenseItemList.add(costItems)
        expenseItemLiveData.value = expenseItemList
    }
    fun update(id: Int, costItems: CostItems){
        if(costItems.name?.length!! > 26)
        {
            wordLenghtConversion(costItems)
        }
        expenseItemList[id] = costItems
        expenseItemLiveData.value = expenseItemList
    }
    private fun wordLenghtConversion(costItems: CostItems){
        val lengthAfterRepleace = (costItems.name!!.length - 26) + 26
        val sb = StringBuilder().append(costItems.name)
        sb.delete(26, lengthAfterRepleace)
        sb.insert(26, "...")
        costItems.name = sb.toString()
    }
}