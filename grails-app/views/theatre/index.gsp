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
    TODO: separate template for cinema and sessions
    ========================================-->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">How do we see the DDD</a>
            </div>
        </div>
    </nav>



    <div class="container">

        %{--<div ng-controller="SessionController" class="container">--}%
        %{--<h1>Header</h1>--}%

        %{--<p class="lead">Today in theatre</p>--}%

        %{--<ul>--}%
        %{--<div ng-repeat="session in sessions" class="session-column">--}%

        %{--<li>--}%
        %{--<img ng-src="{{'../assets/posters/' + session.cinema.name + '.jpg'}}" class="cinema-thumbnail">--}%
        %{--<h3>{{session.cinema.name}}</h3>--}%
        %{--Duration: {{session.cinema.duration}} <br/>--}%
        %{--Session: {{session.time.time | date:'medium'}}<br/>--}%

        %{--<div ng-repeat="seat in session.rows">--}%
        %{--<span ng-repeat="col in seat | orderBy: col.columnNum">--}%
        %{--({{col.rowNum}},{{col.columnNum}}) &nbsp;--}%
        %{--</span><br/>--}%
        %{--</div>--}%
        %{--</li>--}%

        %{--</div>--}%

        %{--</ul>--}%

        %{--</div>--}%




        <h1>Possible UI</h1>
        <ul class="cinema-list">
            <li class="cinema-container">
                <img ng-src="{{'../assets/posters/Inception.jpg'}}" class="cinema-thumbnail">
<div class="content">
                <h3 class="cinema-header">Cinema name</h3>
                <span>Duration: XX min</span>

                <div class="description-container">
                    <span>Description:</span>

                    <p>
                        Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat
                    </p>
                </div>
                Coming sessions:
                <ul class="session-list">
                    <li class="session"><a href="#">Session time</a></li>
                    <li class="session"><a href="#">Session time</a></li>
                    <li class="session"><a href="#">Session time</a></li>
                </ul>
</div>
            </li>
        </ul>

    </div>

</body>
</html>



