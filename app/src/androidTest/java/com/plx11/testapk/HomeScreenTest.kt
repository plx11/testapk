package com.plx11.testapk

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_displaysTitleAndButton() {
        composeTestRule.setContent {
            HomeScreen(
                state = HomeUiState(),
                onPrimaryAction = {},
            )
        }

        composeTestRule.onNodeWithText("testapk").assertIsDisplayed()
        composeTestRule.onNodeWithText("Tap me").assertIsDisplayed()
    }
}
