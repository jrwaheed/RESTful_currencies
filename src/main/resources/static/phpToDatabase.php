<?php
	include 'phpConnect.php';
    $Ticker=$_POST['Ticker'];
    $Value=$_POST['Value'];
	$sql = "INSERT INTO `JPY`( `Ticker`, `Value`) 
	VALUES ('JPY','1000')";
	if (mysqli_query($conn, $sql)) {
		echo json_encode(array("statusCode"=>200));
	} 
	else {
		echo json_encode(array("statusCode"=>201));
	}
	mysqli_close($conn);

