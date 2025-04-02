<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
        .login-container {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 3px;
        }
        .submit-btn {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .submit-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>管理员登录</h2>
        <form action="${pageContext.request.contextPath}/admin" method="post">
            <div class="form-group">
                <label for="admin">用户名：</label>
                <input type="text" id="admin" name="admin" required>
            </div>
            <div class="form-group">
                <label for="passwd">密码：</label>
                <input type="password" id="passwd" name="passwd" required>
            </div>
            <button type="submit" class="submit-btn">登录</button>
        </form>
    </div>
</body>
</html>
