package com.afterlogic.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    String successOpenPageText = "Afterlogic Corp. is an award-winning technological company";
    List<String> tabsTitles = List.of("Products", "Purchase", "Support", "Our Clients", "Services", "About");
    List<String> productNames = List.of("Afterlogic Aurora Corporate", "Afterlogic WebMail Pro PHP",
            "Afterlogic WebMail Pro ASP.NET", "Afterlogic ActiveServer", "Afterlogic MailSuite Pro for Linux",
            "MailBee.NET Objects", "MailBee Objects");
    String productsListName = "All Products";
    String contactFormName = "Contact";
    String successSendMessageText = "Thank you for your inquiry.\n" +
            "Your message will be processed as soon as possible.";
    String privacyPolicyTitleName = "Privacy policy";

    SelenideElement
            homeText = $(".home-hero"),
            purchaseTab = $(".item102"),
            productsListLink = $("[href='/purchase/order-online']"),
            aboutTab = $(".item112"),
            contactUsLink = $("[href='/contact']"),
            companyName = $("#jform_company"),
            yourName = $("#jform_name"),
            phoneNumber = $("#jform_phone"),
            email = $("#jform_email"),
            message = $("#jform_message"),
            sendBtn = $(".button"),
            sendMessageText = $(".alert-message"),
            privacyPolicyLink = $("[href='/privacy-policy']"),
            privacyPolicyTitle = $("h1");

    ElementsCollection tabsBar = $$("#main-menu a.l1");
    ElementsCollection productsList = $$(".products-list h3");

    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open(baseUrl);
        sleep(2000);
        return this;
    }

    @Step("Проверяем отображение информации о компании")
    public MainPage checkHomePageText() {
        homeText.shouldHave(text(successOpenPageText));
        return this;
    }

    @Step("Проверяем наличие всех табов на странице")
    public MainPage checkTabsTitles() {
        tabsBar.shouldHave(texts(tabsTitles));
        return this;
    }

    @Step("Переходим на страницу со списком продуктов")
    public MainPage openAllProductsList() {
        purchaseTab.hover().$(byText(productsListName)).hover();
        productsListLink.click();
        return this;
    }

    @Step("Проверяем наличие всех продуктов в списке")
    public MainPage checkProductTitles() {
        productsList.shouldHave(texts(productNames));
        return this;
    }

    @Step("Переходим к форме обратной связи")
    public MainPage openContactForm() {
        aboutTab.hover().$(byText(contactFormName)).hover();
        contactUsLink.click();
        return this;
    }

    @Step("Заполняем поле Company/Organization name")
    public MainPage setCompanyName(String value) {
        companyName.setValue(value);
        return this;
    }

    @Step("Заполняем поле Your name")
    public MainPage setYourName(String value) {
        yourName.setValue(value);
        return this;
    }

    @Step("Заполняем поле Phone number")
    public MainPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    @Step("Заполняем поле Email")
    public MainPage setEmail(String value) {
        email.setValue(value);
        return this;
    }

    @Step("Заполняем поле Message")
    public MainPage setMessage(String value) {
        message.setValue(value);
        return this;
    }

    @Step("Отправляем сообщение")
    public MainPage clickSendBtn() {
        sendBtn.click();
        return this;
    }

    @Step("Проверяем, что сообщение успешно отправлено")
    public MainPage checkSuccessSendMessageText() {
        sendMessageText.shouldHave(text(successSendMessageText));
        return this;
    }

    @Step("Открываем раздел политики конфиденциальности")
    public MainPage openPrivacyPolicyTerms() {
        privacyPolicyLink.click();
        return this;
    }

    @Step("Проверяем успешный переход на страницу политики конфиденциальности")
    public MainPage checkOpenPrivacyPolicyTerms() {
        privacyPolicyTitle.shouldHave(text(privacyPolicyTitleName));
        return this;
    }
}
