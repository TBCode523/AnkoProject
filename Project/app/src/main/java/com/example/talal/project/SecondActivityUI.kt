package com.example.talal.project

import android.support.constraint.ConstraintLayout.LayoutParams.PARENT_ID
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk25.coroutines.onClick

class SecondActivityUI:AnkoComponent<SecondActivity> {
    override fun createView(ui: AnkoContext<SecondActivity>) = with(ui) {
        constraintLayout {
            val textView = textView{
                text = "This is the Anko constraint layout showcase!"
                id = R.id.presentation
                textSize = sp(6).toFloat()


            }.lparams(width = matchParent, height = wrapContent){
                //One method to apply constraints
                topToTop = PARENT_ID
                goneTopMargin = sp(0)
                bottomToTop = R.id.googleSearch
                goneRightMargin = sp(3)
                leftToLeft = PARENT_ID
                rightToRight = PARENT_ID
            }
            val nextAct = textView{
                text = "Next Activity"
                textSize = sp(6).toFloat()

                id = R.id.nextAct
                onClick {
                    startActivity<ThankYouActivity>()
                }

            }.lparams(width = matchParent, height = wrapContent){

                topToBottom = R.id.presentation
                topMargin = sp(7)


                leftToLeft = PARENT_ID



            }
            val googleSearch = editText {
                hint = "Web-Search"
                textSize = sp(6).toFloat()
                id = R.id.googleSearch
            }.lparams(width = matchParent, height = wrapContent) {

                topToBottom= R.id.nextAct
               topMargin = sp(10)
                bottomToTop = R.id.youtubeSearch
                leftToLeft = PARENT_ID
                rightToRight = PARENT_ID
            }


            val googleBtn = button {
                id = R.id.googleSearch_btn
                text = "GOOGLE SEARCH"
                onClick {
                    val query = "https://www.google.com/search?q="
                    if(googleSearch.text.isEmpty() || googleSearch.text.isBlank()){
                        toast("Search field is empty")
                    }
                    else {
                        browse(query + googleSearch.text)
                    }

                }
            }.lparams(width = matchParent, height = wrapContent) {


            }
            val youtubeBtn = button{
                id = R.id.youtubeSearch_btn
                text = "YOUTUBE SEARCH"
                onClick{
                    val query = "https://www.youtube.com/results?search_query="
                    if(googleSearch.text.isEmpty() || googleSearch.text.isBlank()){
                        toast("Search field is empty")
                    }else {
                        browse(query + googleSearch.text)
                    }

                }
            }.lparams(width = matchParent, height = wrapContent){

            }
            val soundcloudBtn = button{
                id = R.id.soundcloudBtn
                text = "SoundCloud Search"
                onClick{
                    val query = "https://soundcloud.com/search?q="
                    if(googleSearch.text.isEmpty() || googleSearch.text.isBlank()){
                        toast("Search field is empty")
                    }else {
                        browse(query + googleSearch.text)
                    }
                }
            }.lparams(width = matchParent, height = wrapContent){

            }

            //The recommended way to apply constraints on layout objects
            applyConstraintSet {

                googleBtn {
                    connect(
                            ConstraintSetBuilder.Side.START to ConstraintSetBuilder.Side.START of PARENT_ID margin dip(5),
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of R.id.googleSearch margin dip(5),
                            ConstraintSetBuilder.Side.END to ConstraintSetBuilder.Side.END of PARENT_ID margin dip(5),
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.TOP of R.id.youtubeSearch_btn
                    )
                }
                youtubeBtn{
                    connect(
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of R.id.googleSearch_btn,
                                    ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of R.id.soundcloudBtn,
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of PARENT_ID,
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of PARENT_ID

                    )
                }
                soundcloudBtn{
                    connect(
                    ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.BOTTOM of R.id.youtubeSearch_btn,
                    ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of PARENT_ID,
                    ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of PARENT_ID,
                    ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of PARENT_ID)

                }


            }
        }

    }
}