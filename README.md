# Тестовое задание: Сервис для извлечения N-го максимального числа из файла Excel

## Описание задания
Вам поручено создать сервис на Java с использованием Spring (любых версий), который должен выполнять следующие задачи:

1. Должен быть доступен Swagger для документации API.
2. В Swagger должен быть единственный контроллер с единственным методом.
3. Метод должен принимать на вход путь к локальному файлу в формате XLSX и число N.
4. В файле должны содержаться целые числа, расположенные в одном столбце.
5. Метод должен возвращать N-ное максимальное число из файла.
6. Для поиска нельзя использовать библиотечные функции, такие как сортировка массива; необходимо предложить и реализовать эффективный алгоритм.
7. Приложить инструкцию по сборке и запуску кода.

## Swagger
Документация API доступна по адресу: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Инструкция по сборке и запуску

### Требования
- Java 11 или выше
- Maven

### Сборка проекта
1. Клонируйте репозиторий на свой локальный компьютер:
   ```bash
   git clone <url_репозитория>
   cd <имя_директории>
   ```
2. Соберите проект с помощью Maven:
   ```bash
   ./mvn clean install
   ```

### Запуск сервиса
1. Запустите приложение с помощью Gradle:
   ```bash
   ./mvn spring boot run
   ```
2. После успешного запуска приложение будет доступно по адресу: http://localhost:8080

### Использование API
Для получения N-го максимального числа из файла Excel, отправьте GET-запрос на один из следующих эндпоинтов:
 - `/nth-max` - Использует собственную реализацию с массивом.

Пример запроса:
```http request
GET http://localhost:8080/nth-max?filePath=путь_к_файлу.xlsx&n=3
```
Где `filePath` — это путь к вашему XLSX файлу, а `n` — порядковый номер максимального числа.