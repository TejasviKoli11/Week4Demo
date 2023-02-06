<%-- 
    Document   : editnote
    Created on : 4 Feb, 2023, 9:45:10 PM
    Author     : Tejasvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit note</title>
    </head>
    <body>
        <form method="post" action="note?page=view">
        <h1>Simple Note Keeper</h1>
        Title: <input type="text" name="title" value="${note.title}"><br>
        Contents: <input type="text" name="contents" value="${note.contents}" ><br>
        <input type="submit" name = "submit" value="Save">
        </form>
    </body>
</html>
