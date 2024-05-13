<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard with Side Navigation</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex flex-rows">

<div class="bg-gray-800 text-white h-screen w-60 fixed">
    <div class="p-4">
        <h1 class="text-2xl font-bold">Dashboard</h1>
    </div>
    <nav>
        <ul class="space-y-4 mt-4">
            <li>
                <a href="home.jsp" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Register Student</a>
            </li>
            <li>
                <a  href="update.jsp" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Update Student</a>
            </li>
            <li>
                <a  href="allRooms.jsp" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Rooms</a>
            </li>
          
        </ul>
    </nav>
</div>


    
        <div class="ml-72 mb-30">
            <h2 class="text-2xl font-bold mb-6 mt-10">Employee Registration Form</h2>
    
            <form  action="/client/employeeRegistration" method="post" >
                <div class="mb-4">
                    <label for="name" class="block text-gray-600 font-medium">Name:</label>
                    <input type="text" id="name" name="name" class="w-full p-2 border rounded">
                </div>
    
                <div class="mb-4">
                    <label for="year" class="block text-gray-600 font-medium">Role</label>
                    <input type="text" id="role" name="role" class="w-full p-2 border rounded">
                </div>
    
                <div class="mb-4">
                    <label for="empNo" class="block text-gray-600 font-medium">Employee No:</label>
                    <input type="text" id="empNo" name="empNo" class="w-full p-2 border rounded">
                </div>
    
                <div class="mb-4">
                    <label for="mobileNo" class="block text-gray-600 font-medium">Mobile No:</label>
                    <input type="text" id="mobileNo" name="mobileNo" class="w-full p-2 border rounded">
                </div>
    

    
    

    
                <div class="mt-6">
                    <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded">Submit</button>
                </div>
            </form>
        </div>
    

    
</main>

</body>
</html>
