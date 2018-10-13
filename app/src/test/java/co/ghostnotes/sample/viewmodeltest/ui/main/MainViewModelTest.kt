package co.ghostnotes.sample.viewmodeltest.ui.main

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockObserver: Observer<Int>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        viewModel = MainViewModel()
    }

    @Test
    fun increment() {
        val initial = 0
        val expected = 1

        assertThat(viewModel.count.value, `is`(initial))

        viewModel.count.observeForever(mockObserver)
        viewModel.increment()

        verify(mockObserver).onChanged(expected)
    }

}