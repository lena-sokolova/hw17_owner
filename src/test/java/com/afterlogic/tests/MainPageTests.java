package com.afterlogic.tests;

import com.afterlogic.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();
    TestData testData = new TestData();

    @Test
    @Tag("smoke")
    @DisplayName("Успешное открытие главной страницы")
    void successfulOpenMainPageTest() {
        mainPage
                .openPage()
                .checkHomePageText();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия всех табов на странице")
    void checkTabsTitlesTest() {
        mainPage
                .openPage()
                .checkTabsTitles();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Проверка наличия всех продуктов в каталоге")
    void checkProductsTest() {
        mainPage
                .openPage()
                .openAllProductsList()
                .checkProductTitles();
    }

//    @Disabled
    @Test
    @DisplayName("Проверка заполнения формы обратной связи")
    void checkContactUsFormTest() {
        mainPage
                .openPage()
                .openContactForm()
                .setCompanyName(testData.companyName)
                .setYourName(testData.userName)
                .setPhoneNumber(testData.userNumber)
                .setEmail(testData.userEmail)
                .setMessage(testData.message)
                .clickSendBtn()
                .checkSuccessSendMessageText();
    }

    @Test
    @DisplayName("Проверка перехода в раздел политики конфиденциальности")
    void checkPrivacyPolicySectionTest() {
        mainPage
                .openPage()
                .openPrivacyPolicyTerms()
                .checkOpenPrivacyPolicyTerms();
    }
}

