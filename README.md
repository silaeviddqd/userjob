# Тестовое задание

## Инструкция по запуску

- В корневой папке проекта `docker compose up -d`
- `cd backed`
- `mvn flyway:baseline`
- `mvn flyway:migrate`
- `mvn clean compile`
- `Запустить модуль eureuka-server`
- `Запустить модуль backend`

## Что улучшил бы

1. Тесты
2. Валидация данных
3. Создал бы корневной pom.xml файл

## Как проверить

### POST запрос
```
curl --location --request POST 'http://127.0.0.1:8769/api/user/job/create-userjob' \
--header 'Content-Type: application/json' \
--data-raw '{
    "company": {
        "companyName": "Webest",
        "description": "Лучшая компания в мире! (по мнению Ивана)",
        "isActivity": true
    },
    "user": {
        "id": 5,
        "familyName": "Силаев",
        "middleName": "Анатольевич",
        "firstName": "Иван",
        "birthday": "1993-04-17",
        "gender": "MALE",
        "age": "30",
        "description": "Лучший работник в мире! (по мнению Ивана)",
        "isBlocked": false
    },
    "description": "Лучшая работа в мире!)",
    "isActivity": true
}'
```
### PATCH запрос
```
curl --location --request PATCH 'http://127.0.0.1:8769/api/user/job/create-userjob' \
--header 'Content-Type: application/json' \
--data-raw '{
    "company": {
        "id": 1,
        "companyName": "Webest",
        "description": "Лучшая компания в мире! (по мнению Ивана)",
        "isActivity": true
    },
    "user": {
        "id": 1,
        "familyName": "Silaev",
        "middleName": "Anatolevich",
        "firstName": "Ivan",
        "birthday": "1993-04-17",
        "gender": "MALE",
        "age": "30",
        "description": "Лучший работник в мире! (по мнению Ивана)",
        "isBlocked": false
    },
    "description": "Лучшая работа в мире!)",
    "isActivity": true
}'
```
### GET запрос
```
curl --location --request GET 'http://127.0.0.1:8769/api/user/job/get-userjob?idCompany=1'
```

#### Спасибо за интересное тестовое задание :)