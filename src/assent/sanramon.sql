-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-05-2018 a las 06:01:39
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sanramon`
--
CREATE DATABASE IF NOT EXISTS `sanramon` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sanramon`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destinatario`
--

CREATE TABLE `destinatario` (
  `idDestinatario` int(11) NOT NULL,
  `nombreDestinatario` varchar(50) NOT NULL,
  `descripcionDestinatario` varchar(50) NOT NULL,
  `estadoDestinatario` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `destinatario`
--

INSERT INTO `destinatario` (`idDestinatario`, `nombreDestinatario`, `descripcionDestinatario`, `estadoDestinatario`) VALUES
(1, 'Destinatario', 'Destinatarito', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `idEntrada` int(11) NOT NULL,
  `id_Lote` int(11) NOT NULL,
  `id_Producto` int(11) NOT NULL,
  `cantidadEntrada` float NOT NULL,
  `costoEntrada` float NOT NULL,
  `fechaVencimientoEntrada` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`idEntrada`, `id_Lote`, `id_Producto`, `cantidadEntrada`, `costoEntrada`, `fechaVencimientoEntrada`) VALUES
(1, 1, 2, 50, 100, '2018-05-06 19:59:29'),
(2, 1, 2, 25, 100, '2018-05-06 19:59:29'),
(3, 1, 2, 100, 100, '2018-05-06 19:59:29'),
(4, 1, 3, 100, 100, '2018-05-06 19:59:29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lote`
--

CREATE TABLE `lote` (
  `idLote` int(11) NOT NULL,
  `codigoLote` varchar(50) NOT NULL,
  `fechaEntradaLote` date NOT NULL,
  `id_proveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lote`
--

INSERT INTO `lote` (`idLote`, `codigoLote`, `fechaEntradaLote`, `id_proveedor`) VALUES
(1, 'Lote1', '2018-05-05', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `codigoProducto` varchar(50) NOT NULL,
  `nombreProducto` varchar(50) NOT NULL,
  `descripcionProducto` varchar(50) NOT NULL,
  `nivelUsoProducto` varchar(10) NOT NULL,
  `id_UnidadMedida` int(11) NOT NULL,
  `Id_EntradaProducto` int(11) DEFAULT NULL,
  `saldoEntradaProducto` float NOT NULL,
  `estadoProducto` int(11) NOT NULL,
  `saldoTotalProducto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `codigoProducto`, `nombreProducto`, `descripcionProducto`, `nivelUsoProducto`, `id_UnidadMedida`, `Id_EntradaProducto`, `saldoEntradaProducto`, `estadoProducto`, `saldoTotalProducto`) VALUES
(2, 'PUP', 'Pupusas', 'Son ricas', 'PU', 1, 1, 25, 1, 0),
(3, 'GAS', 'GASEOSAS', 'GASEOSAS', 'GAS', 1, 4, 50, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(50) NOT NULL,
  `descripcionProveedor` varchar(50) NOT NULL,
  `estadoproveedor` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombreProveedor`, `descripcionProveedor`, `estadoproveedor`) VALUES
(1, 'prove', 'proveed', 0),
(2, 'prove', 'proveed', 1),
(3, 'proveedor3', 'descripcion3', 0),
(4, 'Nuevo proveedor', 'Nuevito', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `idReceta` int(11) NOT NULL,
  `codigoReceta` varchar(50) NOT NULL,
  `fechaEntrega` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`idReceta`, `codigoReceta`, `fechaEntrega`) VALUES
(1, 'Codigo', '2018-05-06'),
(7, 'ds', '2018-05-07'),
(8, 'sdd', '2018-05-07'),
(9, 'Alvin', '2018-05-07'),
(10, 'ds', '2018-05-07'),
(11, 'fs', '2018-05-07'),
(12, 'sd', '2018-05-07'),
(13, 'codigo', '2018-05-07'),
(14, 'MiReceta', '2018-05-07'),
(15, '34', '2018-05-07'),
(16, '23', '2018-05-07'),
(17, 'sd', '2018-05-07'),
(18, 'sd', '2018-05-07'),
(19, 'A VER', '2018-05-07'),
(20, 'AVC', '2018-05-07'),
(21, 'asd', '2018-05-07'),
(22, '23', '2018-05-07'),
(23, 'rep', '2018-05-07'),
(24, 'Vendedeo', '2018-05-07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE `salida` (
  `idSalida` int(11) NOT NULL,
  `id_entrada` int(11) NOT NULL,
  `cantidadSalida` float NOT NULL,
  `tipoSalida` int(11) NOT NULL,
  `id_receta` int(11) DEFAULT NULL,
  `id_vale` int(11) DEFAULT NULL,
  `fechaSalida` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salida`
--

INSERT INTO `salida` (`idSalida`, `id_entrada`, `cantidadSalida`, `tipoSalida`, `id_receta`, `id_vale`, `fechaSalida`) VALUES
(87, 1, 50, 1, 1, NULL, '2018-05-06 21:29:38'),
(88, 2, 10, 1, 1, NULL, '2018-05-06 21:29:39'),
(89, 2, 15, 1, 1, NULL, '2018-05-06 21:29:41'),
(90, 3, 45, 1, 1, NULL, '2018-05-06 21:29:42'),
(91, 3, 15, 1, 9, NULL, '2018-05-07 14:44:11'),
(92, 3, 10, 1, 9, NULL, '2018-05-07 14:44:11'),
(93, 3, 12, 1, 12, NULL, '2018-05-07 14:48:54'),
(94, 3, 32, 1, 12, NULL, '2018-05-07 14:48:55'),
(95, 1, 25, 1, 13, NULL, '2018-05-07 14:50:17'),
(96, 4, 25, 1, 13, NULL, '2018-05-07 14:50:17'),
(97, 4, 25, 1, 24, NULL, '2018-05-07 21:52:35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidadmedida`
--

CREATE TABLE `unidadmedida` (
  `idUnidadMedida` int(11) NOT NULL,
  `nombreUnidadMedida` varchar(50) NOT NULL,
  `descripcionUnidadMedida` varchar(50) NOT NULL,
  `estadoUnidadMedida` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `unidadmedida`
--

INSERT INTO `unidadmedida` (`idUnidadMedida`, `nombreUnidadMedida`, `descripcionUnidadMedida`, `estadoUnidadMedida`) VALUES
(1, 'Unidad ', 'Es una', 1),
(2, 'Cientos', 'Cientos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
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
-- Estructura de tabla para la tabla `vale`
--

CREATE TABLE `vale` (
  `idVale` int(11) NOT NULL,
  `codigovale` varchar(50) NOT NULL,
  `fechaEntrega` date NOT NULL,
  `id_destinatario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `destinatario`
--
ALTER TABLE `destinatario`
  ADD PRIMARY KEY (`idDestinatario`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`idEntrada`),
  ADD KEY `id_Producto` (`id_Producto`),
  ADD KEY `f_entrada_lote` (`id_Lote`);

--
-- Indices de la tabla `lote`
--
ALTER TABLE `lote`
  ADD PRIMARY KEY (`idLote`),
  ADD KEY `f_lote_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `id_UnidadMedida` (`id_UnidadMedida`),
  ADD KEY `Id_EntradaProducto` (`Id_EntradaProducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`idReceta`);

--
-- Indices de la tabla `salida`
--
ALTER TABLE `salida`
  ADD PRIMARY KEY (`idSalida`),
  ADD KEY `f_salida_entrada` (`id_entrada`),
  ADD KEY `f_salida_receta` (`id_receta`),
  ADD KEY `f_salida_vale` (`id_vale`);

--
-- Indices de la tabla `unidadmedida`
--
ALTER TABLE `unidadmedida`
  ADD PRIMARY KEY (`idUnidadMedida`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `vale`
--
ALTER TABLE `vale`
  ADD PRIMARY KEY (`idVale`),
  ADD KEY `f_vale_destinatario` (`id_destinatario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `destinatario`
--
ALTER TABLE `destinatario`
  MODIFY `idDestinatario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `entrada`
--
ALTER TABLE `entrada`
  MODIFY `idEntrada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `lote`
--
ALTER TABLE `lote`
  MODIFY `idLote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
  MODIFY `idReceta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de la tabla `salida`
--
ALTER TABLE `salida`
  MODIFY `idSalida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT de la tabla `unidadmedida`
--
ALTER TABLE `unidadmedida`
  MODIFY `idUnidadMedida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `vale`
--
ALTER TABLE `vale`
  MODIFY `idVale` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `f_entrada_lote` FOREIGN KEY (`id_Lote`) REFERENCES `lote` (`idLote`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `f_entrada_producto` FOREIGN KEY (`id_Producto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `lote`
--
ALTER TABLE `lote`
  ADD CONSTRAINT `f_lote_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`idProveedor`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `f_producto_entrada` FOREIGN KEY (`Id_EntradaProducto`) REFERENCES `entrada` (`idEntrada`),
  ADD CONSTRAINT `f_unidadMedida_producto` FOREIGN KEY (`id_UnidadMedida`) REFERENCES `unidadmedida` (`idUnidadMedida`);

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `f_salida_entrada` FOREIGN KEY (`id_entrada`) REFERENCES `entrada` (`idEntrada`),
  ADD CONSTRAINT `f_salida_receta` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`idReceta`),
  ADD CONSTRAINT `f_salida_vale` FOREIGN KEY (`id_vale`) REFERENCES `vale` (`idVale`);

--
-- Filtros para la tabla `vale`
--
ALTER TABLE `vale`
  ADD CONSTRAINT `f_vale_destinatario` FOREIGN KEY (`id_destinatario`) REFERENCES `destinatario` (`idDestinatario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
