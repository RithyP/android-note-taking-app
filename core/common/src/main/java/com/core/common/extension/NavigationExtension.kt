package com.core.common.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.annotation.IdRes
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import kotlin.reflect.KClass

fun Fragment.navigationDestination(navID: Int, arg: Bundle? = null) {
    try {
        this.findNavController().navigate(navID, args = arg, navOptions = navOptions {
            restoreState

        })
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun Fragment.buildToPopBackStack(navID: Int, args: Bundle? = null) {
    val navOptions: NavOptions = NavOptions.Builder().setPopUpTo(navID, true).build()
    findNavController().navigate(navID, args, navOptions)
}

/**
 * Use this to navigate to a new screen.
 * @param resId The destination id of the screen you want to navigate to
 * @param args Pass bundle data (Optional)
 * @param navAnim Animation type that you want to show when navigating to the next screen (Optional)
 */
fun NavController.customNavigateFragment(
    @IdRes resId: Int,
    args: Bundle? = null,
) {
    val navOptions = navOptions {

    }
    try {
        navigate(resId, args, navOptions)
    } catch (e: Exception) {
        // Just Do nothing
        e.printStackTrace()
    }
}

/**
 * Use this to navigate to a new screen and popping the previous screen at the same time.
 * @param destinationId: The destination id of the screen you want to navigate to
 * @param popUntil: Pop all the backstack screen until the popUntil id.
 * @param inclusive: true or false whether you want to pop the popUntil screen too. Default value is false.
 * @param bundle Pass bundle data (Optional)
 * @param navAnim Animation type that you want to show when navigating to the next screen (Optional)
 */
fun NavController.customPopScreenAndNavigateFragment(
    @IdRes destinationId: Int,
    @IdRes popUntil: Int,
    inclusive: Boolean = false,
    bundle: Bundle? = null,
) {
    val navOptions = NavOptions.Builder().setPopUpTo(popUntil, inclusive).build()

    try {
        navigate(destinationId, bundle, navOptions)
    } catch (e: Exception) {
        // Just Do nothing
        e.printStackTrace()
    }
}

/**
 * Usage documentation coming soon.
 */
fun NavController.navigateToActivityWithNavHost(
    @IdRes activityId: Int,
    @IdRes destinationId: Int,
    bundle: Bundle? = null,
) {
    val navOptions = navOptions {

    }
    val extrasBundle = bundleOf(
        "navigationId" to destinationId,
        "bundles" to bundle,
    )
    try {
        navigate(activityId, extrasBundle, navOptions)
    } catch (e: Exception) {
        // Just Do nothing
        e.printStackTrace()
    }
}


fun NavController.customNavigateFragment(
    navDirections: NavDirections,
) {
    val navOptions = navOptions {}
    try {
        navigate(navDirections, navOptions)
    } catch (e: Exception) {
        // Just Do nothing
        e.printStackTrace()
    }
}

fun NavController.customNavigateFragment(
    uri: String
) {
    val navOptions = navOptions {}
    try {
        val request = NavDeepLinkRequest.Builder.fromUri(uri.toUri()).build()
        navigate(request, navOptions)
    } catch (e: Exception) {
        // Just Do nothing
        e.printStackTrace()
    }
}

fun ActivityResultLauncher<Intent>.launchWithActivityLauncher(
    context: Context,
    cls: KClass<out Activity>,
    bundle: Bundle? = null,
) {
    this.launch(Intent(context, cls.java).also {
        if (bundle != null) {
            it.putExtras(bundle)
        }
    })
}

fun Activity.done(bundle: Bundle? = null, dismissFromBelow: Boolean = true) {
    if (bundle != null) {
        setResult(Activity.RESULT_OK, Intent().apply {
            putExtras(bundle)
        })
    } else {
        setResult(Activity.RESULT_OK)
    }
    finish()
}