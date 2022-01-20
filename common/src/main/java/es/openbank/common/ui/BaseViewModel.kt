package es.openbank.common.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import es.openbank.common.util.lifecycle.Event
import es.openbank.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    private val navigation = MutableLiveData<Event<NavigationCommand>>()
    fun getNavigation() = navigation as LiveData<Event<NavigationCommand>>

    fun navigate(directions: NavDirections) {
        navigation.value = Event(NavigationCommand.To(directions))
    }

    fun navigateBack() {
        navigation.value = Event(NavigationCommand.Back)
    }
}