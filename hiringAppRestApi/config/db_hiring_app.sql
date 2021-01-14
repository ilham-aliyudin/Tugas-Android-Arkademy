-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2020 at 09:14 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_hiring_app`
--

-- --------------------------------------------------------

--
-- Table structure for table `engineer`
--

CREATE TABLE `engineer` (
  `id` int(30) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `jobdesc` varchar(100) NOT NULL,
  `lokasi` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `skill` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `engineer`
--

INSERT INTO `engineer` (`id`, `nama`, `jobdesc`, `lokasi`, `status`, `deskripsi`, `skill`) VALUES
(22, 'Ryunoesuke', 'Web Developer', 'Surabaya', 'Freelancer', 'Native Mobile Programmer with Kotlin', 'PHP'),
(24, 'ilham aliyudin', 'Web Developer', 'Bandung', 'Freelancer', 'Native Mobile Programmer with Kotlin', 'Kotlin'),
(26, 'Lionel messsiah', 'Web Developer', 'Surabaya', 'Freelancer', 'Native Mobile Programmer with Kotlin', 'PHP');

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE `experience` (
  `id` int(30) NOT NULL,
  `company_name` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  `masuk` varchar(20) NOT NULL,
  `keluar` varchar(20) NOT NULL,
  `deskripsi` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `portfolio`
--

CREATE TABLE `portfolio` (
  `id` int(30) NOT NULL,
  `nama_app` varchar(100) NOT NULL,
  `link_github` varchar(100) NOT NULL,
  `type_porfolio` varchar(100) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id` int(30) NOT NULL,
  `project_name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `deadline` varchar(100) NOT NULL,
  `linkedin` varchar(100) NOT NULL,
  `image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `recruiter`
--

CREATE TABLE `recruiter` (
  `id` int(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `bidang` varchar(20) NOT NULL,
  `lokasi` varchar(20) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `email` varchar(20) NOT NULL,
  `kontak` int(20) NOT NULL,
  `jabatan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recruiter`
--

INSERT INTO `recruiter` (`id`, `nama`, `bidang`, `lokasi`, `deskripsi`, `email`, `kontak`, `jabatan`) VALUES
(3, 'PT.Sentosa Abadi', 'Arsitektur', 'Bandung', 'Perusahaan di dibidang furniture', 'anginribut@gmail.com', 8562, 'HRD'),
(4, 'PT.JAYA ABADI', 'Jasa', 'Bandung', 'Perusahaan di bidang jasa', 'anginribut@gmail.com', 8562, 'HRD'),
(5, 'PT.JAYA MAHE', 'Jasa', 'Bandung', 'Perusahaan di bidang jasa', 'anginribut@gmail.com', 8562, 'HRD'),
(6, 'PT.MAKMUR SENTOSA', 'JASA', 'Bandung', 'Minuman', 'jaya@gmail.com', 335352, 'HDR'),
(7, 'PT. MAKMUR', 'JASA', 'Bandung', 'Minuman', 'jaya@gmail.com', 335352, 'HDR');

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `id` int(30) NOT NULL,
  `nama_skill` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_role` int(1) NOT NULL,
  `user_status` int(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `engineer`
--
ALTER TABLE `engineer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `portfolio`
--
ALTER TABLE `portfolio`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `engineer`
--
ALTER TABLE `engineer`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `experience`
--
ALTER TABLE `experience`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `portfolio`
--
ALTER TABLE `portfolio`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `recruiter`
--
ALTER TABLE `recruiter`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `skill`
--
ALTER TABLE `skill`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
