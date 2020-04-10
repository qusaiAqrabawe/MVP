<?php

	require("config.inc.php");

	$query        = " SELECT * FROM news ";
	try 
	{
		$stmt   = $db->prepare($query);
        $result = $stmt->execute();	
	} 
	catch (PDOException $e) 
	{
		$response["success"] = 0;
        $response["message"] = "Database Error1. Please Try Again!";
        die(json_encode($response));	
	}

	$rows = $stmt->fetchAll();
	if ($rows) 
	{
        $response["success"] = 1;
    	$response["message"] = "news Available!";
    	$response["news"]   = array();

    	foreach ($rows as $row) 
    	{
        	$post                 = array();
 
        	$post["title"]      = $row["title"];
        	$post["description"]    = $row["description"];
                	$post["phone"]   = $row["phone"];
					                	$post["department"]   = $row["department"];

					         	$post["userName"]   = $row["userName"];



        
        	array_push($response["news"], $post);
    	}

    	 echo json_encode($response,JSON_UNESCAPED_UNICODE);
    }
    else 
    {
    	$response["success"] = 0;
    	$response["message"] = "No news Available!";
    	die(json_encode($response));
	}
?>