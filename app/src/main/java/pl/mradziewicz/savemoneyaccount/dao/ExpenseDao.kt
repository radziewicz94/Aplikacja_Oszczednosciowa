package pl.mradziewicz.savemoneyaccount.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pl.mradziewicz.savemoneyaccount.model.Expenses

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses")
    fun getAll(): LiveData<List<Expenses>>

    @Insert
    fun insertAll(vararg exp: Expenses)

    @Insert
    fun insert(exp: Expenses)

    @Delete
    fun delete(exp: Expenses)
}