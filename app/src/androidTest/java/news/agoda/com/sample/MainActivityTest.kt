package news.agoda.com.sample

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import news.agoda.com.sample.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun `should be visible toolbar `() {
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(InterruptedException::class)
    fun `should be visible list of news `() {
        Thread.sleep(3000)
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(InterruptedException::class)
    fun `should be able to scroll and show details`() {
        Thread.sleep(3000)
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))
        onView(withId(R.id.full_story_link)).check(matches(isDisplayed()))
    }


}