package com.royser.recyclerviewswipeloadmore

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var isLastPosition = false
    var scrollingToRight = false
    var isOpenedNewPage = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listBaseItem = ArrayList<ProfileItem>()
        listBaseItem.add(ProfileItem("Luffy", "file:///android_asset/495831-PHVOSG-682.jpg"))
        listBaseItem.add(ProfileItem("zoro", "file:///android_asset/495831-PHVOSG-682asqw.jpg"))
        listBaseItem.add(ProfileItem("NAMI", "file:///android_asset/495831-PHVOSG-682ghjklop.jpg"))
        listBaseItem.add(ProfileItem("Usopp", "file:///android_asset/495831-PHVOSG-682pff.jpg"))
        listBaseItem.add(ProfileItem("Sanji", "file:///android_asset/495831-PHVOSG-682sdf.jpg"))
        listBaseItem.add(ProfileItem("Chopper", "file:///android_asset/495831-PHVOSG-6821.jpg"))
        listBaseItem.add(ProfileItem("Robin", "file:///android_asset/495831-PHVOSG-682900l.jpg"))
        listBaseItem.add(ProfileItem("Franky", "file:///android_asset/495831-PHVOSG-6820900.jpg"))

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            adapter = ItemAdapter(listBaseItem)
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                scrollingToRight = when {
                    dx > 0 -> true
                    dx < 0 -> false
                    else -> false
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Handler().postDelayed({
                    if (!recyclerView.canScrollHorizontally(1) && scrollingToRight) {
                        if (isLastPosition && !isOpenedNewPage) {
                            startActivity(Intent(this@MainActivity, Main2Activity::class.java))
                            isOpenedNewPage = true
                        }
                        isLastPosition = true
                    } else {
                        isLastPosition = false
                    }
                }, 100)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        isOpenedNewPage = false
    }

}
