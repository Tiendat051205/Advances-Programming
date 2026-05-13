CREATE DATABASE IF NOT EXISTS hust_thesis_management;
USE hust_thesis_management;
-- 1. Bảng User gốc
CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    authority ENUM('STUDENT', 'LECTURER', 'ADMIN') NOT NULL
);

-- 2. Bảng Student (Nối 1:1 với User)
CREATE TABLE student (
    user_id BIGINT PRIMARY KEY,
    student_id VARCHAR(20) UNIQUE NOT NULL, -- MSSV thực tế
    full_name VARCHAR(100) NOT NULL,
    major VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- 3. Bảng Lecturer (Nối 1:1 với User)
CREATE TABLE lecturer (
    user_id BIGINT PRIMARY KEY,
    lecturer_id VARCHAR(20) UNIQUE NOT NULL, -- Mã giảng viên
    full_name VARCHAR(100) NOT NULL,
    faculty VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- 4. Bảng Admin (Nối 1:1 với User)
CREATE TABLE admin (
    user_id BIGINT PRIMARY KEY,
    admin_id VARCHAR(20) UNIQUE NOT NULL, -- Mã nhân viên
    full_name VARCHAR(100) NOT NULL,
    role ENUM('QLDT', 'TRUONG_KHOA', 'BAN_GIAM_DOC') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
-- 5. Bảng Đề tài
CREATE TABLE topic (
    topic_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    lecturer_user_id BIGINT NOT NULL,
    FOREIGN KEY (lecturer_user_id) REFERENCES lecturer(user_id)
);

-- 6. Bảng Giấy đề nghị (Proposal)
CREATE TABLE proposal (
    proposal_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_user_id BIGINT UNIQUE NOT NULL, -- Ràng buộc UNIQUE để mỗi SV chỉ nộp 1 đơn
    topic_id BIGINT NOT NULL,
    status ENUM('IN_PROGRESS', 'CONFIRMED', 'APPROVED', 'REJECTED') DEFAULT 'IN_PROGRESS',
    file_path VARCHAR(255),
    submission_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    approved_date DATETIME,
    FOREIGN KEY (student_user_id) REFERENCES student(user_id),
    FOREIGN KEY (topic_id) REFERENCES topic(topic_id)
);
-- 7. Bảng Luận văn hoàn chỉnh
CREATE TABLE thesis (
    thesis_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    proposal_id BIGINT UNIQUE NOT NULL, -- Nối 1:1 với đơn đã duyệt
    file_path VARCHAR(255),
    submission_date DATETIME,
    defense_date DATETIME,
    thesis_status ENUM('IN_PROGRESS', 'PASSED', 'FAILED') DEFAULT 'IN_PROGRESS',
    grade DECIMAL(4, 2),
    FOREIGN KEY (proposal_id) REFERENCES proposal(proposal_id)
);

-- 8. Bảng Biên nhận (Receipt)
CREATE TABLE receipt (
    receipt_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    receipt_number VARCHAR(50) UNIQUE NOT NULL, -- Số hiệu nhà trường
    thesis_id BIGINT UNIQUE NOT NULL,
    issue_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    admin_user_id BIGINT NOT NULL, -- đây sẽ là id của admin ứng với thông tin người cấp
    FOREIGN KEY (thesis_id) REFERENCES thesis(thesis_id),
    FOREIGN KEY (admin_user_id) REFERENCES admin(user_id)
);