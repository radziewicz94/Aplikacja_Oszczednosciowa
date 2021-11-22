package pl.mradziewicz.savemoneyaccount.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mradziewicz.savemoneyaccount.model.CostItems

class CostItemsViewModel: ViewModel() {
    var costItemLiveData = MutableLiveData<ArrayList<CostItems>>()
    var costItemList = ArrayList<CostItems>()

    fun add(costItems: CostItems){
        if(costItems.name?.length!! > 26)
        {
            wordLenghtConversion(costItems)
        }
        costItemList.add(costItems)
        costItemLiveData.value = costItemList
    }
    fun update(id: Int, costItems: CostItems){
        if(costItems.name?.length!! > 26)
        {
            wordLenghtConversion(costItems)
        }
        costItemList[id] = costItems
        costItemLiveData.value = costItemList
    }
    private fun wordLenghtConversion(costItems: CostItems){
        val lengthAfterRepleace = (costItems.name!!.length - 26) + 26
        val sb = StringBuilder().append(costItems.name)
        sb.delete(26, lengthAfterRepleace)
        sb.insert(26, "...")
        costItems.name = sb.toString()
    }
}