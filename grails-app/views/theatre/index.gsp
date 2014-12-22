<!doctype html>
<html>
<head>
    <title></title>
    <!-- Angular app files
    ===================================================-->
    <asset:javascript src="services/CommonService.js"/>
    <asset:javascript src="CommonControllers.js"/>
    <asset:javascript src="filters/CommonFilters.js"/>
    <asset:javascript src="app.js"/>

    <!-- style shit =)
    ======================================-->
    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="common.css"/>
    %{--<asset:stylesheet src="cover.css"/>--}%
</head>

<body>


<div ng-controller="SessionController" class="container">
    <h1>Header</h1>
    <p class="lead">Today in theatre</p>
    <ul>
        <div ng-repeat="session in sessions" class="session-column">

            <li>

                <h3>{{session.cinema.name}}</h3>
                Duration: {{session.cinema.duration}} <br/>
                Session: {{session.time.time | date:'medium'}}<br/>

                <div ng-repeat="seat in session.rows">
                    <span ng-repeat="col in seat | orderBy: col.columnNum">
                        ({{col.rowNum}},{{col.columnNum}}) &nbsp;
                    </span><br/>
                </div>
            </li>


        </div>
    </ul>
</div>

</body>
</html>



