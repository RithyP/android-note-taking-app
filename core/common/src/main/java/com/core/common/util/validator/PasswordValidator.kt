package com.core.common.util.validator

class PasswordValidator {
    /**
     * Should have more condition
     */
    companion object {
        fun isPasswordValid(password: CharSequence?): Boolean {
            return !password.isNullOrEmpty()
        }
    }
}