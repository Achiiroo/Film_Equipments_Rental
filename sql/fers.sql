-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2024 at 08:02 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fers`
--

-- --------------------------------------------------------

--
-- Table structure for table `fers_users`
--

CREATE TABLE `fers_users` (
  `user_id` int(50) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `address` text NOT NULL,
  `phone_number` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fers_users`
--

INSERT INTO `fers_users` (`user_id`, `full_name`, `email`, `password`, `user_type`, `address`, `phone_number`) VALUES
(10, 'JohnDave', 'johndavebriones@gmail.com', 'admin123', 'Admin', 'Brgy.Tanggoy', '09165905802'),
(11, 'LinuxAdona', 'Linux@gmail.com', 'Linux123', 'Customer', 'Brgy.Malalay', '09156847372'),
(12, 'Admin2', 'Admin2@gmail.com', 'admin123', 'Admin', 'Brgy.Bucana', '09183472832');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `rental_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `Amount_Paid` decimal(10,2) NOT NULL,
  `Payment_Date` datetime NOT NULL,
  `Payment_Method` enum('Cash','Credit Card') NOT NULL,
  `Payment_Status` enum('Paid','Pending','Refunded','Failed') NOT NULL,
  `Penalty_Fee` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rentals`
--

CREATE TABLE `rentals` (
  `rent_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `Rent_Start` datetime NOT NULL,
  `Rent_End` datetime NOT NULL,
  `Actual_Rent_Date` datetime NOT NULL,
  `Total_Amount` decimal(10,2) NOT NULL,
  `status` enum('available','not available') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rental_equipments`
--

CREATE TABLE `rental_equipments` (
  `item_id` int(11) NOT NULL,
  `Category` varchar(255) NOT NULL,
  `Equipment_Name` varchar(255) NOT NULL,
  `Brand` varchar(100) NOT NULL,
  `Model_Number` varchar(255) NOT NULL,
  `Condition` enum('New','Good','Damaged') NOT NULL DEFAULT 'New',
  `Availability` enum('Available','Rented') NOT NULL DEFAULT 'Available'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fers_users`
--
ALTER TABLE `fers_users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`rent_id`);

--
-- Indexes for table `rental_equipments`
--
ALTER TABLE `rental_equipments`
  ADD PRIMARY KEY (`item_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fers_users`
--
ALTER TABLE `fers_users`
  MODIFY `user_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `rentals`
--
ALTER TABLE `rentals`
  MODIFY `rent_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rental_equipments`
--
ALTER TABLE `rental_equipments`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
