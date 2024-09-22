<?php

$apiUrl = "http://localhost:textAdventure";

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

$conteudo = file_get_contents($url);

$arrayAssociativo = json_decode($conteudo);

include "template.phtml";
?>
