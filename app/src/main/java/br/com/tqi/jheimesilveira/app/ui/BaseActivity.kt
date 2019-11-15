package br.com.tqi.jheimesilveira.app.ui

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.tqi.jheimesilveira.app.util.CommonUtil

abstract class BaseActivity : AppCompatActivity() {
    private var progressDialog: ProgressDialog? = null

    fun progressBar(status: Boolean) {

        if (!status) {
            progressDialog?.let { if (it.isShowing) it.cancel() }
            return
        }

        progressDialog?.let { if (it.isShowing) it.cancel() }
        progressDialog = CommonUtil.showLoadingDialog(this)
    }
}