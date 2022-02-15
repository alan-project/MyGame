package net.alanproject.mygame.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import net.alanproject.mygame.R

@BindingAdapter("bannerImage")
fun bindBannerImage(view: ImageView, image: String?) {
    view.load(image){
        transformations(RoundedCornersTransformation(25f))
    }

}