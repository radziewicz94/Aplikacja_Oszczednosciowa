package pl.mradziewicz.savemoneyaccount.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CostItemsViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CostItemsViewModel::class.java)){
            val key = "ExpenseItemViewModel"
            return if(hashMapViewModel.containsKey(key)){
                getViewModel(key) as T
            }else {
                addViewModel(key, CostItemsViewModel())
                CostItemsViewModel() as T
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