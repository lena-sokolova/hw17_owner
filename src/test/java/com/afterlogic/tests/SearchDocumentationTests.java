package com.afterlogic.tests;

import com.afterlogic.pages.SearchDocumentationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SearchDocumentationTests extends TestBase {

    SearchDocumentationPage searchDocumentationPage = new SearchDocumentationPage();

    @Test
    @Tag("smoke")
    @DisplayName("Проверка поиска в документации продукта")
    void checkProductsTest() {
        searchDocumentationPage
                .openPage()
                .openDocumentationList()
                .openAuroraDocumentation()
                .searchDocumentation()
                .checkSearchResult()
                .openSearchResult()
                .checkOpenedArticle();
    }
}
