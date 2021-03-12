package ev.aykhn.demo

import android.os.Build
import android.util.DisplayMetrics
import androidx.fragment.app.FragmentActivity

val FragmentActivity.displayMetrics: Array<Int>
    get() {

        val metrics = arrayOf(0, 0) // width & height

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            val bounds = windowManager.currentWindowMetrics.bounds

            metrics[0] = bounds.width()
            metrics[1] = bounds.height()

        } else {

            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay.getRealMetrics(displayMetrics)

            metrics[0] = displayMetrics.widthPixels
            metrics[1] = displayMetrics.heightPixels

        }

        return metrics

    }