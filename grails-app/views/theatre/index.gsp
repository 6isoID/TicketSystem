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
            %{--TODO filter--}%
            %{--getRows : {{getRows(session)}}--}%

            %{--<div ng-repeat="seat in getRows(session)">--}%
                %{--<span ng-repeat="col in seat">x</span><br/>--}%
                %{--{{seat}}--}%
                %{--{{seat.rowNum}} x {{seat.columnNum}}--}%
            %{--</div>--}%
        </li>

    </ul>

</div>

</body>
</html>



