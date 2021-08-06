-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 29, 2020 at 02:30 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `kostumer`
--

CREATE TABLE `kostumer` (
  `id_kostumer` varchar(255) NOT NULL,
  `nama_kostumer` varchar(255) NOT NULL,
  `nik_kostumer` bigint(255) NOT NULL,
  `umur_kostumer` int(2) NOT NULL,
  `no_kostumer` bigint(13) NOT NULL,
  `alamat_kostumer` text NOT NULL,
  `jk_user` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kostumer`
--

INSERT INTO `kostumer` (`id_kostumer`, `nama_kostumer`, `nik_kostumer`, `umur_kostumer`, `no_kostumer`, `alamat_kostumer`, `jk_user`) VALUES
('002', 'yolando', 123, 21, 8226785, 'medan', 'Laki Laki'),
('003', 'nama', 1234, 19, 822, 'medan', 'Perempuan');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` bigint(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `nama`, `username`, `password`) VALUES
(1, 'yolando', 'admin', 'admin'),
(6, 'aku', 'sam', 'sam');

-- --------------------------------------------------------

--
-- Table structure for table `rute`
--

CREATE TABLE `rute` (
  `id_rute` varchar(255) NOT NULL,
  `maskapai` varchar(255) NOT NULL,
  `asal` varchar(255) NOT NULL,
  `tujuan` varchar(255) NOT NULL,
  `jlhKursi` int(25) NOT NULL,
  `harga` bigint(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rute`
--

INSERT INTO `rute` (`id_rute`, `maskapai`, `asal`, `tujuan`, `jlhKursi`, `harga`) VALUES
('ID000', 'Batik Air', 'bandung', 'jakarta', 100, 1250000),
('ID001', 'Garuda Indonesia', 'jakarta', 'bandung', 125, 1250000),
('ID002', 'Lion Air', 'BALI', 'JAKARTA', 100, 2500000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` varchar(255) NOT NULL,
  `namaTransaksi` varchar(255) NOT NULL,
  `nikTransaksi` bigint(255) NOT NULL,
  `umurTransaksi` bigint(255) NOT NULL,
  `hpTransaksi` bigint(255) NOT NULL,
  `alamatTransaksi` varchar(255) NOT NULL,
  `maskapaiTransaksi` varchar(255) NOT NULL,
  `asalTransaksi` varchar(255) NOT NULL,
  `tujuanTransaksi` varchar(255) NOT NULL,
  `hargaTransaksi` bigint(255) NOT NULL,
  `tanggalTransaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `namaTransaksi`, `nikTransaksi`, `umurTransaksi`, `hpTransaksi`, `alamatTransaksi`, `maskapaiTransaksi`, `asalTransaksi`, `tujuanTransaksi`, `hargaTransaksi`, `tanggalTransaksi`) VALUES
('ID0000', 'yolando', 123, 19, 8226785, 'medan', 'Batik Air', 'bandung', 'jakarta', 1250000, '2020-12-30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kostumer`
--
ALTER TABLE `kostumer`
  ADD PRIMARY KEY (`id_kostumer`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rute`
--
ALTER TABLE `rute`
  ADD PRIMARY KEY (`id_rute`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` bigint(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
