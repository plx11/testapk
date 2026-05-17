package com.plx11.testapk

import org.junit.Assert.assertEquals
import org.junit.Test

class HomeViewModelTest {

    @Test
    fun onPrimaryAction_updatesClickCountAndMessage() {
        val viewModel = HomeViewModel()

        viewModel.onPrimaryAction()

        val state = viewModel.uiState.value
        assertEquals(1, state.clicks)
        assertEquals("Button tapped 1 time(s)", state.message)
    }
}
