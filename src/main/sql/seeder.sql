drop database if exists blog_db;

create database if not exists blog_db;
use blog_db;


create table if not exists posts(
   id INT UNSIGNED NOT NULL AUTO_INCREMENT,
   body VARCHAR(255) NOT NULL,
   title VARCHAR(255) NOT NULL,
   file_path VARCHAR(255) NOT NULL,
   PRIMARY KEY (id)
);

