<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        /* Reset default browser styles */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            background-color: #f0f0f0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }

        /* Header styles */
        header {
            background-color: #c54651;
            color: white;
            padding: 10px 0;
            text-align: center;
        }

        header h1 {
            font-size: 2.5em;
            margin-bottom: 10px;
        }

        /* Main content styles */
        main {
            padding: 20px 0;
        }

        section {
            background-color: #fff;
            margin-bottom: 20px;
            padding: 20px;
        }

        section h2 {
            font-size: 1.8em;
            margin-bottom: 10px;
        }

        section label {
            color: #000;
            display: block;
            margin-bottom: 8px;
            font-size: 1em;
        }

        section input[type="text"], section input[type="password"] {
            padding: 10px;
            width: 60%;
            max-width: 300px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 1em;
            display: block;
            margin: 0 auto 20px auto;
        }

        section input[type="submit"] {
            padding: 10px 20px;
            background-color: #0f70b5;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }

        section input[type="submit"]:hover {
            background-color: #0d5c9e;
        }

        /* Footer styles */
        footer {
            background-color: #15b93b;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <header>
        <div class="container">
            <h1>GenrePick Login Form</h1>
        </div>
    </header>

    <main>
        <center>
        <section>
            <h2>Login Here!</h2>
           <form action="LoginServlet" method="post">
    <label for="txtName">Enter Name:</label>
    <input type="text" id="txtName" name="txtName" required>
    
    <label for="txtPwd">Enter Password:</label>
    <input type="password" id="txtPwd" name="txtPwd" required>
    
    <button type="submit">Login</button>
    
</form>

        </section>
        </center>
    </main>

    <footer>
        <div class="container">
            <p>&copy; 2024 GenrePick. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>
