package pl.mradziewicz.savemoneyaccount.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mradziewicz.savemoneyaccount.model.ExpenseItem
import pl.mradziewicz.savemoneyaccount.model.Expenses

class ExpenseItemViewModel: ViewModel() {
    var expenseItemLiveData = MutableLiveData<ArrayList<ExpenseItem>>()
    var expenseItemList = ArrayList<ExpenseItem>()

    fun add(expenseItem: ExpenseItem){
        if(expenseItem.name?.length!! > 26)
        {
            wordLenghtConversion(expenseItem)
        }
        expenseItemList.add(expenseItem)
        expenseItemLiveData.value = expenseItemList
    }
    fun update(id: Int, expenseItem: ExpenseItem){
        if(expenseItem.name?.length!! > 26)
        {
            wordLenghtConversion(expenseItem)
        }
        expenseItemList[id] = expenseItem
        expenseItemLiveData.value = expenseItemList
    }
    private fun wordLenghtConversion(expenseItem: ExpenseItem){
        val lengthAfterRepleace = (expenseItem.name!!.length - 26) + 26
        val sb = StringBuilder().append(expenseItem.name)
        sb.delete(26, lengthAfterRepleace)
        sb.insert(26, "...")
        expenseItem.name = sb.toString()
    }
}