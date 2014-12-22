<!doctype html>
<html>
<head>
    <title></title>

    <g:javascript src="services/CommonServices.js"/>
    <g:javascript src="controllers/CommonControllers.js"/>
    <g:javascript src="filters/CommonFilters.js"/>

    <g:javascript src="app.js"/>

</head>

<body>
<div ng-controller="SessionController">
    <ul>
        <li ng-repeat="session in sessions">
            Cinema: {{session.cinema.name}} Duration: {{session.cinema.duration}} <br/>

            Session: {{session.time.time | date:'medium'}}<br/>

            <div ng-repeat="seat in session.rows">
                <span ng-repeat="col in seat | orderBy: col.columnNum">
                    ({{col.rowNum}},{{col.columnNum}}) &nbsp;
                </span><br/>
            </div>
        </li>

    </ul>

</div>

</body>
</html>



