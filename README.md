[![Build Status](https://www.travis-ci.com/AzatIdrisov/job4j_forum.svg?branch=main)](https://www.travis-ci.com/AzatIdrisov/job4j_forum)

# Проект "Форум"

[Запуск на heroku](https://tranquil-hollows-70376.herokuapp.com/)

## Технологии
* Spring(Boot, Security, Data, MVC)
* PostgreSQL
* JSP/JSTL
* Junit tests(Spring Test)

## Описание проекта

Spring-boot приложение "Форум"\
Хранение данных с помощью Spring Data\
Используемая БД - PostgreSql\
Front-end на JSP.

## Архитектура

Проект разделен на слои:

1. Конфигурация SpringBoot\
    1.1 [Main](src/main/java/ru/job4j/forum/Main.java) - Главный класс с аннотацией @SpringBootApplication для запуска приложения.\
    1.2 [WebSecurity](src/main/java/ru/job4j/forum/config/WebSecurity.java) - настройки авторизации через Spring Security.
   
2. Модели\
    2.1 [Authority](src/main/java/ru/job4j/forum/model/Authority.java) - роль пользователя(админ, пользователь)\
    2.2 [User](src/main/java/ru/job4j/forum/model/User.java) - пользователь\
    2.3 [Post](src/main/java/ru/job4j/forum/model/Post.java) - тема форума\
    2.4 [Message](src/main/java/ru/job4j/forum/model/Message.java) - сообщение в теме
   
3. Repository Spring Data\
    3.1 [AuthorityRepository](src/main/java/ru/job4j/forum/repository/AuthorityRepository.java) \
    3.2 [UserRepository](src/main/java/ru/job4j/forum/repository/UserRepository.java)\
    3.3 [PostRepository](src/main/java/ru/job4j/forum/repository/PostRepository.java)\
    3.4 [MessageRepository](src/main/java/ru/job4j/forum/repository/MessageRepository.java)
   
4. Сервисы\
    4.1 [PostService](src/main/java/ru/job4j/forum/service/PostService.java)\
    4.2 [MessageService](src/main/java/ru/job4j/forum/service/MessageService.java)
   
5. Контроллеры\
    5.1 [IndexControl](src/main/java/ru/job4j/forum/control/IndexControl.java) - контроллер для загрузки тем на главной странице\
    5.2 [LoginControl](src/main/java/ru/job4j/forum/control/LoginControl.java) - контроллер для страницы авторизации\
    5.3 [RegControl](src/main/java/ru/job4j/forum/control/RegControl.java) - контроллер для страницы регистрации\
    5.4 [PostControl](src/main/java/ru/job4j/forum/control/PostControl.java) - контроллер для создания/редактирования тем форму\
    5.5 [MessageControl](src/main/java/ru/job4j/forum/control/MessageControl.java) - контроллер для создания/редактирования/удаления сообщений в темах форума
   
6. View\
    6.1 [login.jsp](src/main/webapp/WEB-INF/views/login.jsp) - Страница авторизации\
    6.2 [reg.jsp](src/main/webapp/WEB-INF/views/reg.jsp) - Страница регистрации\
    6.3 [index.jsp](src/main/webapp/WEB-INF/views/index.jsp) - Главная страница\
    6.4 [post.jsp](src/main/webapp/WEB-INF/views/post.jsp) - Страница темы форума\
    6.5 [edit.jsp](src/main/webapp/WEB-INF/views/edit.jsp) - Страница редактирования темы форума\
    6.6 [message/edit.jsp](src/main/webapp/WEB-INF/views/message/edit.jsp) - Страница редактирования сообщения

## Тесты
Тесты на контроллеры(Junit, Spring Test)
1. [IndexControlTest](src/test/java/ru/job4j/forum/control/IndexControlTest.java)
2. [LoginControlTest](src/test/java/ru/job4j/forum/control/LoginControlTest.java)
3. [RegControlTest](src/test/java/ru/job4j/forum/control/RegControlTest.java)
4. [PostControlTest](src/test/java/ru/job4j/forum/control/PostControlTest.java)

## Контакты

Идрисов Азат

Java-разработчик

a.idrisov23@yandex.ru