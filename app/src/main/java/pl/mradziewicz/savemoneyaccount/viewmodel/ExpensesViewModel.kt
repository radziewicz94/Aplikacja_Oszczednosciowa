package pl.mradziewicz.savemoneyaccount.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mradziewicz.savemoneyaccount.model.Expenses

class ExpensesViewModel: ViewModel() {
    var expensesLiveData = MutableLiveData<ArrayList<Expenses>>()
    var addExpense = ArrayList<Expenses>()

    fun add(expenses: Expenses){
        if(expenses.title?.length!! > 26)
        {
            wordLenghtConversion(expenses)
        }
            addExpense.add(expenses)
            expensesLiveData.value = addExpense
    }
    fun update(id: Int, expenses: Expenses){
        if(expenses.title?.length!! > 26)
        {
            wordLenghtConversion(expenses)
        }
        addExpense[id] = expenses
        expensesLiveData.value = addExpense
    }
    private fun wordLenghtConversion(expenses: Expenses){
        val lengthAfterRepleace = (expenses.title!!.length - 26) + 26
        val sb = StringBuilder().append(expenses.title)
        sb.delete(26, lengthAfterRepleace)
        sb.insert(26, "...")
        expenses.title = sb.toString()
    }

}