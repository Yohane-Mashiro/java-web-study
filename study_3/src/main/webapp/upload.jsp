<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>文件上传实例</h1>
<form method="post" action="/study_3_war/upload_api" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile" /><br/><br/>
    <input type="submit" value="上传" />
</form>
</body>
</html>