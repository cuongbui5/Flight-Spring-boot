-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- Dump data of "airlines" ---------------------------------
BEGIN;

INSERT INTO `airlines`(`id`,`code`,`logo_url`,`name`,`website_url`) VALUES 
( '1', 'VN', 'https://drive.google.com/uc?id=1_VTKsGPa0xmlvxVqDgVKWRBcadyo5ZDP', 'Vietnam Airlines', 'https://www.vietnamairlines.com/vn/vi/' ),
( '2', 'VJ', 'https://drive.google.com/uc?id=1zE1zSZhxb5iZ1pjOx9RKEnfs8BkoyOQS', 'Vietjet Air', 'https://www.vietjetair.com/' ),
( '3', 'QH', 'https://drive.google.com/uc?id=1f5QJjsL2L1IYQ_2TSFKPJ6IiM5b5V-Dd', 'Bamboo Airways', 'https://bambooairways.com/' ),
( '4', 'AK', 'https://asset.brandfetch.io/idtir4lMuo/idUJ5eqEed.jpeg', 'AirAsia', 'https://www.airasia.com/' ),
( '5', 'AL', 'https://drive.google.com/uc?id=1aEUtVbGfQET0rTF7rvcuHz3iCfJBDEIR', 'AirLineAsia', 'https://www.airasia.com/' ),
( '6', 'JQ', 'https://drive.google.com/uc?id=1DXPkVTZlsX58VxK2oQC2wBMxULpFAxzR', 'AirlineFake', 'https://www.airasia.com/' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "airports" ---------------------------------
BEGIN;

INSERT INTO `airports`(`latitude`,`longitude`,`id`,`city`,`code`,`country`,`name`) VALUES 
( '10.8188', '106.6511', '1', 'Hồ Chí Minh', 'SGN', 'Việt Nam', 'Tân Sơn Nhất International Airport' ),
( '21.2212', '105.8078', '2', 'Hà Nội', 'HAN', 'Việt Nam', 'Nội Bài International Airport' ),
( '16.0439', '108.1981', '3', 'Đà Nẵng', 'DAD', 'Việt Nam', 'Đà Nẵng International Airport' ),
( '10.227', '103.9637', '4', 'Phú Quốc', 'PQC', 'Việt Nam', 'Phú Quốc International Airport' ),
( '10.0854', '105.7113', '5', 'Cần Thơ', 'VCA', 'Việt Nam', 'Cần Thơ International Airport' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "bookings" ---------------------------------
BEGIN;

INSERT INTO `bookings`(`payment_status`,`booking_date`,`contact_info_id`,`fare_id`,`id`,`passenger_info_id`,`user_id`,`booking_code`) VALUES 
( b'1', '2024-03-15 10:21:48', '2', '1', '1', '1', '1', '370bad24-1b25-419f-90f9-79f5dc4657a5' ),
( b'1', '2024-03-15 10:24:16', '1', '201', '2', '2', '1', '426f5a2a-3d7a-4277-b392-e4fa7334a555' ),
( b'1', '2024-03-15 10:26:22', '1', '201', '3', '2', '1', 'dc681c55' ),
( b'1', '2024-03-15 10:26:41', '1', '201', '4', '2', '1', '8a3c2596-abd8-4dd9-8826-2b63c8c0da6b' ),
( b'1', '2024-03-15 16:45:26', '1', '197', '5', '3', '1', '0f59e67e' ),
( b'1', '2024-03-15 16:46:45', '3', '141', '6', '1', '1', '10b6c3b6' ),
( b'1', '2024-03-16 08:57:51', '2', '13', '7', '1', '1', 'ce064a76' ),
( b'1', '2024-03-16 09:03:47', '3', '13', '8', '2', '1', '30c6c307' ),
( b'1', '2024-03-16 09:36:27', '3', '21', '9', '1', '1', 'c22811a7' ),
( b'1', '2024-03-16 09:36:30', '3', '21', '10', '1', '1', '208a42c7' ),
( b'1', '2024-03-16 09:38:07', '3', '1', '11', '1', '1', 'c53dca21' ),
( b'1', '2024-03-16 18:00:53', '5', '1', '12', '4', '3', '386dcf34' ),
( b'1', '2024-03-16 18:01:26', '5', '201', '13', '4', '3', '07148d43' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "contact_infos" ----------------------------
BEGIN;

INSERT INTO `contact_infos`(`id`,`user_id`,`email`,`first_name`,`last_name`,`number_phone`) VALUES 
( '1', '1', 'buuicuong@gmail.com', 'bui', 'cuong', '0963347001' ),
( '2', '1', 'test@gmail.com', 'bui', 'hai', '0963325454' ),
( '3', '1', 'goku@gmail.com', 'go', 'ku', '123456789' ),
( '4', '3', 'user@gmail.com', 'new', 'user', '123456789' ),
( '5', '3', 'userfake@gmail.com', 'user', 'fake', '123456789' ),
( '6', '1', '', '', '', '' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "fares" ------------------------------------
BEGIN;

INSERT INTO `fares`(`price`,`flight_id`,`id`,`fare_class`) VALUES 
( '1500000', '1', '1', 'Economy' ),
( '3000000', '1', '2', 'PremiumEconomy' ),
( '4000000', '1', '3', 'Business' ),
( '4500000', '1', '4', 'FirstClass' ),
( '1600000', '2', '5', 'Economy' ),
( '3000000', '2', '6', 'PremiumEconomy' ),
( '4100000', '2', '7', 'Business' ),
( '5500000', '2', '8', 'FirstClass' ),
( '2454361', '3', '9', 'Economy' ),
( '2357829', '3', '10', 'PremiumEconomy' ),
( '3926062', '3', '11', 'Business' ),
( '4556824', '3', '12', 'FirstClass' ),
( '1505932', '4', '13', 'Economy' ),
( '2359187', '4', '14', 'PremiumEconomy' ),
( '3778142', '4', '15', 'Business' ),
( '4813147', '4', '16', 'FirstClass' ),
( '2231310', '5', '17', 'Economy' ),
( '2217109', '5', '18', 'PremiumEconomy' ),
( '3891613', '5', '19', 'Business' ),
( '4806739', '5', '20', 'FirstClass' ),
( '1858854', '6', '21', 'Economy' ),
( '2374057', '6', '22', 'PremiumEconomy' ),
( '3793720', '6', '23', 'Business' ),
( '4846430', '6', '24', 'FirstClass' ),
( '2350989', '7', '25', 'Economy' ),
( '2715655', '7', '26', 'PremiumEconomy' ),
( '3025307', '7', '27', 'Business' ),
( '4979570', '7', '28', 'FirstClass' ),
( '2321928', '8', '29', 'Economy' ),
( '2170931', '8', '30', 'PremiumEconomy' ),
( '3388873', '8', '31', 'Business' ),
( '4431570', '8', '32', 'FirstClass' ),
( '2491229', '9', '33', 'Economy' ),
( '2661439', '9', '34', 'PremiumEconomy' ),
( '3333506', '9', '35', 'Business' ),
( '4683215', '9', '36', 'FirstClass' ),
( '1915554', '10', '37', 'Economy' ),
( '2028126', '10', '38', 'PremiumEconomy' ),
( '3893968', '10', '39', 'Business' ),
( '4385464', '10', '40', 'FirstClass' ),
( '1745416', '11', '41', 'Economy' ),
( '2070686', '11', '42', 'PremiumEconomy' ),
( '3617182', '11', '43', 'Business' ),
( '4873851', '11', '44', 'FirstClass' ),
( '2017710', '12', '45', 'Economy' ),
( '2966999', '12', '46', 'PremiumEconomy' ),
( '3281864', '12', '47', 'Business' ),
( '4508325', '12', '48', 'FirstClass' ),
( '2196029', '13', '49', 'Economy' ),
( '2955174', '13', '50', 'PremiumEconomy' ),
( '3687781', '13', '51', 'Business' ),
( '4573382', '13', '52', 'FirstClass' ),
( '2303566', '14', '53', 'Economy' ),
( '2297685', '14', '54', 'PremiumEconomy' ),
( '3077729', '14', '55', 'Business' ),
( '4495588', '14', '56', 'FirstClass' ),
( '1744752', '15', '57', 'Economy' ),
( '2736997', '15', '58', 'PremiumEconomy' ),
( '3950729', '15', '59', 'Business' ),
( '4542655', '15', '60', 'FirstClass' ),
( '2361089', '16', '61', 'Economy' ),
( '2677481', '16', '62', 'PremiumEconomy' ),
( '3804135', '16', '63', 'Business' ),
( '4988232', '16', '64', 'FirstClass' ),
( '2028755', '17', '65', 'Economy' ),
( '2679081', '17', '66', 'PremiumEconomy' ),
( '3809139', '17', '67', 'Business' ),
( '4008450', '17', '68', 'FirstClass' ),
( '2114836', '18', '69', 'Economy' ),
( '2048829', '18', '70', 'PremiumEconomy' ),
( '3399637', '18', '71', 'Business' ),
( '4851700', '18', '72', 'FirstClass' ),
( '1559587', '19', '73', 'Economy' ),
( '2742833', '19', '74', 'PremiumEconomy' ),
( '3535408', '19', '75', 'Business' ),
( '4448538', '19', '76', 'FirstClass' ),
( '2136468', '20', '77', 'Economy' ),
( '2836725', '20', '78', 'PremiumEconomy' ),
( '3274219', '20', '79', 'Business' ),
( '4860923', '20', '80', 'FirstClass' ),
( '1981955', '21', '81', 'Economy' ),
( '2827009', '21', '82', 'PremiumEconomy' ),
( '3689177', '21', '83', 'Business' ),
( '4964861', '21', '84', 'FirstClass' ),
( '2256771', '22', '85', 'Economy' ),
( '2889273', '22', '86', 'PremiumEconomy' ),
( '3176050', '22', '87', 'Business' ),
( '4212433', '22', '88', 'FirstClass' ),
( '2034017', '24', '89', 'Economy' ),
( '2032783', '24', '90', 'PremiumEconomy' ),
( '3561867', '24', '91', 'Business' ),
( '4710985', '24', '92', 'FirstClass' ),
( '2369323', '25', '93', 'Economy' ),
( '2213659', '25', '94', 'PremiumEconomy' ),
( '3460327', '25', '95', 'Business' ),
( '4660657', '25', '96', 'FirstClass' ),
( '2422306', '23', '97', 'Economy' ),
( '2629559', '23', '98', 'PremiumEconomy' ),
( '3380875', '23', '99', 'Business' ),
( '4015700', '23', '100', 'FirstClass' ),
( '2435876', '23', '101', 'Economy' ),
( '2632281', '23', '102', 'PremiumEconomy' ),
( '3353773', '23', '103', 'Business' ),
( '4872026', '23', '104', 'FirstClass' ),
( '1798808', '26', '105', 'Economy' ),
( '2877964', '26', '106', 'PremiumEconomy' ),
( '3493394', '26', '107', 'Business' ),
( '4833077', '26', '108', 'FirstClass' ),
( '2185204', '27', '109', 'Economy' ),
( '2926790', '27', '110', 'PremiumEconomy' ),
( '3578339', '27', '111', 'Business' ),
( '4111325', '27', '112', 'FirstClass' ),
( '2321606', '28', '113', 'Economy' ),
( '2774057', '28', '114', 'PremiumEconomy' ),
( '3405467', '28', '115', 'Business' ),
( '4705165', '28', '116', 'FirstClass' ),
( '1809422', '29', '117', 'Economy' ),
( '2431614', '29', '118', 'PremiumEconomy' ),
( '3229806', '29', '119', 'Business' ),
( '4854186', '29', '120', 'FirstClass' ),
( '2081512', '30', '121', 'Economy' ),
( '2345002', '30', '122', 'PremiumEconomy' ),
( '3980476', '30', '123', 'Business' ),
( '4867373', '30', '124', 'FirstClass' ),
( '1895437', '31', '125', 'Economy' ),
( '2375067', '31', '126', 'PremiumEconomy' ),
( '3689024', '31', '127', 'Business' ),
( '4319920', '31', '128', 'FirstClass' ),
( '2032527', '32', '129', 'Economy' ),
( '2702873', '32', '130', 'PremiumEconomy' ),
( '3916785', '32', '131', 'Business' ),
( '4475307', '32', '132', 'FirstClass' ),
( '2126180', '33', '133', 'Economy' ),
( '2704977', '33', '134', 'PremiumEconomy' ),
( '3646348', '33', '135', 'Business' ),
( '4116809', '33', '136', 'FirstClass' ),
( '2145002', '34', '137', 'Economy' ),
( '2874582', '34', '138', 'PremiumEconomy' ),
( '3437905', '34', '139', 'Business' ),
( '4565778', '34', '140', 'FirstClass' ),
( '2015173', '35', '141', 'Economy' ),
( '2878533', '35', '142', 'PremiumEconomy' ),
( '3847146', '35', '143', 'Business' ),
( '4600133', '35', '144', 'FirstClass' ),
( '1959224', '36', '145', 'Economy' ),
( '2495721', '36', '146', 'PremiumEconomy' ),
( '3100935', '36', '147', 'Business' ),
( '4017512', '36', '148', 'FirstClass' ),
( '2284753', '37', '149', 'Economy' ),
( '2871230', '37', '150', 'PremiumEconomy' ),
( '3001891', '37', '151', 'Business' ),
( '4395763', '37', '152', 'FirstClass' ),
( '2473145', '38', '153', 'Economy' ),
( '2678437', '38', '154', 'PremiumEconomy' ),
( '3472749', '38', '155', 'Business' ),
( '4328432', '38', '156', 'FirstClass' ),
( '1723916', '39', '157', 'Economy' ),
( '2134282', '39', '158', 'PremiumEconomy' ),
( '3999662', '39', '159', 'Business' ),
( '4595463', '39', '160', 'FirstClass' ),
( '2478329', '40', '161', 'Economy' ),
( '2105258', '40', '162', 'PremiumEconomy' ),
( '3591300', '40', '163', 'Business' ),
( '4640729', '40', '164', 'FirstClass' ),
( '1929743', '41', '165', 'Economy' ),
( '2226528', '41', '166', 'PremiumEconomy' ),
( '3843414', '41', '167', 'Business' ),
( '4537482', '41', '168', 'FirstClass' ),
( '1657171', '42', '169', 'Economy' ),
( '2173408', '42', '170', 'PremiumEconomy' ),
( '3395529', '42', '171', 'Business' ),
( '4457418', '42', '172', 'FirstClass' ),
( '1600502', '43', '173', 'Economy' ),
( '2130259', '43', '174', 'PremiumEconomy' ),
( '3349788', '43', '175', 'Business' ),
( '4358162', '43', '176', 'FirstClass' ),
( '2241447', '44', '177', 'Economy' ),
( '2632748', '44', '178', 'PremiumEconomy' ),
( '3939401', '44', '179', 'Business' ),
( '4798761', '44', '180', 'FirstClass' ),
( '1675603', '45', '181', 'Economy' ),
( '2481732', '45', '182', 'PremiumEconomy' ),
( '3881851', '45', '183', 'Business' ),
( '4964057', '45', '184', 'FirstClass' ),
( '1674732', '46', '185', 'Economy' ),
( '2981491', '46', '186', 'PremiumEconomy' ),
( '3383257', '46', '187', 'Business' ),
( '4971811', '46', '188', 'FirstClass' ),
( '2209287', '47', '189', 'Economy' ),
( '2631002', '47', '190', 'PremiumEconomy' ),
( '3027149', '47', '191', 'Business' ),
( '4242739', '47', '192', 'FirstClass' ),
( '1632248', '48', '193', 'Economy' ),
( '2933022', '48', '194', 'PremiumEconomy' ),
( '3268366', '48', '195', 'Business' ),
( '4542764', '48', '196', 'FirstClass' ),
( '2432194', '49', '197', 'Economy' ),
( '2512294', '49', '198', 'PremiumEconomy' ),
( '3764890', '49', '199', 'Business' ),
( '4287568', '49', '200', 'FirstClass' ),
( '1643172', '50', '201', 'Economy' ),
( '2853153', '50', '202', 'PremiumEconomy' ),
( '3836251', '50', '203', 'Business' ),
( '4621793', '50', '204', 'FirstClass' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "flights" ----------------------------------
BEGIN;

INSERT INTO `flights`(`duration`,`stops`,`airline_id`,`arrival_airport_id`,`arrival_date`,`departure_airport_id`,`departure_date`,`id`,`aircraft_type`,`code`) VALUES 
( '120', '0', '1', '2', '2024-02-19 10:00:00', '1', '2024-02-19 08:00:00', '1', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '2', '2024-02-19 14:00:00', '1', '2024-02-19 12:00:00', '2', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '2', '2024-02-19 18:00:00', '1', '2024-02-19 16:00:00', '3', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '2', '2024-02-20 08:00:00', '1', '2024-02-19 20:00:00', '4', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '1', '2024-02-19 10:00:00', '2', '2024-02-19 08:00:00', '5', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '1', '2024-02-19 14:00:00', '2', '2024-02-19 12:00:00', '6', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '1', '2024-02-19 18:00:00', '2', '2024-02-19 16:00:00', '7', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '1', '2024-02-20 08:00:00', '2', '2024-02-19 20:00:00', '8', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '3', '2024-02-19 10:00:00', '1', '2024-02-19 08:00:00', '9', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '3', '2024-02-19 14:00:00', '1', '2024-02-19 12:00:00', '10', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '3', '2024-02-19 18:00:00', '1', '2024-02-19 16:00:00', '11', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '3', '2024-02-20 08:00:00', '1', '2024-02-19 20:00:00', '12', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '1', '2024-02-19 10:00:00', '3', '2024-02-19 08:00:00', '13', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '1', '2024-02-19 14:00:00', '3', '2024-02-19 12:00:00', '14', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '1', '2024-02-19 18:00:00', '3', '2024-02-19 16:00:00', '15', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '1', '2024-02-20 08:00:00', '3', '2024-02-19 20:00:00', '16', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '4', '2024-02-19 10:00:00', '1', '2024-02-19 08:00:00', '17', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '4', '2024-02-19 14:00:00', '1', '2024-02-19 12:00:00', '18', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '4', '2024-02-19 18:00:00', '1', '2024-02-19 16:00:00', '19', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '4', '2024-02-20 08:00:00', '1', '2024-02-19 20:00:00', '20', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '1', '2024-02-19 10:00:00', '4', '2024-02-19 08:00:00', '21', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '1', '2024-02-19 14:00:00', '4', '2024-02-19 12:00:00', '22', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '1', '2024-02-19 18:00:00', '4', '2024-02-19 16:00:00', '23', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '1', '2024-02-20 08:00:00', '4', '2024-02-19 20:00:00', '24', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '3', '2024-02-19 10:00:00', '2', '2024-02-19 08:00:00', '25', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '3', '2024-02-19 14:00:00', '2', '2024-02-19 12:00:00', '26', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '3', '2024-02-19 18:00:00', '2', '2024-02-19 16:00:00', '27', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '3', '2024-02-20 08:00:00', '2', '2024-02-19 20:00:00', '28', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '2', '2024-02-19 10:00:00', '3', '2024-02-19 08:00:00', '29', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '2', '2024-02-19 14:00:00', '3', '2024-02-19 12:00:00', '30', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '2', '2024-02-19 18:00:00', '3', '2024-02-19 16:00:00', '31', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '2', '2024-02-20 08:00:00', '3', '2024-02-19 20:00:00', '32', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '4', '2024-02-19 10:00:00', '2', '2024-02-19 08:00:00', '33', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '4', '2024-02-19 14:00:00', '2', '2024-02-19 12:00:00', '34', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '4', '2024-02-19 18:00:00', '2', '2024-02-19 16:00:00', '35', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '4', '2024-02-20 08:00:00', '2', '2024-02-19 20:00:00', '36', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '2', '2024-02-19 10:00:00', '4', '2024-02-19 08:00:00', '37', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '2', '2024-02-19 14:00:00', '4', '2024-02-19 12:00:00', '38', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '2', '2024-02-19 18:00:00', '4', '2024-02-19 16:00:00', '39', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '2', '2024-02-20 08:00:00', '4', '2024-02-19 20:00:00', '40', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '4', '2024-02-19 10:00:00', '3', '2024-02-19 08:00:00', '41', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '4', '2024-02-19 14:00:00', '3', '2024-02-19 12:00:00', '42', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '4', '2024-02-19 18:00:00', '3', '2024-02-19 16:00:00', '43', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '4', '2024-02-20 08:00:00', '3', '2024-02-19 20:00:00', '44', 'Boeing 787', 'VN787' ),
( '120', '0', '1', '3', '2024-02-19 10:00:00', '4', '2024-02-19 08:00:00', '45', 'Airbus A321', 'VN321' ),
( '120', '0', '2', '3', '2024-02-19 14:00:00', '4', '2024-02-19 12:00:00', '46', 'Boeing 737', 'VN737' ),
( '120', '0', '3', '3', '2024-02-19 18:00:00', '4', '2024-02-19 16:00:00', '47', 'Airbus A350', 'VN350' ),
( '540', '1', '4', '3', '2024-02-20 08:00:00', '4', '2024-02-19 20:00:00', '48', 'Boeing 787', 'VN787' ),
( '120', '0', '5', '2', '2024-02-19 10:00:00', '1', '2024-02-19 08:00:00', '49', 'Airbus A321', 'VN321' ),
( '120', '0', '6', '2', '2024-02-19 10:00:00', '1', '2024-02-19 08:00:00', '50', 'Airbus A321', 'VN321' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "users" ------------------------------------
BEGIN;

INSERT INTO `users`(`id`,`password`,`username`,`role`) VALUES 
( '1', '$2a$10$6DP2mQoe47qWLkAJxcnn9OWOc.OEomPpdfA6Q0jynaWBksQAk75zK', 'buicuong', 'USER' ),
( '2', '$2a$10$naGdKxHDV/InwhCofM99UOWp950954nU8atbMzrvDJddR6Pl4XGnG', 'thanhkd', 'USER' ),
( '3', '$2a$10$dLSDOWFv2ptBKUqmZvZ2XeIxV8W.Mz6F2eHG67tWd4H7TuWD5/QFC', 'acctest', 'USER' );
COMMIT;
-- ---------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


