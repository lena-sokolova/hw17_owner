# Проект по автоматизации тестирования сайта Afterlogic.com
## :scroll: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Интеграция с Telegram](#-интеграция-с-telegram)
- [Пример видео запуска тестов в Selenoid](#film_strip-пример-видео-запуска-тестов-в-selenoid)

## :computer: Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/icons/Java.svg">
<img width="6%" title="Selenide" src="media/icons/Selenide.svg">
<img width="6%" title="Selenoid" src="media/icons/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/icons/Allure_Report.svg">
<img width="5%" title="Allure TestOps" src="media/icons/AllureTestOps.svg">
<img width="6%" title="Gradle" src="media/icons/Gradle.svg">
<img width="6%" title="JUnit5" src="media/icons/JUnit5.svg">
<img width="6%" title="Jenkins" src="media/icons/Jenkins.svg">
<img width="6%" title="Telegram" src="media/icons/Telegram.svg">
<img width="5%" title="Jira" src="media/icons/Jira.svg">
</p>

Тесты написаны на языке программирования <code>Java</code> с использованием фреймворков <code>JUnit 5</code> и [Selenide](https://selenide.org/). Для автоматизированной сборки проекта используется <code>Gradle</code>.
Для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/).
Удаленный запуск тестов осуществляется в <code>Jenkins</code>. Далее формируется Allure-отчет и с помощью бота отправляется в <code>Telegram</code>.
Настроена интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Allure-отчет включает в себя:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения теста.

## :arrow_forward: Запуск автотестов

### Локальный запуск тестов из терминала
```
gradle clean test -Denv=local
```
### Удаленный запуск тестов из терминала
```
gradle clean test -Denv=remote
```
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/icons/Jenkins.svg"> Сборка в Jenkins
```
clean
${TASK}
-DbaseUrl=${BASE_URL}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DscreenResolution=${BROWSER_SIZE}
-DremoteUrl=${REMOTE_URL}
```
### Параметры сборки
- <code>BROWSER</code> – браузер (по умолчанию chrome).
- <code>BROWSER_VERSION</code> – версия браузера (по умолчанию 100.0).
- <code>BROWSER_SIZE</code> – размер окна браузера (по умолчанию 1920x1080).
- <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
- <code>VIDEO_STORAGE</code> - адрес удаленного сервера, по которому можно получить видео.

Для запуска [сборки](https://jenkins.autotests.cloud/job/hw15_afterlogicTests/) необходимо перейти в раздел <code>Собрать с параметрами</code>, указать нужные параметры и нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="media/screenshots/job.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/icons/Allure_Report.svg"> Отчет о результатах тестирования в Allure Report

### Основная страница отчета

<p align="center">
<img title="Allure Overview" src="media/screenshots/allureReport.png">
</p>

### Тест-кейсы

<p align="center">
<img title="Allure Overview" src="media/screenshots/allureReportSuites.png">

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/icons/AllureTestOps.svg"> Интеграция с Allure TestOps

### Dashboards

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screenshots/testOps_dash.png">
</p>

### Тест-кейсы

<p align="center">
<img title="Allure TestOps testcase" src="media/screenshots/testOps_test.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Jira" src="media/icons/Jira.svg"> Интеграция с Jira

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screenshots/jira.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Интеграция с Telegram

После завершения сборки бот автоматически отправляет сообщение в <code>Telegram</code> с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screenshots/telegram.png">
</p>


##  :film_strip: Пример видео запуска тестов в Selenoid
В отчетах Allure для каждого теста прикреплен скриншот последнего шага и видео прохождения теста.

<p align="center">
  <img title="Selenoid Video" src="media/screenshots/video.gif">
</p>