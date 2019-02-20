package com.testing.testing

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


class MainActivityPresenterTest {

    @Mock
    var view: MainActivityView? = null
    @Mock
    var presenter: MainActivityPresenterImplementation? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MainActivityPresenterImplementation(view!!)
    }

    @Test
    fun testEmptyEmail() {
        presenter!!.validateEmail("")
        verify(view!!).setEmptyEmailError()
    }


    @Test
    fun testInvalidEmail() {
        presenter!!.validateEmail("111")
        verify(view!!).setInvalidEmailError()

    }


    @Test
    fun testEmptyPassword() {
        presenter!!.validatePassword("")
        verify(view!!).setEmptyPasswordError()

    }

    @Test
    fun testInvalidPassword() {
        presenter!!.validatePassword("1111")
        verify(view!!).setInvalidPasswordError()

    }


    @Test
    fun testValidEmailAndPassword() {
        Mockito.`when`(view!!.getEmail()).thenReturn("mah@c.v")
        Mockito.`when`(view!!.getPassword()).thenReturn("123456")
        presenter!!.doLogin()
        verify(view!!).successLogin()

    }


}