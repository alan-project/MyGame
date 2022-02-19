package net.alanproject.mygame.common

import android.util.DisplayMetrics
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import net.alanproject.mygame.R

fun ViewPager2.showHorizontalPreview(){

    this.apply {
        clipToPadding = false   // allow full width shown with padding
        clipChildren = false    // allow left/right item is not clipped
        offscreenPageLimit = 3  // make sure left/right item is rendered
    }

    //increase this offset to show more of left/right
    val offsetPx =
        resources.getDimension(R.dimen.dp_30).toInt().dpToPx(resources.displayMetrics)
    this.setPadding(0, 0, offsetPx, 0)

    //increase this offset to increase distance between 2 items
    val pageMarginPx =
        resources.getDimension(R.dimen.dp_5).toInt().dpToPx(resources.displayMetrics)
    val marginTransformer = MarginPageTransformer(pageMarginPx)
    this.setPageTransformer(marginTransformer)
}

private fun Int.dpToPx(displayMetrics: DisplayMetrics?): Int = (this * (displayMetrics?.density ?:0.0f )).toInt()

