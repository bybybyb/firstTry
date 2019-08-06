<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: demid5
  Date: 24.07.19
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сорсинг кандидатов на работу</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Сорсинг кандидатов на работу</h1>
<div id="blockCriteries">
<form action="/" method="POST">
    <p>В каких сайтах будем искать</p>
    <p><input type="checkbox" name="websait" value="HHRU">HH.RU   <input type="checkbox" name="websait" value="SuperJob"> SuperJob.ru   <input type="checkbox" name="websait" value="GorodRabot.ru">GorodRabot.ru</p>

    <br><br>
    Название профессии: <input name="profession" />
    <br><br>
    Образование: <select name="education">
    <option>не имеет значения</option>
    <option>высшее</option>
    <option>среднее</option>
</select>
    <br><br>
    Опыт работы: <select name="experience">
    <option>не имеет значения</option>
    <option>нет опыта</option>
    <option>От 1 года до 3 лет</option>
    <option>От 3 до 6 лет</option>
    <option>Более 6 лет</option>
</select>

    <br><br>
    Ключевые навыки:
    <p><input type="checkbox" name="skill" value="Java">Java
    <input type="checkbox" name="skill" value="Python">Python
    <input type="checkbox" name="skill" value="C++">C++
    <input type="checkbox" name="skill" value="C#">C#
    <input type="checkbox" name="skill" value="PHP">PHP</p>

    <p><input type="checkbox" name="skill" value="JavaScript">JavaScript
    <input type="checkbox" name="skill" value="HTML">HTML
    <input type="checkbox" name="skill" value="HTML5">HTML5
    <input type="checkbox" name="skill" value="CSS3">CSS3
    <input type="checkbox" name="skill" value="CSS">CSS</p>

    <p><input type="checkbox" name="skill" value="Android">Android</p>

    <p><input type="checkbox" name="skill" value="Spring Framework">Spring Framework
    <input type="checkbox" name="skill" value="Hibernate">Hibernate
    <input type="checkbox" name="skill" value="Git">Git</p>

    <p><input type="checkbox" name="skill" value="SQL">SQL
    <input type="checkbox" name="skill" value="MySQL">MySQL
    <input type="checkbox" name="skill" value="MS SQL">MS SQL
    <input type="checkbox" name="skill" value="PostgreSQL">PostgreSQL</p>

    <p><input type="checkbox" name="skill" value="Управление проектами">Управление проектами
        <input type="checkbox" name="skill" value="Работа в команде">Работа в команде</p>

    <p><input type="checkbox" name="skill" value="Английский язык">Английский язык</p>

    <p><input type="checkbox" name="skill" value="ООП">ООП
       <input type="checkbox" name="skill" value="Linux">Linux</p>

    <p><input type="checkbox" name="skill" value="Adobe Photoshop">Adobe Photoshop
       <input type="checkbox" name="skill" value="XML">XML</p>

    <p><input type="checkbox" name="skill" value="jQuery">jQuery
       <input type="checkbox" name="skill" value="Apache Maven">Apache Maven</p>

    <p><input type="checkbox" name="skill" value="Altassian Jira">Altassian Jira
        <input type="checkbox" name="skill" value="BootStrap">BootStrap</p>

    <p><input type="checkbox" name="skill" value="Ajax">Ajax
       <input type="checkbox" name="skill" value="REST">REST</p>

    <p><input type="submit" value="Поиск"></p>

</form>
</div>

<div id="resultLink">
    <p id="textResultLinks"> Список кандидатов на работу по заданным критериям: </p>
    <ol>
        <c:forEach var="per" items="${resultList}">
            <li> <a href=${per}>${per}</a> </li>
        </c:forEach>
    </ol>
</div>

</body>
</html>
