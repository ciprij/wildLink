<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="taglib.jsp"%>
<c:set var="title" value="WildLink" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html>

    <body class="bg-white">

        <div class="container my-5">

            <!-- Hero Image -->
            <div class="text-center mb-4">
                <img src="kalen-emsley-Bkci_8qcdvQ-unsplash.jpg"
                     class="img-fluid rounded shadow"
                     alt="Mountain view showcasing an adventurous landscape"
                     style="max-width: 60%; margin-top: 24px;">
            </div>

            <!-- Welcome Card -->
            <div class="card shadow-sm border-0 bg-light mb-4">
                <div class="card-body text-center px-5 py-4">
                    <h2 class="card-title">Welcome to a community of outdoor enthusiasts</h2>
                    <p class="card-text mt-3">
                        WildLink is a social network built for outdoor enthusiasts like climbers,
                        thru-hikers, backpackers, and mountaineers. Connect with fellow adventurers,
                        share your experiences, discover new trails, and plan your next great expedition.
                        Whether you're tackling rugged peaks or exploring scenic backcountry routes,
                        WildLink is your hub for inspiration, knowledge, and community.
                    </p>
                    <p class="card-text mt-3">
                        Join a community of like-minded explorers and share the thrill of adventure. From trail tips to gear recommendations,
                        discover new places, meet fellow adventurers, and embark on your next journey with us.
                    </p>
                    <form action="${pageContext.request.contextPath}/logIn" class="d-inline-block mt-3">
                        <button type="submit" name="submit" value="signUp" class="btn btn-primary btn-lg">
                            Sign-up and join today!
                        </button>
                    </form>
                </div>
            </div>

            <!-- View Users Section -->
            <div class="text-center mb-4">
                <h4>See our growing list of users!</h4>
                <p class="mt-2">Explore profiles of fellow adventurers who share your passion for the great outdoors. Whether you’re looking for hiking partners or just want to learn from others’ journeys, you’ll find plenty of inspiration here.</p>
                <form action="${pageContext.request.contextPath}/searchUser" class="d-inline-block mt-2">
                    <button type="submit" name="submit" value="viewAll" class="btn btn-outline-primary btn-sm">
                        View all users
                    </button>
                </form>
            </div>

            <!-- Weather Search Card -->
            <div class="card shadow-sm border-0 bg-light mb-4">
                <div class="card-body text-center px-4 py-4">
                    <h4 class="card-title">Do you know what the weather is like for your next adventure?</h4>
                    <p class="card-text">Plan ahead and make sure you’re ready for any weather conditions during your outdoor expeditions. Whether you're climbing mountains, hiking through forests, or camping under the stars, knowing the weather is crucial!</p>
                    <form action="WeatherSearch" method="get" class="row g-3 justify-content-center mt-3">
                        <div class="col-auto">
                            <label for="location" class="visually-hidden">City or Zip</label>
                            <input type="text" id="location" name="location" class="form-control" placeholder="City or ZIP" required>
                        </div>
                        <div class="col-auto">
                            <button type="submit" class="btn btn-primary mb-1">Get Weather</button>
                        </div>
                    </form>

                    <!-- Weather Result -->
                    <c:if test="${not empty weatherData}">
                        <hr class="my-4 border border-primary border-3 opacity-75">
                        <h5>Weather for ${weatherData.location.name}</h5>
                        <p><strong>Temperature:</strong> ${weatherData.current.tempF} °F</p>
                        <p><strong>Condition:</strong> ${weatherData.current.condition.text}</p>
                        <p><strong>Wind:</strong> ${weatherData.current.windMph} mph from the ${weatherData.current.windDir}</p>
                        <p><strong>Humidity:</strong> ${weatherData.current.humidity}%</p>
                    </c:if>
                </div>
            </div>

            <!-- Final Call to Action -->
            <div class="text-center my-4">
                <h4>Ready for your next adventure?</h4>
                <p>Start connecting, planning, and adventuring today! Join our community, post your stories, and always be prepared with the latest weather updates.</p>
                <a href="addPost.jsp" class="btn btn-primary btn-lg">Start Posting Your Adventures!</a>
            </div>

        </div>

    </body>


</html>