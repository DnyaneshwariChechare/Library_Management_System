<!DOCTYPE html>
<html>
<head>
    <title>Authors By Book</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            margin: 20px auto;
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 50%;
            margin: 20px auto;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">Find Authors By Book</h1>
    <form method="post" action="AuthorsByBookServlet">
        <label for="bookTitle">Enter Book Title:</label>
        <input type="text" id="bookTitle" name="bookTitle" required>
        <button type="submit">Search</button>
    </form>
</body>
</html>
