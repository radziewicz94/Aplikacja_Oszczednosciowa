package pl.mradziewicz.savemoneyaccount.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.mradziewicz.savemoneyaccount.model.Expenses

@Database(entities = [Expenses::class], version = 1)
abstract class ExpenseDatabases : RoomDatabase(){
    abstract fun expenseDao(): ExpenseDao

    companion object{
        private var instance: ExpenseDatabases? = null

        @Synchronized
        fun getInstance(ctx: Context): ExpenseDatabases{
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, ExpenseDatabases::class.java,
                "expenses")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            return instance as ExpenseDatabases
        }
        fun destroyInstance(){
            instance == null
        }
    }
}
