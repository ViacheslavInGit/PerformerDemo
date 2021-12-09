package com.viapp.b.presentation

import com.viapp.b.domain.navigation.Router
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Test

class GoalListViewModelTest {

    @Test
    fun `onAddClick open TaskCreationScreen`() {

        val router: Router = spyk(mockk<Router>())

        val viewModel = GoalListViewModel(
            router = router,
            getGoals = mockk(),
        )

        viewModel.onAddClick()

        verify { router.openTaskCreationScreen() }

        confirmVerified(router)
    }
}