create database thi_module3;
use thi_module3;
SET foreign_key_checks = 0;
create table hinh_thuc_thanh_toan(
	id_hinh_thuc int primary key,
    name_hinh_thuc varchar(50)
);

create table phong_tro(
	ma_phong_tro varchar(15) primary key,
    ten_nguoi_thue varchar(50) not null,
    sdt varchar(20) not null,
    ngay_thue datetime not null,
    hinh_thuc_thanh_toan int not null,
    ghi_chu varchar(200),
    FOREIGN KEY (hinh_thuc_thanh_toan)
        REFERENCES hinh_thuc_thanh_toan (id_hinh_thuc)
        ON UPDATE CASCADE ON DELETE CASCADE
);

insert into hinh_thuc_thanh_toan value (1, 'Tháng'), (2, 'Quý'), (3, 'Năm');
insert into phong_tro value ("PT-1", 'Mạnh Dũng', "0909477888", "2021-05-01",1,"Đã cọc trước 500k");