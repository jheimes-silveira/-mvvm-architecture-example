package br.com.jheimesilveira.app.ui

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
//    private var progressDialog: ProgressDialog? = null

    fun progressBar(status: Boolean) {

//        if (!status) {
//            progressDialog?.let { if (it.isShowing) it.cancel() }
//            return
//        }
//
//        progressDialog?.let { if (it.isShowing) it.cancel() }
//        progressDialog = CommonUtil.showLoadingDialog(this)
    }
}