package pl.mradziewicz.savemoneyaccount.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mradziewicz.savemoneyaccount.model.CostItems
import pl.mradziewicz.savemoneyaccount.model.Expenses
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
    fun addCostItem(expanses: String, expenseItemName: CostItems){
        for(i in 0 until expensesLiveData.value?.size!!){
            if(expensesLiveData.value!![i].title == expanses){
                val expanse = expensesLiveData.value!![i]
                expanse.costItems.add(expanse.costItems.size, expenseItemName)
              //  expensesLiveData.value!![i].costItems.add(expanse.costItems.size, expenseItemName)

            }
        }
    }
    /*@RequiresApi(Build.VERSION_CODES.N)
    fun getExpense(expenseTitle: String): List<CostItems>? {
        return expensesLiveData.value?.stream()
            ?.filter { expense -> expenseTitle == expense.title }
            ?.map(Expenses::costItems)
            ?.flatMap(List::stream)
            ?.collect(Collectors.toList())
    }*/
   fun getExpenseItems(expenseTitle: String): List<CostItems>? {
       for(i in 0 until expensesLiveData.value?.size!!){
           if(expenseTitle == expensesLiveData.value!![i].title) {
               return expensesLiveData.value!![i].costItems
           }
       }
       return emptyList()
   }

    private fun wordLenghtConversion(expenses: Expenses){
        val lengthAfterRepleace = (expenses.title!!.length - 26) + 26
        val sb = StringBuilder().append(expenses.title)
        sb.delete(26, lengthAfterRepleace)
        sb.insert(26, "...")
        expenses.title = sb.toString()
    }

}