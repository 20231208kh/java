CREATE DATABASE IF NOT EXISTS UNIVERSITY;

USE UNIVERSITY;

DROP TABLE IF EXISTS STUDENT;
CREATE TABLE IF NOT EXISTS STUDENT(
	ST_NUM CHAR(10) PRIMARY KEY,
    ST_NAME VARCHAR(20) NOT NULL,
    ST_MAJOR VARCHAR(20) NOT NULL,
    ST_GRADE INT NOT NULL DEFAULT 1
);
DROP TABLE IF EXISTS PROFESSOR;
CREATE TABLE IF NOT EXISTS PROFESSOR(
	PR_NUM CHAR(10) PRIMARY KEY,
    PR_NAME VARCHAR(20) NOT NULL,
    PR_ROOM VARCHAR(20),
    PR_MAJOR VARCHAR(20) NOT NULL
);
DROP TABLE IF EXISTS LECTURE;
CREATE TABLE IF NOT EXISTS LECTURE(
	LE_NUM CHAR(10) PRIMARY KEY,
    LE_TITLE VARCHAR(30) NOT NULL,
    LE_ROOM VARCHAR(30),
    LE_SCHEDULE INT,
    LE_POINT INT,
    LE_TIME INT NOT NULL,
    LE_PR_NUM CHAR(10) NOT NULL,
    
    FOREIGN KEY(LE_PR_NUM) REFERENCES PROFESSOR(PR_NUM)
);
DROP TABLE IF EXISTS COURSE;
CREATE TABLE IF NOT EXISTS COURSE(
	CO_NUM INT PRIMARY KEY,
    CO_ST_NUM CHAR(10) NOT NULL,
    CO_LE_NUM CHAR(10) NOT NULL,
    
    FOREIGN KEY(CO_ST_NUM) REFERENCES STUDENT(ST_NUM),
    FOREIGN KEY(CO_LE_NUM) REFERENCES LECTURE(LE_NUM)
);
DROP TABLE IF EXISTS CONTACT;
CREATE TABLE IF NOT EXISTS CONTACT(
	CT_ST_NUM CHAR(10) PRIMARY KEY,
    CT_PHONE VARCHAR(20) NOT NULL,
    CT_ADDR TEXT NOT NULL,
    CT_DETAIL TEXT NOT NULL ,
    
    FOREIGN KEY(CT_ST_NUM) REFERENCES STUDENT(ST_NUM)
);