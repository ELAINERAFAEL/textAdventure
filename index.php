<?php

$apiUrl = "http://localhost:3306/textAdventure";

if (isset($_GET['comando']) && isset($_GET['save'])) {
    $comando = rawurlencode($_GET['comando']);
    $save = rawurlencode($_GET['save']);
    $url = "{$apiUrl}/{$comando}/{$save}";
} elseif (isset($_GET['comando'])) {
    $comando = rawurlencode($_GET['comando']);
    $url = "{$apiUrl}/{$comando}";
} else {
    $url = $apiUrl;
}

$conteudo = file_get_contents("http://localhost:3306/textAdventure");
if ($conteudo === FALSE) {
    $arrayAssociativo = ['error' => 'não foi possível acessar a API.'];
} else {
    $arrayAssociativo = json_decode($conteudo, true);
    if (json_last_error() !== JSON_ERROR_NONE) {
        $arrayAssociativo = ['error' => 'erro ao decodificar JSON: ' . json_last_error_msg()];
    }
}
var_dump($arrayAssociativo);
include "template.phtml";
?>
