package com.b5eg.sergburlaka.keyboard

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.ViewCompat
import com.jaeger.library.StatusBarUtil


class MainActivity : AppCompatActivity() {

    // Initializing an empty ArrayList to be filled with animals
    private val animals: ArrayList<String> = ArrayList()
    private var adapter: AnimalAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        StatusBarUtil.setTransparent(this)

        addAnimals()
        rv_animal_list.layoutManager = LinearLayoutManager(this)
        rv_animal_list.adapter = AnimalAdapter(ArrayList<Animal>().apply {
            animals.forEach {
                add(Animal(it))
            }
        })

        rv_animal_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                when (newState) {
                    RecyclerView.SCROLL_STATE_DRAGGING -> {
                        Handler(Looper.getMainLooper()).post {
                            KeyboardUtil.hideSoftKeyboard(this@MainActivity)
                        }
                    }

                    RecyclerView.SCROLL_STATE_SETTLING -> {
                        //do nothing
                    }

                    RecyclerView.SCROLL_STATE_IDLE -> {
                        //do nothing
                    }
                }

            }
        })

    }

    // Adds animals to the empty animals ArrayList
    private fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }
}

