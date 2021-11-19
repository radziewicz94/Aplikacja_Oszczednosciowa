package pl.mradziewicz.savemoneyaccount.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mradziewicz.savemoneyaccount.model.CostItems
import pl.mradziewicz.savemoneyaccount.model.Expenses
import java.util.*
import kotlin.collections.ArrayList

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
    @RequiresApi(Build.VERSION_CODES.N)
    fun getExpense(test: String): List<CostItems> {
        return expensesLiveData.value?.stream()
            ?.filter { expense -> test == expense.title }
            ?.map(Expenses::title)
    }

    private fun wordLenghtConversion(expenses: Expenses){
        val lengthAfterRepleace = (expenses.title!!.length - 26) + 26
        val sb = StringBuilder().append(expenses.title)
        sb.delete(26, lengthAfterRepleace)
        sb.insert(26, "...")
        expenses.title = sb.toString()
    }

}