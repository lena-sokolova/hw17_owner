package com.afterlogic.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchDocumentationPage {

    String documentationList = "Online documentation";
    String searchKey = "Two-factor";
    String searchResultText = "Two-factor authentication";

    SelenideElement
            supportTab = $(".item106"),
            documentationListLink = $("[href='/docs']"),
            auroraDocumentationLink = $("a[href='/docs/aurora/']"),
            searchInput = $("#search_input"),
            searchResult = $("#j1_42_anchor"),
            searchResultTitle = $("h1.title");

    @Step("Открываем главную страницу")
    public SearchDocumentationPage openPage() {
        open(baseUrl);
        sleep(2000);
        return this;
    }

    @Step("Переходим в раздел онлайн документации")
    public SearchDocumentationPage openDocumentationList() {
        supportTab.hover().$(byText(documentationList)).hover();
        documentationListLink.click();
        return this;
    }

    @Step("Переходим в раздел документации продукта Aurora Corporate")
    public SearchDocumentationPage openAuroraDocumentation() {
        auroraDocumentationLink.click();
        return this;
    }

    @Step("Вводим запрос в поисковую строку")
    public SearchDocumentationPage searchDocumentation() {
        searchInput.click();
        searchInput.setValue(searchKey).pressEnter();
        return this;
    }

    @Step("Проверяем, что нужная статья документации найдена")
    public SearchDocumentationPage checkSearchResult() {
        searchResult.shouldHave(text(searchResultText));
        return this;
    }

    @Step("Переходим на страницу найденной статьи")
    public SearchDocumentationPage openSearchResult() {
        searchResult.click();
        return this;
    }

    @Step("Проверяем, что нужная статья документации открылась")
    public SearchDocumentationPage checkOpenedArticle() {
        searchResultTitle.shouldHave(text(searchResultText));
        return this;
    }
}
