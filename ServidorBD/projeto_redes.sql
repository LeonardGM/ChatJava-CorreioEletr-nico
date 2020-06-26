SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- Create DATABASE projeto_redes;
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `sobrenome` varchar(60) DEFAULT NULL,
  `email` varchar(200) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `data_cadastro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nome`, `sobrenome`, `email`, `senha`, `data_cadastro`) VALUES
(15, 'teste', 'Teste', 'teste@gmail.com', 'teste', '2020-04-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

Select * from `mensagens`;

Select * from `usuarios`;

-- DROP TABLE `mensagens`;

CREATE TABLE `mensagens` (
  `id_mensagem` int(11) NOT NULL,
  `remetente` varchar(20) NOT NULL,
  `destinatario` varchar(60) DEFAULT NULL,
  `assunto` varchar(200) NOT NULL,
  `mensagem` varchar(32) NOT NULL,
  `data_mensagem` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* CREATE TABLE `mensagens` (
`id_mensagem` int(11) NOT NULL,
  `remetente` varchar(40) NOT NULL,
  `destinatario` varchar(40) DEFAULT NULL,
  `assunto` varchar(40) NOT NULL,
  `mensagem` varchar(500) NOT NULL
  );
*/

  ALTER TABLE `mensagens`
  ADD PRIMARY KEY (`id_mensagem`);
    
  ALTER TABLE `mensagens`
  MODIFY `id_mensagem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

