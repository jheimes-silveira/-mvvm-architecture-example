package br.com.jheimesilveira.app.util

import android.app.ProgressDialog
import android.content.Context
import android.widget.ImageView
import br.com.jheimesilveira.app.BuildConfig
import br.com.jheimesilveira.app.R
import com.bumptech.glide.Glide

object CommonUtil {
    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }

    fun loadImage(context: Context, imageView: ImageView, posterPath: String?) {
        Glide
            .with(context)
            .load("${BuildConfig.IMAGE_URL}${posterPath}")
            .into(imageView)
    }
}