package com.valorantagentsapplicationcleanarchitecture.utils

import android.content.Context


class InternetConnectivity(private val context: Context) {
//
//    private lateinit var noInternetDialog: RoundedBottomSheetDialog
//
//
//    fun hideNoInternet() {
//        if (noInternetDialog.isShowing && this::noInternetDialog.isInitialized) {
//            noInternetDialog.dismiss()
//        }
//    }
//
//    fun showNoInternet(context: Context, onRetry: () -> Unit) {
//        when{
//            this::noInternetDialog.isInitialized.not()->{
//                noInterNetBottomSheet(context, onRetry)
//            }
//            noInternetDialog.isShowing.not()->{
//                noInternetDialog.show()
//            }
//        }
//    }
//
//    fun isInternet(): Boolean {
//        val connectivityManager =
//            (context.applicationContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
//        val networkInfo = connectivityManager.activeNetworkInfo
//        return networkInfo != null && networkInfo.isConnectedOrConnecting
//    }
//
//    private fun noInterNetBottomSheet(context: Context, onRetry: () -> Unit) {
//        noInternetDialog = RoundedBottomSheetDialog(context)
//        noInternetDialog.setCancelable(false)
//        val noInternetPopup = LayoutInflater.from(context).inflate(R.layout.no_internet_popup, null)
//        val reconnectButton = noInternetPopup.findViewById<Button>(R.id.noInternet_reconnectButton)
//        noInternetDialog.setContentView(noInternetPopup)
//        reconnectButton.setOnClickListener {
//            noInternetDialog.dismiss()
//            onRetry.invoke()
//        }
//    }
}