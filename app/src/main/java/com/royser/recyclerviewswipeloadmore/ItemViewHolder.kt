package com.royser.recyclerviewswipeloadmore

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.recyclerview_item.*

/**
 * Created by A Little Boy @Nextzy on 28/1/2019 AD.
 */
class ItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun onBind(profile: ProfileItem) {
        Glide.with(containerView.context).load(Uri.parse(profile.imgUrl)).into(imgUser)
        tvUser.text = profile.username
    }

}