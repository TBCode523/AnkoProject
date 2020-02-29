package com.example.talal.project

import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk25.coroutines.onClick

class ThankYouActivityUI:AnkoComponent<ThankYouActivity> {
    override fun createView(ui: AnkoContext<ThankYouActivity>): View = with(ui) {
        constraintLayout {
            val textView = textView {
                text = "Thank You for your Time!"
                id = R.id.thankYouTxt
                textSize = sp(6).toFloat()


            }.lparams(width = matchParent, height = wrapContent) {
                //One method to apply constraints
                topToTop = ConstraintLayout.LayoutParams.PARENT_ID
                goneTopMargin = sp(0)
                bottomToTop = R.id.ContactMeTxt
                goneRightMargin = sp(3)
                leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
            }
            val nextAct = textView {
                text = "Contact Me!(Click Here)"
                textSize = sp(6).toFloat()
                id = R.id.ContactMeTxt
                onClick {
                    email("t.brek123@gmail.com", "We saw your app!")
                }

            }.lparams(width = matchParent, height = wrapContent) {

                topToBottom = R.id.thankYouTxt
                topMargin = sp(7)


                leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID


            }
            val backBtn = button {
                text = "Go to the beginning?"
                textSize = sp(6).toFloat()
                id = R.id.goBackBtn
                onClick{

                    startActivity<MainActivity>()
                }
            }.lparams(width = matchParent, height = wrapContent) {

                topToBottom = R.id.ContactMeTxt
                topMargin = sp(10)

                leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
                rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
            }


        }
    }
}