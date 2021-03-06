<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Форум job4j. Главная</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <h4>Форум job4j. Список тем.</h4>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th><input type="button" value="Добавить тему" onclick="window.location.href = '/edit'"/></th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>Тема</th>
                <th>Описание</th>
                <th>Создана</th>
                <th>Update</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post">
                <c:url var="updateButton" value="/edit">
                    <c:param name="id" value="${post.id}"/>
                </c:url>
                <c:url var="goToMessages" value="/post">
                    <c:param name="postId" value="${post.id}"/>
                </c:url>
                <tr>
                    <td><a href="${goToMessages}"><c:out value="${post.name}"/></a></td>
                    <td><c:out value="${post.desc}"/></td>
                    <td><fmt:formatDate  value="${post.created}" pattern="dd-MM-yyyy"/></td>
                    <td><input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/></td>
                </tr>
            </c:forEach>
            <tr>
                <th><input type="button" value="Выйти" onclick="window.location.href = '/logout'"/></th>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
