<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Вход-выход</title>
 <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <form action="/get" method="GET">
    <p>Укажите год <input type="text" name="year"></p>
    <p>Укажите месяц <input type="text" name="month"></p>
    <p><input type="submit" value="Посмотреть"></p>
    </form>
    <h2></h2>
    <div class="table-wrapper">
    
        <table class="fl-table">
            <thead>
            <tr colspan="35">
                <th colspan="35">Таблица посещаемости</th>
            </tr>
            <tr>
                <th>ФИО</th>
                <th>-</th>
                <th>03.10</th>
                <th>04.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
                <th>05.10</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                    <tr>
                        <td rowspan="3">${user.FIO}</td>
                        <td>Вход</td>
                        <td>null</td>
                        <td>Null</td>
                        <td>Null</td>
                    </tr> 
                    <tr>
                        <td>Выход</td>
                        <td>Null</td>
                        <td>Null</td>
                        <td>Null</td>
                    </tr> 
                    <tr>
                        <td>Итог</td>
                        <td>Null</td>
                        <td>Null</td>
                        <td>Null</td>
                    </tr>
            </c:forEach> 
            <tbody>
        </table>
    </div>
</body>
</html>
