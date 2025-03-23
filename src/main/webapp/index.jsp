<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html>

    <body>

        <img src="kalen-emsley-Bkci_8qcdvQ-unsplash.jpg" class="img-fluid rounded mx-auto d-block" alt="A breathtaking
                mountain view showcasing an adventurous landscape" style="max-width:50%; margin-top: 24px;">

        <div class="container-sm justify-content-center border rounded bg-light my-4 p-4">
            <h2 class="text-center">Welcome to a community of outdoor enthusiasts</h2>
            <p>WildLink is a social network built for outdoor enthusiasts like climbers,
                thru-hikers, backpackers, and mountaineers. Connect with fellow adventurers,
                share your experiences, discover new trails, and plan your next great expedition.
                Whether you're tackling rugged peaks or exploring scenic backcountry routes, WildLink
                is your hub for inspiration, knowledge, and community. Start your journey today!
            </p>
            <!-- TODO Update action to AWS Cognito -->
            <form action="#" class="text-center">
                <button type="submit" name="submit" value="signUp" class="btn btn-primary btn-lg mt-3">Sign-up and join today!</button>
            </form>
        </div>

        <div class="container-sm justify-content-center text-center">
            <h3>See our growing list of users!</h3>
            <form action="${pageContext.request.contextPath}/searchUser">
                <button type="submit" name="submit" value="viewAll" class="btn btn-primary btn-sm mt-1">View all users</button>
            </form>
        </div>

    </body>

</html>