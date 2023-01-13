package com.example.mobile.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mobile.model.MoneyItem
import java.util.Collections.addAll

class RepayViewModel {
    private var _allItems = MutableLiveData<List<MoneyItem>>()
    val allItems get() = _allItems

    fun updateItems(list: List<MoneyItem>) {
        _allItems.value = list
    }
}