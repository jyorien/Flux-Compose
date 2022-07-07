package com.example.flux_compose.main

import androidx.lifecycle.ViewModel
import com.example.flux_compose.main.add.ADD_EXPENSE_SCREEN
import com.example.flux_compose.main.add.ADD_INCOME_SCREEN
import com.example.flux_compose.main.add.AddScreenData

class MainViewModel : ViewModel() {
    val addScreenDataMap = mapOf(
        ADD_INCOME_SCREEN to AddScreenData("Income", listOf("", "Salary", "Rewards")),
        ADD_EXPENSE_SCREEN to AddScreenData("Expense", listOf("", "Health", "Groceries"))
    )
}