package com.core.common.util

import com.core.common.util.validator.EmailValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun `When user pass the correct format return true`() {
        assertTrue(EmailValidator.isValidEmail("username@gmail.com"))
    }

    @Test
    fun `When user pass email with sub domain return true`() {
        assertTrue(EmailValidator.isValidEmail("username@bankname.com.kh"))
    }

    @Test
    fun `When user pass email without the front name return false`() {
        assertFalse(EmailValidator.isValidEmail("@bankname.com"))
    }

    @Test
    fun `When user pass email without the tld return false`() {
        assertFalse(EmailValidator.isValidEmail("username@bankname"))
    }

    @Test
    fun `When user pass email with extra dot return false`() {
        assertFalse(EmailValidator.isValidEmail("username@bankname..com"))
    }

    @Test
    fun `When user pass an empty email return false`() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun `When user pass a null email return false`() {
        assertFalse(EmailValidator.isValidEmail(null))
    }
}