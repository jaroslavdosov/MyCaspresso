package com.example.mycaspresso.screen

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.switch.KSwitch
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.example.mycaspresso.MainActivity
import com.example.mycaspresso.R
import com.kaspersky.components.kautomator.component.edit.UiEditText
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.kaspresso.screens.KScreen
import io.qameta.allure.android.allureScreenshot
import io.qameta.allure.kotlin.Allure.step


object SimpleScreen : KScreen<SimpleScreen>() {

    override val layoutId: Int? = R.layout.activity_main
    override val viewClass: Class<*>? = MainActivity::class.java

    val swith1 = KSwitch{ withId(R.id.switch1) }

    val helloText = KTextView{ withText("Hello World!") }

    fun clickOnSwith() {
        step("Нажать на свитч") {
            swith1.click()
        }
    }
    fun checkWelcomePage() {
        step("Открыт экран приверствия") {
            SimpleScreen.helloText.isDisplayed()
            allureScreenshot(name = "ss_step", quality = 90, scale = 1.0f)
        }
    }
    fun checkSwith(checked:Boolean) {
        step("проверить статус чек бокса ${checked.toString()}") {
            if(checked) SimpleScreen.swith1.isChecked()
            else SimpleScreen.swith1.isNotChecked()
        }
    }
}