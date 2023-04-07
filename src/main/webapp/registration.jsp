<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.nio.file.Files,java.io.File" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Form</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-color: #000;
            padding-bottom: 100px;
        }
        .form{
            position: absolute;
      	    top: 50%;
      	    left: 50%;
      	    transform: translate(-50%,-50%);
      	    background: rgba(0,0,0,.7);
        }
        .form h1 {
            font: 300 60px 'Oswald', sans-serif;
    	    margin: 30px 100px;
    	    padding: 0;
    	    text-align: center;
    	    color: #fff;
    	    font-size: 30px;
    	    text-transform: uppercase;
        }
        .input-form {
	        margin: 15px 40px;
	        text-align: center;
        }
        .input-form input {
            	padding: 10px;
            	width: 100%;
            	color: #fff;
            	font-size: 20px;
            	background: none;
            	outline: none;
            	border: 1px solid #fff;
            	box-sizing: border-box;
        }
        .input-form input[type="text"]:focus, .input-form input[type="password"]:focus {
            border: 1px solid #0fc3f5;
        }
        .input-form input[type="submit"] {
	        margin-top: 20px;
	        color: #004d66;
	        font-weight: bold;
	        text-transform: uppercase;
	        border: none;
	        background: #e4ebf2;
	        transition: .3s;
        }
        .input-form input[type="submit"]:hover {
	        background: #4442db;
        }
        .form a {
	        display: block;
	        margin-top: 20px;
	        padding: 0 0 30px;
	        text-align: center;
	        color: #fff;
	        text-decoration: none;
	        transition: .3s;
        }
        .form a:hover {
	        color: #0fc3f5;
        }
        .button{
            margin-top: 20px;
            color: #004d66;
            font-weight: bold;
            text-transform: uppercase;
            border: none;
            background: #e4ebf2;
            transition: .3s;
        }

        .send-button {
            margin-top: 15px;
            height: 34px;
            width: 400px;
            overflow: hidden;
            transition: all .2s ease-in-out;
        }

        .alt-send-button {
            width: 400px;
            height: 34px;
            transition: all .2s ease-in-out;
        }
        .send-text {
            display: block;
            margin-top: 10px;
            font: 700 12px 'Lato', sans-serif;
            letter-spacing: 2px;
        }
    </style>
  </head>
  <body>
    <main>
        <div class="form">
    		<h1>Регистрация</h1>
            <form action="./registration" method="post" accept-charset="UTF-8">
    		<div class="input-form">
    			<input type="text" name="login" placeholder="Логин" required>
    		</div>
    		<div class="input-form">
                <input type="email" name="email" placeholder="Почта" required>
            </div>

    		<div class="input-form">
    			<input type="password" name="password" placeholder="Пароль" required autocomplete="current-password">
    		</div>
    		<div>
                <button class="btn btn-primary btn-block" type="submit">
                    <div class="alt-send-button">
                       <span class="send-text">ЗАРЕГИСТРИРОВАТЬСЯ</span>
                    </div>
                </button>
            </div>
             </form>
    		<a href="./authorization" class="login">уже есть аккаунт</a>
    	</div>
    </main>
  </body>
</html>