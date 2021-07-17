
# qa_guru_at_final_project
# Автотесты на https://m2.ru/

![Intelij_IDEA](src/test/resources/files/icons/Intelij_IDEA.png)![Java](src/test/resources/files/icons/Java.png)![Selenide](src/test/resources/files/icons/Selenide.png)![Selenoid](src/test/resources/files/icons/Selenoid.png)![Gradle](src/test/resources/files/icons/Gradle.png)![JUnit5](src/test/resources/files/icons/JUnit5.png)![Allure Report](src/test/resources/files/icons/Allure_Report.png)![AllureTestOps](src/test/resources/files/icons/AllureTestOps.png)![Github](src/test/resources/files/icons/Github.png)![Jenkins](src/test/resources/files/icons/Jenkins.png)![Rest-Assured](src/test/resources/files/icons/Rest-Assured.png)![Telegram](src/test/resources/files/icons/Telegram.png)![Jira](src/test/resources/files/icons/Jira.png)

IntelliJ IDEA, Java, Selenide, Selenoid, Gradle, JUnit5, Allure Report, Allure TestOps, Github, Jenkins, Rest-Assured,
Telegram (notifications), Jira.

# Реализованы проверки:
В реализации использованы разные подходы проектирования, позволяющие достичь разного представления в отчетах
### UI
- Авторизация пользователя с верными данными
- Авторизация пользователя с неверным паролем
- Поиск квартриры по заданным параметрам
- Использование сервиса оценки квартиры
- Отображение разделов на главное странице

### API
- Проверка на получениие имени 
- Проверка нполучение информации общего колличества
- Проверка на получение информации о массе
- Проверка на получение информации о росте

### Команда для запуска из терминала
Локально должны быть заданы параметры в local.properies, app.properties
```
gradle clean
```
Для запуска в несколько потоков
```
gradle clean -Dthreads=3
```
### Видео о прохождении тестов
![Selenoid](src/test/resources/files/run_test.gif)

### Запуск в Jenkins
Статистика по запускам
![Jenkins](src/test/resources/files/Jenkins.png)

### Отчёт в Allure Report
![Allure](src/test/resources/files/Allure.png)

### Хранение тест-кейсов в Allure TestOps
Ручные и автотесты
![Allure](src/test/resources/files/AllueTestCases.png)
Ручной тест
![Allure](src/test/resources/files/SampleManualCase.png)
Автоматизированный тест
![Allure](src/test/resources/files/AutomatedTest.png)
Основной дашборд для отслеживания
![Allure](src/test/resources/files/AllureBaseDashboard.png)
Дашборд по разным типам тестов
![Allure](src/test/resources/files/AllureTestsVariants.png)
Дашборд по команде
![Allure](src/test/resources/files/Allure_team.png)
Результат запуска ланча
![Allure](src/test/resources/files/LaunchResults.png)

### В качестве багтрекера использовалась Jira, у которой была настроена интеграция с Allure TestOps
![Jira](src/test/resources/files/Jira.png)

### Уведомления в Telegram
![Telegram](src/test/resources/files/Telegram.png)
