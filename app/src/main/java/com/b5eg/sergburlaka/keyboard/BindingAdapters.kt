package com.b5eg.sergburlaka.keyboard

import android.content.Context
import android.content.Intent
import android.databinding.BindingAdapter
import android.net.Uri
import android.support.v7.widget.AppCompatEditText
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView


/**
 * Data Binding adapters specific to the app.
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("app:clearFocus")
    fun clearFocus(view: AppCompatEditText, focus: Boolean) {
        if (!focus) {
            if (view.windowToken != null) {
                Log.d("123", "hide key board in field: ${view.text}")
                val inputMethodManager = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
                inputMethodManager!!.hideSoftInputFromWindow(view.windowToken, 0)
            }
            view.clearFocus()
        }
    }

    @JvmStatic
    @BindingAdapter("app:web")
    fun navigateWeb(view: TextView, web: String?) {
        view.setOnClickListener {
            view.context.startActivity(Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(
                        if (web?.contains("http://")?.not() == true) {
                            "http://$web"
                        } else web
                )
            })
        }
    }

    @JvmStatic
    @BindingAdapter("requestFocus")
    fun requestFocus(view: EditText, isTrue: Boolean) {
        if (view.text.isEmpty()) {

            view.requestFocus()
            val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
        }
    }

    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("app:number")
    fun showNumber(view: TextView, number: Long) {
        view.text = number.toString()
    }


}



