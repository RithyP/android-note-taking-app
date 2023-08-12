package com.core.common.util.validator

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordValidatorTest {

    @Test
    fun `When user pass a correct password format return true`() {
        assertTrue(PasswordValidator.isPasswordValid("123456789"))
    }

    @Test
    fun `When user pass an empty password return false`() {
        assertFalse(PasswordValidator.isPasswordValid(""))
    }

    @Test
    fun `When user pass a null password return false`() {
        assertFalse(PasswordValidator.isPasswordValid(null))
    }
}