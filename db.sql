CREATE TABLE `produtos` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `preco` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `imagem` varchar(255) NOT NULL
);

ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `produtos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;


INSERT INTO `product` (`id`, `nome`, `preco`, `categoria`, `imagem`) VALUES
(1, 'caramelo melo', '300', 'bombons', 'img/caramelo.jpg'),
(2, 'chiclete lete', '50', 'bombons', 'img/chiclete.jpg'),
(3, 'confeite choco', '100', 'bombons', 'img/confeites.jpg'),
(4, 'donuts coloridos', '520', 'donuts', 'img/donuts.jpg'),
(5, 'donuts pink', '124', 'donuts', 'img/donutspink.jpg'),
(6, 'donuts rosa', '920', 'donuts', 'img/donutsrosa.jpg'),
(7, 'donuts chocolate', '62', 'donuts', 'img/donutschocolate.jpg'),
(8, 'chocolate barra', '76', 'chocolate', 'img/chocolatebarra.jpg'),
(9, 'brigadeiro', '750', 'chocolate', 'img/brigadeiro.jpg'),
(10, 'chocolate prestigio', '600', 'chocolate', 'img/chocolateprestigio.jpg'),
(11, 'pirulito arco iris', '400', 'pirulito', 'img/pirulitoarcoiris.jpg'),
(12, 'pirulito azul', '550', 'pirulito', 'img/pirulitoazul.jpg'),
(13, 'pirulito coracao', '1200', 'pirulito', 'img/pirulitocoracao.jpg'),
(14, 'rapadura de coco', '24000', 'rapadura', 'img/rapaduracoco.jpg'),
(15, 'rapadura de tijolo', '450', 'rapadura', 'no', 'img/rapaduratijolo.jpg');



CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` text NOT NULL,
  `email` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
)

  
  ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);
  
  ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;