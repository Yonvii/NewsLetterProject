package id.kotlin.project1

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.edit
import id.kotlin.project1.Activity.Home_Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "Dion"
    var sharedPref : SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        btn_submit.setOnClickListener{
            validate()
        }
    }fun validateName() :Boolean{
        if(edit_name.text.length == 0){
            error_name.setText("Name must be filled")
            return false
        } else{
            error_name.setText(null)
            return true
        }
    }
    fun validateEmail() :Boolean {
        if (edit_email.text.length == 0) {
            error_email.setText("Email must be filled")
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edit_email.text).matches()) {
            error_email.setText("Must match E-Mail Pattern")
            return false
        } else {
            error_email.setText(null)
            return true
        }
    }

    fun validatePassword() :Boolean{
        if(edit_password.text.length == 0){
            return false
        }else if (edit_password.text.length < 8){
            error_password.setText("password must be 7 characters or longer")
            return false
        }else{
            error_password.setText(null)
            return true
        }
    }
    fun validateGender():Boolean{
        if(radio_group.checkedRadioButtonId == -1){
            error_gender.setText("Gender must be selected")
            return false
        }else{
            error_gender.setText(null)
            return true
        }
    }
    private fun validate() {
        if(validateName() && validateEmail() && validatePassword() && validateGender()){
            Toast.makeText(this@MainActivity,"Success",Toast.LENGTH_LONG).show()
            val intent = Intent(this,Home_Activity::class.java)
            val editor = sharedPref!!.edit()
            editor.putString("user-name",edit_name.text.toString())
            editor.putString("user-email",edit_email.text.toString())
            editor.apply()
            startActivity(intent)
        }
    }

}

