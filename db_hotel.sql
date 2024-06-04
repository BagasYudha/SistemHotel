-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Jun 2024 pada 14.38
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_hotel`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_booking_kamar`
--

CREATE TABLE `tb_booking_kamar` (
  `id_booking` varchar(10) NOT NULL,
  `id_staff` varchar(11) DEFAULT NULL,
  `id_tamu` int(11) DEFAULT NULL,
  `id_kamar` varchar(11) DEFAULT NULL,
  `durasi_sewa` int(3) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `status_pembayaran` enum('Lunas','Belum Lunas','','') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_booking_kamar`
--

INSERT INTO `tb_booking_kamar` (`id_booking`, `id_staff`, `id_tamu`, `id_kamar`, `durasi_sewa`, `total`, `status_pembayaran`) VALUES
('18', '2', 111, '117', 2, 1600000.00, 'Lunas'),
('30', 'M30', 115, 'S122', 6, 4800000.00, 'Lunas');

--
-- Trigger `tb_booking_kamar`
--
DELIMITER $$
CREATE TRIGGER `set_kamar_available_after_delete` AFTER DELETE ON `tb_booking_kamar` FOR EACH ROW BEGIN
    UPDATE tb_kamar
    SET status = 'Tersedia'
    WHERE id_kamar = OLD.id_kamar;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `set_kamar_status_unavailable_after_insert` AFTER INSERT ON `tb_booking_kamar` FOR EACH ROW BEGIN
    UPDATE tb_kamar
    SET status = 'Tidak Tersedia'
    WHERE id_kamar = NEW.id_kamar;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kamar`
--

CREATE TABLE `tb_kamar` (
  `id_kamar` varchar(11) NOT NULL,
  `tipe_kamar` varchar(50) DEFAULT NULL,
  `harga` int(10) DEFAULT NULL,
  `fasilitas` text DEFAULT NULL,
  `status` enum('Tersedia','Tidak Tersedia') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_kamar`
--

INSERT INTO `tb_kamar` (`id_kamar`, `tipe_kamar`, `harga`, `fasilitas`, `status`) VALUES
('D114', 'Deluxe Room', 800000, 'Lorem ipsum dolor sit', 'Tersedia'),
('D121', 'Deluxe Room', 700000, 'Kolam', 'Tersedia'),
('J123', 'Junior Suite', 700000, 'Kolam', 'Tersedia'),
('J132', 'Junior Suite', 700000, 'Ranjang', 'Tersedia'),
('S122', 'Suite', 800000, 'Kolam', 'Tidak Tersedia');

--
-- Trigger `tb_kamar`
--
DELIMITER $$
CREATE TRIGGER `before_insert_tb_kamar` BEFORE INSERT ON `tb_kamar` FOR EACH ROW BEGIN
    SET NEW.id_kamar = CONCAT(SUBSTRING(NEW.tipe_kamar, 1, 1), NEW.id_kamar);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_staff`
--

CREATE TABLE `tb_staff` (
  `id_staff` varchar(11) NOT NULL,
  `no_identitas` int(30) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `jabatan` varchar(20) DEFAULT NULL,
  `kontak` varchar(20) DEFAULT NULL,
  `alamat` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_staff`
--

INSERT INTO `tb_staff` (`id_staff`, `no_identitas`, `nama`, `jabatan`, `kontak`, `alamat`) VALUES
('2', 0, 'Gading', 'Kayrawan', 'gading@gmail.com', 'Madiun'),
('M30', 35426642, 'DImas', 'Manager', '0823426737', 'Ngawi'),
('M32', 3548930, 'Waluyo', 'Manager', '0825416738', 'Ngawi'),
('R20', 3540012, 'Faiz', 'Receptionist', '081234352737', 'Pacitan');

--
-- Trigger `tb_staff`
--
DELIMITER $$
CREATE TRIGGER `before_insert_tb_staff` BEFORE INSERT ON `tb_staff` FOR EACH ROW BEGIN
    DECLARE first_letter CHAR(1);
    SET first_letter = SUBSTRING(NEW.jabatan, 1, 1);
    SET NEW.id_staff = CONCAT(first_letter, NEW.id_staff);
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `validasi_nama_staff_ketika_update` BEFORE UPDATE ON `tb_staff` FOR EACH ROW BEGIN
    DECLARE has_number BOOLEAN;

    SET has_number = NEW.nama REGEXP '[0-9]';
    
    IF has_number THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nama staff tidak boleh mengandung angka';
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `validasi_nama_staff_sebelum_insert` BEFORE INSERT ON `tb_staff` FOR EACH ROW BEGIN
    DECLARE has_number BOOLEAN;
   
    SET has_number = NEW.nama REGEXP '[0-9]';
    
    IF has_number THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nama staff tidak boleh mengandung angka';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_tamu`
--

CREATE TABLE `tb_tamu` (
  `id_tamu` int(11) NOT NULL,
  `no_identitas` int(11) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(60) DEFAULT NULL,
  `kontak` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tb_tamu`
--

INSERT INTO `tb_tamu` (`id_tamu`, `no_identitas`, `nama`, `alamat`, `kontak`) VALUES
(111, 3540073, 'Yudha', 'Paron, Ngawi', '082224010532'),
(112, 35402736, 'Bagas', 'Paron, Ngawi', '08122346387'),
(113, 3540005, 'Ardi', 'Madiun', '0823571834'),
(114, 3540282, 'Karim', 'Ponorogo', '0821873619'),
(115, 3540004, 'Faiz', 'Ngawi', '087241663848');

--
-- Trigger `tb_tamu`
--
DELIMITER $$
CREATE TRIGGER `validasi_nama_tamu_sebelum_insert` BEFORE UPDATE ON `tb_tamu` FOR EACH ROW BEGIN
    DECLARE has_number BOOLEAN;
    
    -- Check if the new name contains any digits
    SET has_number = NEW.nama REGEXP '[0-9]';
    
    IF has_number THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nama staff tidak boleh mengandung angka';
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `validasi_nama_tamu_sebelum_update` BEFORE UPDATE ON `tb_tamu` FOR EACH ROW BEGIN
    DECLARE has_number BOOLEAN;
    
    SET has_number = NEW.nama REGEXP '[0-9]';
    
    IF has_number THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nama staff tidak boleh mengandung angka';
    END IF;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_booking_kamar`
--
ALTER TABLE `tb_booking_kamar`
  ADD PRIMARY KEY (`id_booking`),
  ADD UNIQUE KEY `id_kamar` (`id_kamar`),
  ADD KEY `id_tamu` (`id_tamu`),
  ADD KEY `fk_staff` (`id_staff`);

--
-- Indeks untuk tabel `tb_kamar`
--
ALTER TABLE `tb_kamar`
  ADD PRIMARY KEY (`id_kamar`);

--
-- Indeks untuk tabel `tb_staff`
--
ALTER TABLE `tb_staff`
  ADD PRIMARY KEY (`id_staff`);

--
-- Indeks untuk tabel `tb_tamu`
--
ALTER TABLE `tb_tamu`
  ADD PRIMARY KEY (`id_tamu`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_booking_kamar`
--
ALTER TABLE `tb_booking_kamar`
  ADD CONSTRAINT `fk_staff` FOREIGN KEY (`id_staff`) REFERENCES `tb_staff` (`id_staff`),
  ADD CONSTRAINT `tb_booking_kamar_ibfk_1` FOREIGN KEY (`id_tamu`) REFERENCES `tb_tamu` (`id_tamu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
