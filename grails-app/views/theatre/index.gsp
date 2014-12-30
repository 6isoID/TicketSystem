<!doctype html>
<html>
<head>
    <title></title>
    <!-- Angular app files
    ===================================================-->
    <asset:javascript src="app.js" />

    <!-- style shit =)
    ======================================-->
    <asset:stylesheet src="bootstrap.css" />
    <asset:stylesheet src="common.css" />
</head>

<body>

    <!-- Background
    ===========================-->
    <div class="background"></div>
    <div class="layer"></div>


    <!-- Navigation bar
    =================================================-->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">How do we see the DDD</a>
            </div>
            %{--<h2 class="text-center">Today in theatre</h2>--}%
        </div>
    </nav>

    <!-- Content
    ======================================================-->
    <div ng-controller="SessionController" class="container">
        <br />
        <br />
        <br />
        <!--TODO alignment-->




        <!-- Cinema list
        ==========================================================================================================-->
        <ul class="cinema-list list-unstyled">

            <!-- Cinema
            ========================================================-->
            <li class="cinema-container row" ng-repeat="cinema in cinemas">

                <!-- Poster
                ========================-->
                <img ng-src="{{'../assets/posters/' + cinema.name + '.jpg'}}" class="cinema-thumbnail col-lg-4">

                <!-- Right side
                ================-->
                <div class="col-lg-8">
                    <!-- Name
                    ===========================================-->
                    <h3 class="cinema-header">{{cinema.name}}</h3>

                    <!-- Duration
                    ===========================================-->
                    <b>Duration:</b> {{cinema.duration}}

                <!-- Description
                    ===========================================-->
                    <div class="description-container">
                        <b>Description:</b>
                        <span>{{cinema.description}}</span>
                        <br />
                        <br />

                    </div>

                    <!-- Sessions
                    ===========================================-->
                    <h4>Coming sessions:</h4>
                    %{--TODO sessions as buttons--}%
                    <ul class="session-list list-unstyled list-inline">
                        <li ng-repeat="session in cinema.sessions" class="session">
                            %{--<button><a href="#" class="">--}%
                            <h5>{{session.hall.name}}: {{session.time.time | date:'HH:mm'}}</h5>
                            %{--</a></button>--}%

                            <!-- Temporary hall view
                            ===================================-->
                            <div class="screen"></div>
                            <div ng-repeat="seat in session.rows">
                                <span ng-repeat="col in seat | orderBy: col.columnNum">
                                    <div id='{
                                    "session": {{session.id}},
                                    "rowNum": {{col.rowNum}},
                                    "columnNum": {{col.columnNum}}
                                    }' class="seatplace" ng-click="addToCart()" />
                                </span><br />
                            </div>
                        </li>

                    </ul>
                    <button ng-click="submitCart()" >Submit cart</button>
                </div>
            </li>

        </ul>


        <!-- TODO: http://getbootstrap.com/css/ -->

    </div>

</body>
</html>



