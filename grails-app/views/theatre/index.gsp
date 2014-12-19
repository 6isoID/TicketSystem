<!doctype html>
<html>
<head>
    <title></title>

    <g:javascript src="services/CommonServices.js"/>
    <g:javascript src="controllers/CommonControllers.js"/>

    <g:javascript src="app.js"/>


</head>

<body >
<div ng-controller="SessionController">
   <ul>
       <li ng-repeat="session in sessions">

           %{--TODO custom REST controller - I don't need class info and so on. I need only name and ID--}%
           Session id: {{session.id}} <br/>
           Cinema id:  {{session.cinema.id}}<br/>
           Hall id: {{session.hall.id}}<br/>
           Cost: {{session.cost}}<br/>
           Time: {{session.time}}
       </li>

   </ul>


</div>


</body>
</html>



