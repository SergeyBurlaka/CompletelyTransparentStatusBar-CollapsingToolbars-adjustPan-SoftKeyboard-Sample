package com.b5eg.sergburlaka.keyboard

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * Utility methods for manipulating the onscreen keyboard
 */
object KeyboardUtil {

    /**
     * Shows the soft keyboard
     */
    fun showSoftKeyboard(view: View) {
        val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        view.requestFocus()
        inputMethodManager.showSoftInput(view, 0)
    }

    fun forceOpen(view: View) {
        (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    /**
     * Hides the soft keyboard
     */
    fun hideSoftKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}