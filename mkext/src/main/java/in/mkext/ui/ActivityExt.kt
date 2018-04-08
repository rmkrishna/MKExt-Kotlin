package `in`.mkext.ui

import android.app.Activity
import android.content.Intent
import android.support.annotation.IdRes
import android.support.v4.app.*
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity

/**
 * Created by muthu on 13/3/18.
 */

inline fun <reified T : Activity> Activity.launchActivity(option: ActivityOptionsCompat? = null) {

    val intent = Intent(this, T::class.java)
    if (option == null) {
        startActivity(intent)
    } else {
        ActivityCompat.startActivity(this, intent, option.toBundle())
    }
}

inline fun <reified T : Activity> Activity.launchActivity(id: String) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("id", id)
    startActivity(intent)
}

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}

/**
 * Runs a FragmentTransaction, then calls commit().
 */
private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}

fun AppCompatActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolbarId))
    supportActionBar?.run {
        action()
    }
}