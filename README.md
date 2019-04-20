# Подписчик на новости

Реализация подписчика на новости от сервера [Newsletter](https://github.com/z-ank/newsletter).

## Быстрый запуск

Для запуска выполняем команду `./gradlew run --args='server port'` с передачей параметров имени сервера и номера порта, например:
`./gradlew run --args='localhost 5678'`

## Сборка

Для сборки проекта выполняем команду `./gradlew build`. Артефакт находится в каталоге `build/libs`.
Запуск выполняется командой `java -jar build/libs/news-subscriber-... .jar server port`, где server - имя сервера, port - номер порта.
Например `java -jar build/libs/news-subscriber-1.0.jar localhost 5678`
