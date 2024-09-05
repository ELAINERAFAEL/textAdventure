delete from  fase where id_fase in (8,9,10);

delete from opcoes where id_opcoes in (8,9);

insert into fase (id_historia,id_fase,numero,descricao) values (1,null,8,"Quase chegando no país Yolanda recebe uma mensagem de um número desconhecido, alertando-a de que no caminho havia uma emboscada e ela deveria VOLTAR, porém ela fica confusa se deve atender a isso ou PROSEGUIR.."),
(1,null,9," Era apenas uma mentira, continue no caminho."), (1,null,10,"Oh não, era a polícia com uma armadilha! Game Over
");

update opcoes set id_fase = 6, destino = 11 where id_opcoes = 7; 

insert into opcoes (id_opcoes,id_fase,opcao,destino) values (null,11,"PROSSEGUIR",12),
(null,11,"VOLTAR",13);

insert into fase (id_historia,id_fase,numero,descricao) values (1,null,11,"Yolanda está quase lá! Vocês já chegaram na cidade de destino, e falta muito pouco para fazer a entrega e receber sua recompensa! Porém há um empecilho, Yolanda está com sua gasolina acabando, mas pela pressa está decidindo IGNORAR, ou ir por um CAMINHO mais curto."),
(1,null,12,"melhor repensar, tem certeza?"), (1,null,13,"oh não, você deu de cara com a polícia e perdeu sua missão."), (1,null,14,"agora você pode terminar a missão tranquilamente..")
 
insert into opcoes (id_opcoes,id_fase,opcao,destino) values (null,12,"Continuar",14), (null,14,"IGNORAR",15), (null,14,"CAMINHO",16), (null,14,"GASOLINA",17);

insert into fase (id_historia,id_fase,numero,descricao) values  (1,null,15,"YOLANDA FINALMENTE CHEGA NO LOCAL
SE ENCONTRA EM UMA SITUAÇÃO DUVIDOSA POIS O LOCAL NÃO ERA BEM COMO ELA ESPERAVA 
ERA UM CLUBE DE FANS DO JUSTIN BIEBER 
Devido ao local inesperado Yolanda se depara em uma posição de ESCOLHA, pensando em ABANDONAR tudo, ou ir ADENTRO do local para ver qual vai ser."),
(1,null,16,"você pode estar com dúvidas, mas indico tomar uma decisão!"), (1,null,17,"você estava quase lá, mas tudo bem, quem sabe uma próxima."), (1,null,18,"você encontrou o maior noia e fã do Justin Bieber com a sua recompensa, agora pode seguir onde quiser com sua grana!");

insert into opcoes (id_opcoes,id_fase,opcao,destino) values (null,17,"Continuar",18), (null,18,"ESCOLHA",19), (null,18,"ABANDONAR",20), (null,18,"ADENTRO",21);