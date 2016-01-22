<%--
  Created by IntelliJ IDEA.
  User: pghoo
  Date: 18/01/2016
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/send" method="post">
    <label for="msg">Chat:</label>
    <input id="msg" type="text" name="msg"/>
    <button class="btn btn-success" type="submit"></button>
  </form>
  </body>
</html>
