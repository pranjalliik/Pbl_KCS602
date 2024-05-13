<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard with Side Navigation</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

</head>
<body class="bg-gray-100 flex flex-rows">

<!-- Sidebar -->
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
                <a href="#" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Update Student</a>
            </li>
            <li>
                <a  href="allRooms.jsp" class="block p-3 transition duration-300 ease-in-out hover:bg-gray-700">Rooms</a>
            </li>

        </ul>
    </nav>
</div>

<!-- Main Content -->
<div class="flex-grow">   
    
    <div class="flex justify-center pt-12 pb-6 bg-gray-400	">
        <div class="font-bold text-xl mr-6"> Student Leaving</div>

    </div>
<div class="mb-8 ml-6 mt-8 flex gap-x-10">    <form id="searchForm">
        <label for="rollNo">Roll Number:</label>
        <input type="text" id="rollNo" name="rollNo" required>
        <input type="button" value="Search" class="bg-green-700 p-2 text-white rounded-lg" onclick="getStudentDetails()">
    </form>

    <form id="deleteForm" action="/client/deleteStudent" method="post" >
        <input type="text" id="deleteRollNo" name="rollNo" placeholder="rollNo" >
        <input type="text" id="deleteRoomNo" name="roomNo" placeholder="roomNo" >
        <button type="submit" class="bg-red-800 text-white p-2 rounded-lg" >Delete Student</button>
    </form>
</div>

<div id="studentDetails" class="ml-10">

</div>

</div>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    function getStudentDetails() {
        var rollNo = $("#rollNo").val();

        $.ajax({
            type: "GET",
            url: "/client/getStudent", 
            data: { rollNo: rollNo },
            success: function(response) {
                $("#studentDetails").html(response);
            },
            error: function(xhr, status, error) {
                console.error("Error making AJAX request:", error);
            }
        });
    }
</script>


</body>
</html>
