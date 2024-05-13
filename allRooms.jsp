<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard with Side Navigation</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100 flex flex-cols">
    <div class="bg-gray-800 text-white h-screen w-60 ">
        <div class="p-4">
            <h1 class="text-2xl font-bold">Dashboard</h1>
        </div>
        <nav>
            <ul class="space-y-4 mt-4">
                <!-- Navigation Items -->
                <li>
                    <a href="home.jsp" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Register Student</a>
                </li>
                <li>
                    <a  href="update.jsp" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Update Student</a>
                </li>
                <li>
                    <a  href="/client/getrooms" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Rooms</a>
                </li>
                
            </ul>
        </nav>
    </div>
    <div id="roomsTable" class="h-full p-6 w-full mr-24 rounded-lg bg-gray-200 ml-24 mt-8"></div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $(document).ready(function() {
        loadRooms();
        function loadRooms() {
            $.ajax({
                type: "GET",
                url: "/client/getrooms", // Replace with the actual servlet URL
                success: function(response) {
                    $("#roomsTable").html(response);

                },
                error: function(xhr, status, error) {
                    console.error("AJAX Error: " + status, error);
                    console.log('hiiii')

                }
            });
        }
    });
</script>
</html>