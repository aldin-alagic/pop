<?php

require_once 'db_function.php';
$db = new DB_Functions();

require_once 'responseTemplate.php';
        
$registerCheck=$db->checkRegister($_POST);

if ($registerCheck!==1){
    $response->STATUS=400;
    $response->STATUSMESSAGE="BAD REQUEST: BAD PARAMETER: ".$registerCheck;
    $response = json_encode($response);
    echo $response;
    return;
}
?>