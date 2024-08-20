package com.rediska1114.plugins.storereview

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin
import com.google.android.play.core.review.ReviewManagerFactory

@CapacitorPlugin(name = "StoreReview")
class StoreReviewPlugin : Plugin() {
    @PluginMethod
    fun requestReview(call: PluginCall) {
        val manager = ReviewManagerFactory.create(activity)
        val request = manager.requestReviewFlow();
    
        request.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // We can get the ReviewInfo object
                val flow = manager.launchReviewFlow(activity, task.result!!)
                flow.addOnCompleteListener {
                    Log.i("StoreReview", "Request review flow finished")
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown. Thus, no
                    // matter the result, we continue our app flow.
                    call.resolve()
                }
            } else {
                // There was some problem, continue regardless of the result.
                call.reject("Request review task Failed")
            }
        }
    }

    @PluginMethod
    fun navigateToAppStore(call: PluginCall) {
        val uri = Uri.parse("market://details?id=" + context.packageName)
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
           goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        try {
            context.startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            val webUri = Uri.parse("https://play.google.com/store/apps/details?id=" + context.packageName)
            val webIntent = Intent(Intent.ACTION_VIEW, webUri)
            context.startActivity(webIntent)
        }
         call.resolve()
    }
}
