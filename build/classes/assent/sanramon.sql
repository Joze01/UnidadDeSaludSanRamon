-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2018 at 05:56 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.0.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sanramon`
--

-- --------------------------------------------------------

--
-- Table structure for table `destinatario`
--

CREATE TABLE `destinatario` (
  `idDestinatario` int(11) NOT NULL,
  `nombreDestinatario` varchar(50) NOT NULL,
  `descripcionDestinatario` varchar(50) NOT NULL,
  `estadoDestinatario` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `entrada`
--

CREATE TABLE `entrada` (
  `idEntrada` int(11) NOT NULL,
  `id_Lote` int(11) NOT NULL,
  `id_Producto` int(11) NOT NULL,
  `cantidadEntrada` float NOT NULL,
  `costoEntrada` float NOT NULL,
  `fechaVencimientoEntrada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lote`
--

CREATE TABLE `lote` (
  `idLote` int(11) NOT NULL,
  `codigoLote` varchar(50) NOT NULL,
  `fechaEntradaLote` date NOT NULL,
  `id_proveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `codigoProducto` varchar(50) NOT NULL,
  `nombreProducto` varchar(50) NOT NULL,
  `descripcionProducto` varchar(50) NOT NULL,
  `nivelUsoProducto` varchar(10) NOT NULL,
  `id_UnidadMedida` int(11) NOT NULL,
  `Id_EntradaProducto` int(11) NOT NULL,
  `saldoEntradaProducto` float NOT NULL,
  `estadoProducto` int(11) NOT NULL,
  `saldoTotalProducto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(50) NOT NULL,
  `descripcionProveedor` varchar(50) NOT NULL,
  `estadoproveedor` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombreProveedor`, `descripcionProveedor`, `estadoproveedor`) VALUES
(1, 'prove', 'proveed', 0),
(2, 'prove', 'proveed', 1);

-- --------------------------------------------------------

--
-- Table structure for table `receta`
--

CREATE TABLE `receta` (
  `idReceta` int(11) NOT NULL,
  `codigoReceta` varchar(50) NOT NULL,
  `fechaEntrega` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `salida`
--

CREATE TABLE `salida` (
  `idSalida` int(11) NOT NULL,
  `id_entrada` int(11) NOT NULL,
  `cantidadSalida` float NOT NULL,
  `tipoSalida` int(11) NOT NULL,
  `id_receta` int(11) NOT NULL,
  `id_vale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `unidadmedida`
--

CREATE TABLE `unidadmedida` (
  `idUnidadMedida` int(11) NOT NULL,
  `nombreUnidadMedida` varchar(50) NOT NULL,
  `descripcionUnidadMedida` varchar(50) NOT NULL,
  `estadoUnidadMedida` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `loginUsuario` varchar(50) NOT NULL,
  `passwordUsuario` varchar(50) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `estadoUsuario` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vale`
--

CREATE TABLE `vale` (
  `idVale` int(11) NOT NULL,
  `codigovale` varchar(50) NOT NULL,
  `fechaEntrega` date NOT NULL,
  `id_destinatario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `destinatario`
--
ALTER TABLE `destinatario`
  ADD PRIMARY KEY (`idDestinatario`);

--
-- Indexes for table `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`idEntrada`),
  ADD KEY `id_Producto` (`id_Producto`),
  ADD KEY `f_entrada_lote` (`id_Lote`);

--
-- Indexes for table `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`idLote`),
  ADD KEY `f_lote_proveedor` (`id_proveedor`);

--
-- Indexes for table `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `id_UnidadMedida` (`id_UnidadMedida`),
  ADD KEY `Id_EntradaProducto` (`Id_EntradaProducto`);

--
-- Indexes for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indexes for table `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`idReceta`);

--
-- Indexes for table `salida`
--
ALTER TABLE `salida`
  ADD PRIMARY KEY (`idSalida`),
  ADD KEY `f_salida_entrada` (`id_entrada`),
  ADD KEY `f_salida_receta` (`id_receta`),
  ADD KEY `f_salida_vale` (`id_vale`);

--
-- Indexes for table `unidadmedida`
--
ALTER TABLE `unidadmedida`
  ADD PRIMARY KEY (`idUnidadMedida`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indexes for table `vale`
--
ALTER TABLE `vale`
  ADD PRIMARY KEY (`idVale`),
  ADD KEY `f_vale_destinatario` (`id_destinatario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `destinatario`
--
ALTER TABLE `destinatario`
  MODIFY `idDestinatario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `entrada`
--
ALTER TABLE `entrada`
  MODIFY `idEntrada` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `lote`
--
ALTER TABLE `lote`
  MODIFY `idLote` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `receta`
--
ALTER TABLE `receta`
  MODIFY `idReceta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `salida`
--
ALTER TABLE `salida`
  MODIFY `idSalida` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `unidadmedida`
--
ALTER TABLE `unidadmedida`
  MODIFY `idUnidadMedida` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vale`
--
ALTER TABLE `vale`
  MODIFY `idVale` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `f_entrada_lote` FOREIGN KEY (`id_Lote`) REFERENCES `lote` (`idLote`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `f_entrada_producto` FOREIGN KEY (`id_Producto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lote`
--
ALTER TABLE `lote`
  ADD CONSTRAINT `f_lote_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`idProveedor`);

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `f_producto_entrada` FOREIGN KEY (`Id_EntradaProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `f_unidadMedida_producto` FOREIGN KEY (`id_UnidadMedida`) REFERENCES `unidadmedida` (`idUnidadMedida`);

--
-- Constraints for table `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `f_salida_entrada` FOREIGN KEY (`id_entrada`) REFERENCES `entrada` (`idEntrada`),
  ADD CONSTRAINT `f_salida_receta` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`idReceta`),
  ADD CONSTRAINT `f_salida_vale` FOREIGN KEY (`id_vale`) REFERENCES `vale` (`idVale`);

--
-- Constraints for table `vale`
--
ALTER TABLE `vale`
  ADD CONSTRAINT `f_vale_destinatario` FOREIGN KEY (`id_destinatario`) REFERENCES `destinatario` (`idDestinatario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
