<%-- 
    Document   : viewnote.jsp
    Created on : 30-Sep-2022, 12:05:22 AM
    Author     : Hashem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper!</h1>
        <h2> View Note</h2
        <form method="POST" action="note?edit">
            <label>Title:</label>
        
        ${note.title}
        <label>Contents: </label>
        <br>
        ${note.content}
        </form>
        <a href="note?edit"> Edit Note </a> 
    </body>
</html>
