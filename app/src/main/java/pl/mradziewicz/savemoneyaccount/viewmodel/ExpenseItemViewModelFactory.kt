package pl.mradziewicz.savemoneyaccount.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ExpenseItemViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExpenseItemViewModel::class.java)){
            val key = "ExpenseItemViewModel"
            return if(hashMapViewModel.containsKey(key)){
                getViewModel(key) as T
            }else {
                addViewModel(key, ExpensesViewModel())
                ExpenseItemViewModel() as T
            }
        }
        throw IllegalArgumentException("Nieznany View model")
    }
    companion object {
        val hashMapViewModel = HashMap<String, ViewModel>()
        fun addViewModel(key: String, viewModel: ViewModel){
            hashMapViewModel.put(key, viewModel)
        }
        fun getViewModel(key: String): ViewModel? {
            return hashMapViewModel[key]
        }
    }
}