<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication Failed</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-100 h-screen flex items-center justify-center">

    <div class="bg-white p-8 rounded shadow-md max-w-md w-full">
        <h2 class="text-2xl font-bold mb-4">Authentication Failed</h2>
        <p class="text-red-500 mb-4">Invalid username or password. Please try again.</p>
        <a href="/client" class="text-blue-500 hover:underline">Go back to Login</a>
    </div>

</body>
</html>
