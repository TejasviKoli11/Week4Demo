<%-- 
    Document   : viewnote
    Created on : 4 Feb, 2023, 9:44:56 PM
    Author     : Tejasvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note</title>
    </head>
    <body>
        <form method="post" action="note?page=view">
        <h1>Simple Note Keeper</h1>
        <b>Title </b> : ${note.title}<br>
        <b>Contents</b> : ${note.contents}
        
        </form>
        <a href="note?page=edit">Edit</a> 
        
    </body>
</html>
