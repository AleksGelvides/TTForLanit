# Тестовое задание от Ланит
***
Тестовое задание: [Задание ЛАНИТ Алексей](https://docs.google.com/document/d/1cxrfS9zFdvB6CIgnKb5KzDwiKwqN_LLXpaJ7X6ckfvI/edit?usp=sharing)

***

## Зависимости

* Java 17
* SpringBoot 2.7.2
* Maven 3.8.6
* Docker 4.9.1
***

## Запуск проекта

#### Ручной запуск.
1) Скопируйте проект на свой ПК и перейдите в корневой каталог проекта.
2) В файле `src/main/resources/application.yaml` пропишите пути к своей базе данных.
3) Выполните команды:
   1) `mvn validate compile package -DskipTests=true`
   2) `java -jar target/ttforlanit-0.0.1-SNAPSHOT.jar`

#### Автоматический запуск в Docker

1) Windows: запустите `autodeploy.cmd`
2) Linux или MacOS: запустите `autodeploy.sh`

**Обратите внимание:** 
* Для автоматического запуска приложения, Docker обязательно должен быть запущен.
* По умолчанию используется порт 8080.
* Код не покрыт тестами и именно по этому они пропускаются командой `-DskipTests=true`

***

## Описание проекта

Данный артефакт принимает, валидирует и сохраняет сущности в базу данных. Передача данных осуществляется посредством **REST API**.

**Обратите внимание:** База данных по умолчанию не заполнена.
### Основные типы сущностей принимаемые приложением:
#### Пример сущности person:
```
{
    "id": 2,
    "name": "Aleksey",
    "birthdate": "20.12.2000"
}
```
#### Пример сущности car:
```
{
    "id":1,
    "model":"mersedes-2109",
    "horsepower": 10,
    "ownerid" : 2
}
```
**Обратите внимание:** каждое поле валидируется и отдавать данные необходимо согласно следующим критериям:

**Критерий для Person:**
```
{
    "id": long (NotNull, id>0),
    "name": String (NotNull, lenght>0),
    "birthdate": Date (dd.MM.yyyy)
}
```
**Критерий для Car:**
```
{
    "id": long (NotNull, id>0),
    "model": String (NotNull, lenght>0, "VENDOR"-"MODEL"),
    "horsepower": int (NotNull, horsepower>0),
    "ownerid" : long (NotNull, id>0)
}
```

### HTTP запросы к серверу:
**Обратите внимание:** все `HTTP` запросы взяты из Postman
#### Сохранение сущности Person:
```
POST /person/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 73

{
    "id": 2,
    "name": "Aleksey",
    "birthdate": "20.12.2000"
}
```
Ответ сервера:
```
HTTP response: 200
body: "Пользователь успешно сохранен" 
```

#### Сохранение сущности CAR:
```
POST /car HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 89

{
    "id":1,
    "model":"mersedes-2109",
    "horsepower": 10,
    "ownerid" : 2
}
```
Ответ сервера:
```
HTTP response: 200
body: "Автомобиль успешно сохранен" 
```

#### Получение информации о пользователе по ID:
```
GET /personwithcars?personId=2 HTTP/1.1
Host: localhost:8080
```
Ответ сервера:
```
HTTP response: 200
body: {
    "id": 2,
    "name": "Aleksey",
    "birthdate": "20.12.2000",
    "cars": [
        {
            "id": 1,
            "model": "mersedes-SL123",
            "horsepower": 10,
            "ownerid": 2
        },
        {
            "id": 2,
            "model": "Lada-2110",
            "horsepower": 105,
            "ownerid": 2
        },
        {
            "id": 3,
            "model": "BMW-X33",
            "horsepower": 320,
            "ownerid": 2
        }
    ]
}
```
#### Получение статистики по пользователям и автомобилям:
```
GET /statistic HTTP/1.1
Host: localhost:8080
```
Ответ сервера:
```
HTTP response: 200
body: {
    "personcount": 3,
    "carcount": 3,
    "unicvendorcount": 1
}
```
#### Удаление всех сущностей из базы данных:
```
GET /delete HTTP/1.1
Host: localhost:8080
```
Ответ сервера:
```
HTTP response: 200
body: 
```

## Как это работает
Валидация правильности ввода полей производится внутри сущностей DTO.

Валидация по дублям производится на уровне сервисного слоя.

Статистика собирается кастомными SQL запросами из репозиториев Car и Person, после чего формируется объект `Statistic` и возвращается в `ResponseEntity<?>`.




