<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Management - Issue & Return</title>
    <link rel="stylesheet" href="IssueReturnBook.css">
</head>
<body>
    <header>
        <h1>Library Management - Issue & Return</h1>
    </header>
    <main>
       
        <!-- Return Book Form -->
        <section class="form-section">
            <h2>Return a Book</h2>
            <form action="returnBook" method="post">
                <input type="text" name="bookId" placeholder="Book ID" required>
                <button type="submit" class="btn">Return Book</button>
            </form>
        </section>
    </main>
    <footer>
        <p>&copy; 2024 Library Management System. All rights reserved.</p>
    </footer>
</body>
</html>
