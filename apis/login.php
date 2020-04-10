<?php

	require("config.inc.php");

	$query = " 
            SELECT 
                 
                userName, 
                password
            FROM users 
            WHERE 
                userName = :userName 
        ";

        $query_params = array(
            ':userName' => $_POST['userName']
        );

        try 
        {
            $stmt   = $db->prepare($query);
            $result = $stmt->execute($query_params);
        }
        catch (PDOException $ex) 
        {
            $response["success"] = 0;
            $response["message"] = "Database Error1. Please Try Again!";
            die(json_encode($response));        
        }
    
        $row = $stmt->fetch();
        if ($row) 
        {        
            if ($_POST['password'] === $row['password']) 
            {
                $response["success"] = 1;
                $response["message"] = "Login successful!";
                die(json_encode($response));
            }
            else
            {
                $response["success"] = 0;
                $response["message"] = "Invalid password!";
                die(json_encode($response));
            }
        }
        else
        {
            $response["success"] = 0;
            $response["message"] = "this username in not in our database!";
            die(json_encode($response));
        }	
?>