package com.example.unittest11_08_2021.retrofit

import android.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ViewModelTest {
    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private var mViewModel: ViewModel? = null


    @Mock
    var viewModelRepository: ViewModelRepository? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(ViewModelRepository::class.java)
        mViewModel = ViewModel()
//        viewModelRepository=ViewModelRepository()
    }

    @Test
    fun testApiFetchDataSuccess() {
        mViewModel?.login()
        println(mViewModel?.login2())
//        viewModelRepository?.registerPhone()
//        println(mViewModel?.login())
    }

    @After
    fun tearDown() {
        mViewModel = null
    }

}