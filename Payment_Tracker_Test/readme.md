My_project_and_tests

1. Для запуска программы необходимо, в пункте главного меню среды разработки "Intellij IDEA", по нажатию на кнопку "Run" выбрать в раскрывающемся списке пункт "Edit Configuration". Откроется окно с полями, где нжно отыскать поле "Program arguments" и написать там имя файла c расширением "Accounts.txt" из которого будут браться первоначальные данные.

Run -> Edit Configuration -> Program arguments -> "Accounts.txt"

После чего выбрать класс PaymentTreckerDemo. В этом классе находится метод main, который является точкой входа в программу.

2. При первом запуске программы я рекомендую использовать значения из примера в задании: 

	USD 1000

	HKD 100

	USD -100

	RMB 2000

	HKD 200

Я бы рекомендовал при кадом новом запуске программы в текстовый файл Accounts.txt вставлять эти коды валюты и значения.
Также можно использовать свои коды валют и значения. Но коды валют должны быть строго в верхнем регистре и не длиннее трех символов.