<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form example with Java, Spring Boot, FreeMarker</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<h2>Handling Form Submission example with Java, Spring Boot, FreeMarker</h2>
<#if word?? >
Your submitted data<br>
First name: ${word.name}<br>
Last name: ${word.category}<br>
<#else>
<form action="/home" method="post">
    <input type="text" name="name">
    <br><br>

     <input type="text" name="category">
    <!--
          <select name="word.category">
              <option value="noun">Noun</option>
              <option value="verb">Verb</option>
              <option value="adjective">Adjective</option>
          </select>
          -->
    <input type="submit" value="Submit">


</form>
</#if>
</body>
</html>