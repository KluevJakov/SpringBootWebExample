# Задача на валидацию

1. Создаем DTO:

```
{
    "id" : "cfc0b21c-9c2c-4b4f-80b2-1c9c2c0b4f91",
    "age" : 21,
    "name" : "Иван",
    "activated": true    
}
```

2. Сделать ручку создания POST /users

id - not null
age > 18
name - not empty

если валидация успешная вывести OK в консоль
Вернуть 200 OK с пустым телом HTTP ответа

(spring-boot-starter-validation)

3. При ошибках валидации возвращать ErrorDto:
```
{
    "message" : "Описание ошибки"  
}
```
(controller advisor)