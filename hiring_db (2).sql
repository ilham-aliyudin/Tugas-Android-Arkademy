-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 14, 2021 at 01:31 PM
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
-- Database: `hiring_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `engineer`
--

CREATE TABLE `engineer` (
  `id` int(30) NOT NULL,
  `id_user` int(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jobdesc` varchar(100) NOT NULL,
  `lokasi` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `skill` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `engineer`
--

INSERT INTO `engineer` (`id`, `id_user`, `nama`, `jobdesc`, `lokasi`, `status`, `deskripsi`, `skill`) VALUES
(22, 19, 'Ryunoesuke', 'Web Developer', 'Surabaya', 'Freelancer', 'Native Mobile Programmer with Kotlin', 'PHP'),
(23, 22, 'Ryunoesuke', 'Mobile Developer', 'Banten', 'Freelancer', 'Mobile Developer With Kotlin', 'Kotlin'),
(24, 23, 'Fahmi Almaemuni', 'Developer Opsir', 'Indramayu', 'Full time', 'System Administrator', 'Kubernetes'),
(25, 24, 'Haetami', 'Mobile Developer', 'Banten', 'Freelancer', 'Mobile Developer', 'Java'),
(26, 25, 'Hilmi', 'Mobile Developer', 'Bandung', 'Freelancer', 'Moblie Developer', 'Kotlin'),
(27, 26, 'Hilmi Imamimudin', 'Mobile Developer', 'Bangka Belitung', 'Fulltime', 'Mobile Developer', 'Kotlin'),
(35, 27, 'Muhammad Arief Khoer', 'Sys Admin', 'Banten', 'Linux System Administrator', 'Fulltime', 'Kubernetes'),
(36, 29, 'Reihan Bayzaki', 'Mobile Developer', 'Jateng', 'deskripsi', 'fulltime', 'kotlin'),
(37, 31, 'Imam Ramadhan Hamzah', 'Web Developer', 'Majalengka', 'Saya adalah seorang web developer', 'Fulltime', 'kotlin'),
(38, 32, 'Hariri Alfaridzi', 'Web Deceloper', 'Surakarta', 'Seorang Web Developer Magang', 'Fulltime', 'kotlin'),
(39, 32, '', '', '', '', '', 'kotlin'),
(40, 32, 'Hariri Alfaridzi', 'Web developer', 'Surabaya', '-', 'Freelancer', 'kotlin');

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE `experience` (
  `id` int(30) NOT NULL,
  `company_name` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  `start_periode` varchar(20) NOT NULL,
  `end_periode` varchar(20) NOT NULL,
  `description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `experience`
--

INSERT INTO `experience` (`id`, `company_name`, `position`, `start_periode`, `end_periode`, `description`) VALUES
(1, 'PT MAHA RAJA', 'SYS ADMIN', '20 Agustus 2011', '17 Agustus 2017', 'No Description');

-- --------------------------------------------------------

--
-- Table structure for table `hire`
--

CREATE TABLE `hire` (
  `id_hire` int(100) NOT NULL,
  `id_engineer` int(100) NOT NULL,
  `id_project` int(30) NOT NULL,
  `price` int(100) NOT NULL,
  `confirm_status` enum('Confirmed','Rejected','Pending') NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updatedAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hire`
--

INSERT INTO `hire` (`id_hire`, `id_engineer`, `id_project`, `price`, `confirm_status`, `createdAt`, `updatedAt`) VALUES
(1, 24, 1, 300000, 'Confirmed', '2020-10-27 17:15:48', '2020-10-27 12:42:02'),
(2, 24, 2, 400000, 'Pending', '2020-10-27 17:18:11', '2020-10-27 13:51:01');

-- --------------------------------------------------------

--
-- Table structure for table `portfolio`
--

CREATE TABLE `portfolio` (
  `id` int(30) NOT NULL,
  `id_engineer` int(30) NOT NULL,
  `nama_app` varchar(100) NOT NULL,
  `link_github` varchar(100) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `portfolio`
--

INSERT INTO `portfolio` (`id`, `id_engineer`, `nama_app`, `link_github`, `deskripsi`, `image`) VALUES
(5, 36, 'bedah', 'Disini link githubnya', 'Ini Deskripsi', 'image-1601184894510-apis-for-marketers.png');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id_project` int(30) NOT NULL,
  `project_name` varchar(100) NOT NULL,
  `description` varchar(100) NOT NULL,
  `deadline` datetime NOT NULL,
  `image` varchar(100) NOT NULL,
  `id_recruiter` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id_project`, `project_name`, `description`, `deadline`, `image`, `id_recruiter`) VALUES
(1, 'Membangun Website Sekolah', 'Membangun website sekolah untuk platform Android', '2020-10-12 19:42:18', '', 44),
(2, 'Membangun Aplikasi Kasir', 'Membangun Aplikasi Kasir Untuk Retail', '2020-10-31 00:16:48', '', 44);

-- --------------------------------------------------------

--
-- Table structure for table `recruiter`
--

CREATE TABLE `recruiter` (
  `id` int(20) NOT NULL,
  `id_user` int(30) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `lokasi` varchar(20) NOT NULL,
  `bidang` varchar(20) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `kontak` bigint(100) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `linked_in` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `recruiter`
--

INSERT INTO `recruiter` (`id`, `id_user`, `nama`, `lokasi`, `bidang`, `deskripsi`, `kontak`, `jabatan`, `linked_in`) VALUES
(44, 15, 'PT Gudang Garam', 'Jawa Timur', 'Perusahaan Perbankan', 'Pabrik Rokok', 1234567, 'HRD', 'linkedinKu');

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `id_skill` int(30) NOT NULL,
  `nama_skill` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`id_skill`, `nama_skill`) VALUES
(1, ''),
(2, 'kotlin');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(100) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_password` varchar(200) NOT NULL,
  `phone` bigint(100) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  `user_role` int(1) NOT NULL,
  `user_status` int(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user_name`, `user_password`, `phone`, `user_email`, `user_role`, `user_status`, `created_at`, `updated_at`) VALUES
(15, 'ilham', '$2a$10$GG/ajhJM.XPAa5xSmFAa5.0ka38K2TuBlm.x9hK1zxa63FKJso1oe', 85624341817, 'ilham@gmail.com', 1, 1, '2020-10-15 05:04:48', '2020-10-15 05:04:48'),
(19, 'ardi', '$2a$10$VHLHSR6/kAjZbQfclaSm.uoZ4AjyDvttMfwnJ76xrmSZgZ1lCOdXK', 87724341817, 'ardi@gmail.com', 2, 2, '2020-10-26 08:06:47', '2020-10-26 08:06:47'),
(22, 'wahid', '$2a$10$6Kb39pEcMdsHzQcJfvZAz.j7IrBVNoAepfWtZd/yl7wSTdjCM5oGG', 87724341817, 'wahid@gmail.com', 2, 2, '2020-10-26 08:11:50', '2020-10-26 08:11:50'),
(23, 'fahmi almaemuni', '$2a$10$5iC4.SRJxnzjONQiy8GWEu2ZiOvHzqhfDkBKWYRAZ4IvAelZFTdbK', 628999390, 'fahmi@gmail.com', 2, 2, '2020-10-26 14:34:01', '2020-10-26 14:34:01'),
(24, 'muhammad haetami', '$2a$10$yKgiMxDYz8mQNMJFdVrviuOWejtn01CfqfXgXiUChO6m.XsuuuQo2', 87724341817, 'haetamin@gmail.com', 2, 2, '2020-10-27 00:25:16', '2020-10-27 00:25:16'),
(25, 'hilmi aziz', '$2a$10$Me1PloLCBlKmmojyWR9kneTwAhnwmgexVLffU0HMbdSbhB9uUK64i', 6287724541918, 'hilmi@gmail.com', 2, 2, '2020-10-27 00:25:56', '2020-10-27 00:25:56'),
(26, 'hilmi imammudin', '$2a$10$X2h3b124/7fMn5VqZ61ENeyQMLuSG1sX5.yAiLY/qwSKHDgnbxMd6', 87724341817, 'imammudin@gmail.com', 2, 2, '2020-10-27 00:49:03', '2020-10-27 00:49:03'),
(27, 'M Arief Khoeruddin', '$2a$10$75I986B.agZsQRafEjvBG.TcyOVuucVKZeQ07MUA66Cftip9obrFS', 6287724341817, 'arif@gmail.com', 2, 2, '2020-11-01 15:49:20', '2020-11-01 15:49:20'),
(29, 'Reihan Bayzaki', '$2a$10$3QNwX6lmLtZimcqmQNNWMeBa/onGcYi.UDVbO2QjFK7YtxPT9qH9K', 6287724341817, 'reihan@gmail.com', 2, 2, '2020-11-02 13:20:41', '2020-11-02 13:20:41'),
(31, 'imam ramadhan hamzah', '$2a$10$lyZPMK12Xr5ndijL2GHCeePV89PTw34FMqD2HXHwYB9EUVA8j.RTG', 6287724341817, 'imam@gmail.com', 2, 2, '2020-11-02 13:27:13', '2020-11-02 13:27:13'),
(32, 'hariri alfaridzi', '$2a$10$Rg3zfgDbo6w1O5Zuguh9ruR8JPmtYDfoutAqv1E2sGdz4kjF0fdea', 87724341516, 'hariri@gmail.com', 2, 2, '2020-12-21 04:00:42', '2020-12-21 04:00:42');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `engineer`
--
ALTER TABLE `engineer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `engineer_ibfk_1` (`id_user`);

--
-- Indexes for table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hire`
--
ALTER TABLE `hire`
  ADD PRIMARY KEY (`id_hire`),
  ADD KEY `hire_ibfk_1` (`id_project`),
  ADD KEY `hire_ibfk_2` (`id_engineer`);

--
-- Indexes for table `portfolio`
--
ALTER TABLE `portfolio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_engineer` (`id_engineer`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id_project`),
  ADD KEY `id_recruiter` (`id_recruiter`);

--
-- Indexes for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id_skill`);

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
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `experience`
--
ALTER TABLE `experience`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `hire`
--
ALTER TABLE `hire`
  MODIFY `id_hire` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `portfolio`
--
ALTER TABLE `portfolio`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id_project` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `recruiter`
--
ALTER TABLE `recruiter`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `skill`
--
ALTER TABLE `skill`
  MODIFY `id_skill` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `engineer`
--
ALTER TABLE `engineer`
  ADD CONSTRAINT `engineer_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hire`
--
ALTER TABLE `hire`
  ADD CONSTRAINT `hire_ibfk_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hire_ibfk_2` FOREIGN KEY (`id_engineer`) REFERENCES `engineer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `portfolio`
--
ALTER TABLE `portfolio`
  ADD CONSTRAINT `portfolio_ibfk_1` FOREIGN KEY (`id_engineer`) REFERENCES `engineer` (`id`);

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `project_ibfk_1` FOREIGN KEY (`id_recruiter`) REFERENCES `recruiter` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `recruiter`
--
ALTER TABLE `recruiter`
  ADD CONSTRAINT `recruiter_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
