<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-200 h-screen flex items-center justify-center">

    <div class="bg-white p-8 rounded shadow-md w-96">
        <h2 class="text-2xl mb-4 font-bold">Login</h2>

        <form action="/client/login" method="post">
            <div class="mb-4">
                <label for="username" class="block text-gray-600 font-medium">Username:</label>
                <input type="text" id="username" name="username" class="w-full p-2 border rounded" required>
            </div>

            <div class="mb-4">
                <label for="password" class="block text-gray-600 font-medium">Password:</label>
                <input type="password" id="password" name="password" class="w-full p-2 border rounded" required>
            </div>

            <div class="mt-6">
                <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded">Login</button>
            </div>
        </form>
    </div>

</body>
</html>

