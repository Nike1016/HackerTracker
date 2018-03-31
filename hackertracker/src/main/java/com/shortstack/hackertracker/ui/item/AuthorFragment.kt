package com.shortstack.hackertracker.ui.item

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shortstack.hackertracker.App
import com.shortstack.hackertracker.models.Item
import com.shortstack.hackertracker.models.ItemViewModel
import com.shortstack.hackertracker.R
import com.shortstack.hackertracker.view.SpeakerView
import kotlinx.android.synthetic.main.fragment_item_author.view.*

class AuthorFragment : Fragment() {

    override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View? {
        return inflater.inflate(R.layout.fragment_item_author, container, false)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val obj = ItemViewModel(content)
        displaySpeakers(obj, view.speakers)
    }

    private val content : Item
        get() = arguments?.getSerializable(ARG_ITEM) as Item

    private fun displaySpeakers(obj : ItemViewModel, speakers : LinearLayoutCompat) {
        val context = context ?: return

        obj.speakers.iterator().forEach {
            speakers.addView(SpeakerView(context, App.application.databaseController.getSpeaker(it)))
        }
    }

    companion object {

        val ARG_ITEM = "ARG_ITEM"

        fun newInstance(obj : Item) : AuthorFragment {
            val fragment = AuthorFragment()

            val bundle = Bundle()
            bundle.putSerializable(ARG_ITEM, obj)
            fragment.arguments = bundle

            return fragment
        }
    }
}