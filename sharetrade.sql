-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2017 at 08:07 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `sharetrade`
--

-- --------------------------------------------------------

--
-- Table structure for table `companydetails`
--

CREATE TABLE IF NOT EXISTS `companydetails` (
`cmpnyid` int(10) NOT NULL,
  `cmpnyname` varchar(70) NOT NULL,
  `cmpnylogopath` varchar(100) NOT NULL,
  `cmpnycode` int(11) NOT NULL,
  `cmpnylink` varchar(70) NOT NULL,
  `address` text NOT NULL,
  `sharetotal` int(15) NOT NULL,
  `sharecost` int(50) NOT NULL,
  `cmpnydescription` text NOT NULL,
  `phone` varchar(10) NOT NULL,
  `totalpurchase` int(15) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `companydetails`
--

INSERT INTO `companydetails` (`cmpnyid`, `cmpnyname`, `cmpnylogopath`, `cmpnycode`, `cmpnylink`, `address`, `sharetotal`, `sharecost`, `cmpnydescription`, `phone`, `totalpurchase`) VALUES
(15, 'Google Chrome', 'icon2.PNG', 2704, 'www.googlechrome.com', 'Gurgaon', 502, 100, 'we provide browsing', '87456921', 12),
(16, 'Mozilla Firefox', 'icon3.PNG', 9513, 'www.mozill.com', 'delhi', 145, 100, 'browser', '5469872', 10),
(17, 'window7', 'icon4.PNG', 4201, 'www.win.com', 'delhi', 45, 12, 'GUI', '45612301', 5);

-- --------------------------------------------------------

--
-- Table structure for table `sharedate`
--

CREATE TABLE IF NOT EXISTS `sharedate` (
`shareid` int(11) NOT NULL,
  `cmpnyid` int(11) NOT NULL,
  `date` date NOT NULL,
  `sharecost` int(11) NOT NULL,
  `sharenum` int(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sharedate`
--

INSERT INTO `sharedate` (`shareid`, `cmpnyid`, `date`, `sharecost`, `sharenum`) VALUES
(11, 10, '2017-04-27', 100, 0),
(15, 13, '2016-11-22', 34, 0),
(16, 14, '2013-02-01', 100, 0),
(17, 15, '2015-02-21', 100, 0),
(18, 16, '2014-12-14', 100, 0),
(19, 17, '2013-02-15', 12, 0),
(20, 17, '2016-05-27', 100, 0),
(21, 17, '2016-06-28', 125, 0),
(22, 17, '2016-08-15', 130, 0),
(23, 16, '2015-02-13', 50, 0),
(24, 16, '2015-11-30', 140, 0),
(25, 16, '2016-04-27', 20, 0),
(26, 15, '2015-11-16', 130, 0),
(27, 15, '2016-04-12', 200, 0),
(28, 15, '2016-09-05', 500, 0);

-- --------------------------------------------------------

--
-- Table structure for table `user_detail`
--

CREATE TABLE IF NOT EXISTS `user_detail` (
`id` int(3) NOT NULL,
  `first_name` varchar(15) CHARACTER SET latin1 NOT NULL,
  `last_name` varchar(15) CHARACTER SET latin1 NOT NULL,
  `email` varchar(40) CHARACTER SET latin1 NOT NULL,
  `password` varchar(40) CHARACTER SET latin1 NOT NULL,
  `address_1` varchar(20) CHARACTER SET latin1 NOT NULL,
  `address_2` varchar(40) CHARACTER SET latin1 NOT NULL,
  `city` varchar(20) CHARACTER SET latin1 NOT NULL,
  `state` varchar(30) CHARACTER SET latin1 NOT NULL,
  `pincode` varchar(6) NOT NULL,
  `mobile_no` varchar(10) NOT NULL,
  `card_type` varchar(20) NOT NULL,
  `card_no` varchar(20) NOT NULL,
  `expiry` date NOT NULL,
  `pay_gateway` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=hp8;

--
-- Dumping data for table `user_detail`
--

INSERT INTO `user_detail` (`id`, `first_name`, `last_name`, `email`, `password`, `address_1`, `address_2`, `city`, `state`, `pincode`, `mobile_no`, `card_type`, `card_no`, `expiry`, `pay_gateway`) VALUES
(5, 'Abhishek', 'Jain', 'jain.abhishek', '1230', '1/3042', 'Street No. 19, Ram Nagar', 'Shahdara', 'Delhi', '110032', '8882954306', 'debit', '2456987156324452', '2025-06-01', 'visa'),
(6, 'Sachin', 'Sharma', 'sachin.sharma', '1230', 'A-32', 'RST Enclave', 'Johripur', 'Delhi', '110094', '8882954306', 'credit', '9852147632549875', '2030-08-01', 'visa'),
(7, 'rahul', 'upadhyay', 'rahul@gmail.com', '1234', 'nirman vihar', 'laxmi nagar', 'delhi', 'Goa	', '110092', '9716408052', 'null', '    -    -    - ', '2017-01-01', 'null'),
(8, 'prakhar', 'kothari', 'prakhar@gmail.com', '1234', 'jaipur', 'jaipur', 'jaipur', 'Assam	', '123564', '9874561230', 'debit', '1234-1234-1234-1234', '2020-03-01', 'maestro'),
(9, 'Ayesha', 'Alam', 'admin', 'admin', 'Nirman vihar', 'laxmi nagar', 'delhi', 'Goa	', '110092', '8542362103', 'debit', '1234-5215-2123-6548', '2022-05-01', 'maestro');

-- --------------------------------------------------------

--
-- Table structure for table `user_work`
--

CREATE TABLE IF NOT EXISTS `user_work` (
`user_entry_id` int(11) NOT NULL,
  `id` int(10) NOT NULL,
  `company_id` int(10) NOT NULL,
  `total shares` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `companydetails`
--
ALTER TABLE `companydetails`
 ADD PRIMARY KEY (`cmpnyid`), ADD UNIQUE KEY `cmpnycode` (`cmpnycode`);

--
-- Indexes for table `sharedate`
--
ALTER TABLE `sharedate`
 ADD PRIMARY KEY (`shareid`);

--
-- Indexes for table `user_detail`
--
ALTER TABLE `user_detail`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `user_work`
--
ALTER TABLE `user_work`
 ADD PRIMARY KEY (`user_entry_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `companydetails`
--
ALTER TABLE `companydetails`
MODIFY `cmpnyid` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `sharedate`
--
ALTER TABLE `sharedate`
MODIFY `shareid` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `user_detail`
--
ALTER TABLE `user_detail`
MODIFY `id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `user_work`
--
ALTER TABLE `user_work`
MODIFY `user_entry_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
