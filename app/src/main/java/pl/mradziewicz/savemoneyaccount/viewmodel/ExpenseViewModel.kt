package pl.mradziewicz.savemoneyaccount.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mradziewicz.savemoneyaccount.model.Expenses

class ExpenseViewModel: ViewModel() {
    var expenseList = MutableLiveData<ArrayList<Expenses>>()
    var addExpense = ArrayList<Expenses>()

    fun add(expenses: Expenses){
        addExpense.add(expenses)
        expenseList.value = addExpense
    }
}