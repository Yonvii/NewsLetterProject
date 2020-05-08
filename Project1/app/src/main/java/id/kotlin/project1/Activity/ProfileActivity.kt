package id.kotlin.project1.Activity

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.project1.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    val PRIVATE_MODE = 0
    val PREF_NAME ="Dion"
    var sharedPrefs : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        sharedPrefs = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        user_profile_name.setText(sharedPrefs!!.getString("user-name",""))
        user_profile_email.setText(sharedPrefs!!.getString("user-email",""))
    }
}