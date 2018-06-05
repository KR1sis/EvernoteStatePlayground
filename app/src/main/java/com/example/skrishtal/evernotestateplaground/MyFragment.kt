package com.example.skrishtal.evernotestateplaground

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.evernote.android.state.State
import com.evernote.android.state.StateSaver

class MyFragment: Fragment() {

    val presenter = MyPresnter()

    @State
    var someState = "ThisIsSomeFragmentState"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.my_fragment, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        someState += " !"
        StateSaver.saveInstanceState(this, outState)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StateSaver.restoreInstanceState(this, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.text_view_fragment_state).apply {
            text = "Fragment state is: $someState"
        }
    }



}