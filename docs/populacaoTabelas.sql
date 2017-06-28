INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Mago');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Feiticeiro');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Monge');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Lutador');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Guerreiro');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Ninja');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Nobre');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Samurai');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Elfo');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Anão');
INSERT INTO `nyte`.`tbl_especie` (especie) VALUES ('Orc');




INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Sandflame');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Screamhunt');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Elfstorm');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Bornland');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Axebreaker');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Magentaglaze');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Oakmane');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Riverhawk');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Moonfire');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Power');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Lockwyrm');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Landershort');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Starhelm');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Hiltscream');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Mawsheep');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Summerfury');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Gliderwinter');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Axemaze');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Sheepheart');
INSERT INTO `nyte`.`tbl_povoado` (nome) VALUES ('Huntrage');



INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Perna Direita');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Perna Esquerda');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Cabeça');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Pescoço');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Cinto');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Arma');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Anel Direito');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Anel Esquerdo');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Braço Direito');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Braço Esquerdo');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Peitoral');
INSERT INTO `nyte`.`tbl_area_corpo` (area_corpo) VALUES ('Pé');


INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Elmo Bullwhite', 100, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Capacete Night', 200, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Máscara Whitehawk', 300, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Elmo Bullblue', 123, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Capacete Hairleaf', 321 , (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Elmo Landfalcon', 432, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Máscara Stormmetal', 80, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Elmo Nightsheep', 32, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Capacete Manepaladincape', 325, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Máscara Hawkdarkchase', 1342, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Máscara Gatemane', 2000, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Elmo Fury', 3265, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Capacete Landerlandtall', 6430, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Máscara Dwarfcape', 70, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Elmo Bloodfire', 134, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Capacete Steelyellow', 9320, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Elmo Gold', 5312, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Capacete Summertree', 4312, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Capacete Mountain', 326, (select id from tbl_area_corpo where area_corpo like 'Cabeça'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Máscara Manhillplains', 120, (select id from tbl_area_corpo where area_corpo like 'Cabeça')); 



INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cordão Birdbreak', 100, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colar Screamhilt', 133, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Coleira Mourneoaken', 321, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cordão Pickerjaw', 324, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colar Tongueroad', 235, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Coleira Wavehilt', 812, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cordão Windwhite', 821, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Coleira Wallwalk', 385, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colar Bowoaken', 438, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cordão Wulfblue', 1000, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Coleira Cyanblood', 2131, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cordão Cyanwavemetal', 832, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Coleira Glideshine', 3000, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colar Autumnwyrm', 7000, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Coleira Screammourne', 8432, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colar Glazedark', 361, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cordão Gray', 495, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colar Lakeyellow', 281, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Coleira Maw', 821, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cordão Duskland', 84, (select id from tbl_area_corpo where area_corpo like 'Pescoço'));




INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha Windpaladin', 134, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Escudo Furygaze', 9320, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colete Hawkwarg', 5312, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colete Dwarfbolt', 4312, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Escudo Eyesbattler', 326, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha Mourneagle', 120, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Escudo Glidebull', 100, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha Greyheart', 200, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colete Bornebitter', 300, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha Hammerwalk', 123, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Escudo Nosedwarf', 321 , (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colete Autumn-sea', 432, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colete Darkdagger', 80, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha Shortshadow', 32, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Escudo Mawtree', 325, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Escudo Elven', 1342, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colete Breezeshield', 2000, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha Hunterbow', 3265, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha Lockewalker', 6430, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Colete Walker-fall', 70, (select id from tbl_area_corpo where area_corpo like 'Peitoral'));



INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Windpaladin', 134, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Furygaze', 9320, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Hawkwarg', 5310, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Dwarfbolt', 4310, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Eyesbattler', 326, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Mourneagle', 100, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Glidebull', 100, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Greyheart', 200, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Bornebitter', 300, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Hammerwalk', 103, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Nosedwarf', 321 , (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Autumn-sea', 432, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Darkdagger', 80, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Shortshadow', 32, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Mawtree', 325, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Elven', 1342, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Breezeshield', 2000, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Hunterbow', 3265, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Lockewalker', 6430, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Walker-fall', 70, (select id from tbl_area_corpo where area_corpo like 'Braço Esquerdo'));




INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Windpaladin', 134, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Furygaze', 9320, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Hawkwarg', 5310, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Dwarfbolt', 4310, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Eyesbattler', 326, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Mourneagle', 100, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Glidebull', 100, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Greyheart', 200, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Bornebitter', 300, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Hammerwalk', 103, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Nosedwarf', 321 , (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Autumn-sea', 432, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Darkdagger', 80, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Shortshadow', 32, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Mawtree', 325, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Braçadeira Elven', 1342, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Breezeshield', 2000, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Hunterbow', 3265, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Braço Lockewalker', 6430, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bracelete Walker-fall', 70, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));




INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Baneeye', 134, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Dragon', 9320, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Sunbird', 5310, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Orecloak', 4310, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Stormcloak', 326, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Dragondark', 100, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Forgemoor', 100, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Lordshort', 200, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Lordblue', 300, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Lynxmetalgold', 103, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Eargray', 321 , (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Breaker-oak', 432, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Silverriver', 80, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Blurbane', 32, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Axshort', 325, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Greyjaw', 1342, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Blurblue', 2000, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Yellowblade', 3265, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinta Hawkautumn', 6430, (select id from tbl_area_corpo where area_corpo like 'Cinto'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Cinturão Magentahill', 70, (select id from tbl_area_corpo where area_corpo like 'Braço Direito'));




INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Dawn', 100, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Springsand', 1234, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Mournenight', 321, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Oreblue', 434, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Nosecat', 373, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Redbreeze', 8712, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Morninglight', 234, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Starautumn', 213, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Warriorsword', 763, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Shadowhunt', 512, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Chasewalkerlips', 362, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Manebreeze', 172, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Goat-oaken', 831, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Earbright', 1034, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Quiverday', 3134, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Walkmaw', 2761, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Capetongue', 7341, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Breakborn', 2167, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Gliderlocke', 231, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Bitterbronze', 872, (select id from tbl_area_corpo where area_corpo like 'Anel Esquerdo'));





INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Dawn', 100, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Springsand', 1234, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Mournenight', 321, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Oreblue', 434, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Nosecat', 373, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Redbreeze', 8712, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Morninglight', 234, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Starautumn', 213, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Warriorsword', 763, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Shadowhunt', 512, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Chasewalkerlips', 362, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Manebreeze', 172, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Goat-oaken', 831, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Earbright', 1034, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Quiverday', 3134, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Walkmaw', 2761, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Capetongue', 7341, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Breakborn', 2167, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Luva Gliderlocke', 231, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Anel Bitterbronze', 872, (select id from tbl_area_corpo where area_corpo like 'Anel Direito'));




INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Windpaladin', 134, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Furygaze', 9320, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Hawkwarg', 5310, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Dwarfbolt', 4310, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Eyesbattler', 326, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Mourneagle', 100, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Glidebull', 100, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Greyheart', 200, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Bornebitter', 300, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Hammerwalk', 103, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Nosedwarf', 321 , (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Autumn-sea', 432, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Darkdagger', 80, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Shortshadow', 32, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Mawtree', 325, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Elven', 1342, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Breezeshield', 2000, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Hunterbow', 3265, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Lockewalker', 6430, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Walker-fall', 70, (select id from tbl_area_corpo where area_corpo like 'Perna Esquerda'));




INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Windpaladin', 134, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Furygaze', 9320, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Hawkwarg', 5310, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Dwarfbolt', 4310, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Eyesbattler', 326, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Mourneagle', 100, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Glidebull', 100, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Greyheart', 200, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Bornebitter', 300, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Hammerwalk', 103, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Nosedwarf', 321 , (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Autumn-sea', 432, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Darkdagger', 80, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Shortshadow', 32, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Mawtree', 325, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Caneleira Elven', 1342, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Breezeshield', 2000, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Hunterbow', 3265, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Malha de Perna Lockewalker', 6430, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Perneira Walker-fall', 70, (select id from tbl_area_corpo where area_corpo like 'Perna Direita'));






INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bota Windpaladin', 134, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Sandália Furygaze', 9320, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Hawkwarg', 5310, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Dwarfbolt', 4310, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Sandália Eyesbattler', 326, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Sandália Mourneagle', 100, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Glidebull', 100, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Greyheart', 200, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Sandália Bornebitter', 300, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Hammerwalk', 103, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bota Nosedwarf', 321 , (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Sandália Autumn-sea', 432, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bota Darkdagger', 80, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Shortshadow', 32, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bota Mawtree', 325, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Sandália Elven', 1342, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bota Breezeshield', 2000, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Hunterbow', 3265, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Calçado Lockewalker', 6430, (select id from tbl_area_corpo where area_corpo like 'Pé'));

INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Bota Walker-fall', 70, (select id from tbl_area_corpo where area_corpo like 'Pé'));




INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Mawaxe', 143, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Arco Autumnshine', 214 , (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Adaga Gray', 346, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Shurikens Sand', 754 , (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Breakwind', 1231, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Arco Lordday', 2176, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Glideyellowbreaker', 3484, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Adaga Wolfsilver', 4853, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Mazelynx', 5721, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Arco Spinerage', 285, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Shurikens Hawkbloodsummer', 623, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Adaga Bronzeforge', 816, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Arco Elfrain', 8126, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Ironbullram', 938 , (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Arco Ironlight', 342, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Shadepicker', 718, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Adaga Wyrmyellowcyan', 910, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Arco oBathame', 817, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Warwalker', 732, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
INSERT INTO tbl_item (nome, valor, id_area_corpo) VALUES ('Espada Nightgoat', 10823, (select id from tbl_area_corpo where area_corpo like 'Arma'));
 
