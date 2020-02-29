package com.example.talal.project

import android.util.Log
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI: AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>)= with(ui){
        frameLayout{
            val frameText = textView {
                text = "This is the Anko frame and linear layout!"
                textSize = dip(5).toFloat()
            }
            val textField = editText{
                hint = "text for toast"


            }.lparams(width = matchParent){
                margin = dip(12)
                topMargin = dip(30)

            }

            val numberText = editText {
                hint = "Enter a email Address"

            }.lparams(width = matchParent){
                margin = dip(12)
                topMargin = dip(90)
            }
            linearLayout{
                button("Show Text"){
                    onClick{
                      toast(textField.text)
                    }

                }
                button("Next Activity"){
                    onClick{
                        toast("Next Activity!")
                        startActivity<SecondActivity>()

                    }
                }
                button("Email"){
                    onClick {
                       val email = numberText.text
                       Log.d("Text: ", "The String is ${numberText}")

                        if(email.isNotEmpty() && email.isNotBlank()){
                            email("$email", "")
                        }
                        else{
                            toast("Text message field is Empty!")
                        }

                    }
                }

            }.lparams{
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(72)
            }
        }
    }

}