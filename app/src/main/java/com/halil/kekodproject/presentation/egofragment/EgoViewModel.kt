package com.halil.kekodproject.presentation.egofragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EgoViewModel: ViewModel() {

    private val _switchEgoState = MutableLiveData<Boolean>()
    val switchEgoState: LiveData<Boolean> get() =_switchEgoState

    private val _switchHappinessState = MutableLiveData<Boolean>()
    val switchHappinessState: LiveData<Boolean> get() =_switchHappinessState

    private val _switchKindnessState = MutableLiveData<Boolean>()
    val switchKindnessState: LiveData<Boolean> get() =_switchKindnessState

    private val _switchOptimisticState = MutableLiveData<Boolean>()
    val switchOptimisticState: LiveData<Boolean> get() =_switchOptimisticState

    private val _switchRespectState = MutableLiveData<Boolean>()
    val switchRespectState: LiveData<Boolean> get() =_switchRespectState

    private val _switchGivingState = MutableLiveData<Boolean>()
    val switchGivingState: LiveData<Boolean> get() =_switchGivingState

    fun setSwitchEgoState(state: Boolean) {
        _switchEgoState.value = state
    }

    fun setSwitchHappinessState(state: Boolean) {
        _switchHappinessState.value = state
    }

    fun setSwitchKindnessState(state: Boolean) {
        _switchKindnessState.value = state
    }

    fun setSwitchOptimisticState(state: Boolean) {
        _switchOptimisticState.value = state
    }

    fun setSwitchRespectState(state: Boolean) {
        _switchRespectState.value = state
    }

    fun setSwitchGivingState(state: Boolean) {
        _switchGivingState.value = state
    }

}