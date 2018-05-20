package com.example.sampiercy.whatwhereweather.viewmodels

import com.example.sampiercy.stackoverflowusers.DISPLAY_NAME_BASE
import com.example.sampiercy.stackoverflowusers.LOCATION_BASE
import com.example.sampiercy.stackoverflowusers.createUserResponse
import com.example.sampiercy.stackoverflowusers.data.model.UsersResponse
import com.example.sampiercy.stackoverflowusers.data.repository.UserDataRepository
import com.example.sampiercy.stackoverflowusers.viewmodels.StackOverflowViewModel
import com.example.sampiercy.whatwhereweather.utils.RxImmediateSchedulerRule
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class StackOverflowViewModelTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @Mock
    private lateinit var userDataRepository: UserDataRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun givenIHaveValidData_whenIGetUsers_thenResponseShouldBeInitialised() {

        val userResponse = createUserResponse(3)
        `when`(userDataRepository.getUsers()).thenReturn(Single.just(userResponse))

        val response = StackOverflowViewModel(userDataRepository).getTopTwentyUsers(false)

        val testObserver = TestObserver<UsersResponse>()
        response.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.awaitTerminalEvent()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)

        val weatherOut = testObserver.values()[0]
        assertTrue(weatherOut.items.size == 3)
        assertTrue(weatherOut.items[0].displayName == DISPLAY_NAME_BASE + 0)
        assertTrue(weatherOut.items[2].location == LOCATION_BASE + 2)

    }

    @Test
    fun givenIHaveAndError_whenIGetUsers_thenResponseShouldGiveError() {

        val exception = Exception()

        `when`(userDataRepository.getUsers()).thenReturn(Single.error(exception))

        val response = StackOverflowViewModel(userDataRepository).getTopTwentyUsers(false)

        val testObserver = TestObserver<UsersResponse>()
        response.subscribe(testObserver)
        testObserver.assertError(exception)

    }


}