# JavaSE-Day11-Homework4
Homework 4.
Домашняя работа на срд, чтв.

Создать ветку от существующего проекта gitHub: https://github.com/AndesTechConsulting3/JavaSE-Day11-Homework4.git
Имя ветки должно содержать строку rfb, например VasilyPetrov-rfb-branch-home4.

Написать функциональный тест для
классов счетов DebitAccount, CreditAccount
используя JUnit4.

Можно перенести часть кода из предыдущей ДР или подключить
её в проект как библиотеку (через  раздел зависимости в pom.xml).

Создать два тестовых класса: DebitAccTest, CreditAccTest.
Подумайте, можно ли использовать аннотацию @BeforeClass
для инициализации данных...

Создать тестовые методы:

createAccountPositiveTest,
createAccountNegativeTest,

putPositiveTest,
putNegativeTest,

withdrawalPositiveTest,
withdrawalNegativeTest.

Все отрицательные тесты должны проходить при неудачном действии
со счётом, а положительные - когда операция со счётом успешна.

Создать категории IPositiveTest, INegativeTest.
Аннотировать соотв. методы нужными категориями.

Создать в среде IntelliJIDEA две конфигурации запуска тестов: для
положительных и отрицательных.

Протестировать и получить отчёт.

Сделать коммит и пуш Вашей ветки.
