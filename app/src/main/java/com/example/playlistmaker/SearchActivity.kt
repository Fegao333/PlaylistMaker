package com.example.playlistmaker

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged

class SearchActivity : AppCompatActivity() {

    private var searchText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        val backSearchButton = findViewById<ImageButton>(R.id.backSearch)
        backSearchButton.setOnClickListener {
            finish()
        }
        val clearButton = findViewById<ImageView>(R.id.clearIcon)
        val editText = findViewById<EditText>(R.id.searchEditText)

        editText.doOnTextChanged { text, _, _, _ ->
            searchText = text.toString()

            if (text.isNullOrEmpty()) {
                clearButton.visibility = View.GONE
            } else {
                clearButton.visibility = View.VISIBLE
            }
        }
        clearButton.setOnClickListener {
            editText.text.clear()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("SEARCH_TEXT", searchText)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredText = savedInstanceState.getString("SEARCH_TEXT", "")
        val search = findViewById<EditText>(R.id.searchEditText)
        search.setText(restoredText)
    }
}