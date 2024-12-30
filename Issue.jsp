<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management - Issue Book</title>
    <link rel="stylesheet" href="IssueReturnBook.css">
</head>
<body>
    <header>
        <h1>Library Management - Issue Book</h1>
    </header>
    <main>
        

        <!-- Issue Book Form -->
        <section class="form-section">
            <h2>Issue a Book</h2>
            <form action="issueBook" method="post">
                <input type="text" name="bookId" placeholder="Book ID" required>
                <input type="text" name="userId" placeholder="User ID" required>
                <button type="submit" class="btn">Issue Book</button>
            </form>
        </section>
