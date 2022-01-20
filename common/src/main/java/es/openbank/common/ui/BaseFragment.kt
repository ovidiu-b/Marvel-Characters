package es.openbank.common.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import es.openbank.common.di.ViewModelFactory
import es.openbank.navigation.NavigationCommand
import androidx.appcompat.app.AlertDialog

abstract class BaseFragment: Fragment() {

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigation(getViewModel())
    }

    protected fun showErrorMessage(message: String) {
        activity?.let {
            val alertDialog: AlertDialog = AlertDialog.Builder(it).create()
            alertDialog.setTitle("Oops!")
            alertDialog.setMessage(message)
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK") { dialog, _ -> dialog.dismiss() }
            alertDialog.show()
        }
    }

    abstract fun getViewModel(): BaseViewModel

    private fun observeNavigation(viewModel: BaseViewModel) {
        viewModel.getNavigation().observe(viewLifecycleOwner, {
            it?.getValueIfNotHandled()?.let { command ->
                when (command) {
                    is NavigationCommand.To -> findNavController().navigate(command.directions, getExtras())
                    is NavigationCommand.Back -> findNavController().navigateUp()
                }
            }
        })
    }

    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProvider(this@BaseFragment, this)[T::class.java]

    open fun getExtras(): FragmentNavigator.Extras = FragmentNavigatorExtras()
}