package com.example.financepal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.financepal.data.dao.CategoryDao
import com.example.financepal.data.dao.ExpenseDao
import com.example.financepal.data.dao.UserDao
import com.example.financepal.data.model.Category
import com.example.financepal.data.model.Expense
import com.example.financepal.data.model.User

@Database(entities = [User::class, Expense::class, Category::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "financepal_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}