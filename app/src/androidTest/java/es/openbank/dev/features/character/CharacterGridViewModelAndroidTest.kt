package es.openbank.dev.features.character

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import es.openbank.character.ui.fragment.CharacterGridFragment
import es.openbank.dev.R
import es.openbank.dev.features.util.EspressoUtils
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CharacterGridViewModelAndroidTest {

    @Test
    fun navigateToCharacterDetailFragment() {
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val characterGridScenario = launchFragmentInContainer<CharacterGridFragment>(null, R.style.AppTheme)

        characterGridScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.navigation_graph__characters)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(EspressoUtils.withIndex(ViewMatchers.withId(R.id.itemGridCardView), 0)).perform(ViewActions.click())
        assert(navController.currentDestination?.id == R.id.characterDetailFragment)
    }

}