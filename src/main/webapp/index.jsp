<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html>
<body>
<!-- Image with better alt description for accessibility -->
<img src="kalen-emsley-Bkci_8qcdvQ-unsplash.jpg" class="img-fluid rounded mx-auto d-block" alt="A breathtaking
        mountain view showcasing an adventurous landscape" style="max-width:60%;">

<!-- Container for introductory text -->
<div class="container-md justify-content-center border rounded bg-light my-4 p-4">
    <h2 class="text-center">Welcome to a community of outdoor enthusiasts!</h2>
    <p>WildLink is a social network built for outdoor enthusiasts like climbers,
        thru-hikers, backpackers, and mountaineers. Connect with fellow adventurers,
        share your experiences, discover new trails, and plan your next great expedition.
        Whether you're tackling rugged peaks or exploring scenic backcountry routes, WildLink
        is your hub for inspiration, knowledge, and community. Start your journey today!
    </p>
</div>

<!-- Section for viewing all users -->
<div class="container-md justify-content-center text-center">
    <h3>See our growing list of users!</h3>
    <!-- Adding Bootstrap classes to style the button -->
    <form action="${pageContext.request.contextPath}/searchUser">
        <button type="submit" name="submit" value="viewAll" class="btn btn-primary btn-lg mt-3">View all users</button>
    </form>
</div>
</body>
</html>