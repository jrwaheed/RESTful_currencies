<?php

$hostname = "localhost:3306"
$username = "jrwaheed"
$password = "Ubuntu!1"
$databasename = "APIcurrencies"

$conn = mysql_connection($hostname, $username, $password, $databasename)

if($conn -> connect_error){ 
    echo 'Could not connect!'
}

echo 'Connected successfully';

//$sql =  "INSERT INTO JPY (Ticker, Value, Relation) VALUES ('JPYTest', '1.455 ', 'Target');"

//$rs = mysql_query($conn, $sql);

		


	