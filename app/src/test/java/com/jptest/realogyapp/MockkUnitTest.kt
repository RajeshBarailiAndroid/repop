package com.jptest.realogyapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jptest.realogyapp.model.Characters
import com.jptest.realogyapp.model.Icon
import com.jptest.realogyapp.model.RelatedTopics
import com.jptest.realogyapp.network.CharacterRepository
import com.jptest.realogyapp.utils.Response
import com.jptest.realogyapp.viewmodel.CharacterViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SatViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var viewModel: CharacterViewModel
    private lateinit var repository: CharacterRepository

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mockk()
        viewModel = CharacterViewModel(repository)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `test fentchSat with success response`() {
        // Given
        var icon=Icon("1","2","3")
        val response = listOf(RelatedTopics("abc", icon, "100", "100"))
        coEvery { repository.getCharacters() } returns Characters(response)

        //use the observer on livedata schools
        viewModel.character.observeForever { }

        // Call ViewModelScope
        viewModel.fetchSat()
               // verifying the result
        assert(viewModel.character.value is Response.Success)

        //removing the observer
        viewModel.character.removeObserver {}
    }

    @Test
    fun `test fentchSat with error response`() {
        // mock Error Message when called getSat()
        val errorMsg = "error message"
        coEvery { repository.getCharacters() } throws Exception(errorMsg)

        //use the observer on livedata sat
        viewModel.character.observeForever {}
        // Call ViewModel
        viewModel.fetchSat()

        // verifying the result
        assert(viewModel.character.value is Response.Error)
       assert((viewModel.character.value as Response.Error).errorMsg == errorMsg)

        //removing the observer
        viewModel.character.removeObserver {}
    }
}
