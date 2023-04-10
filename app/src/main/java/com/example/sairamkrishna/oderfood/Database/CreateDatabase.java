package com.example.sairamkrishna.oderfood.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CreateDatabase extends SQLiteOpenHelper {

    public static String tb_KhachHang = "KHACHHANG";
    public static String tb_LoaiMon = "LOAIMON";
    public static String tb_MonAn = "MONAN";
    public static String tb_ChiTietDatMon = "CHITIETDATMON" ;

    public static String tb_KhachHang_MaKH = "MAKH";
    public static String tb_KhachHang_TenKH = "TENKH";
    public static String tb_KhachHang_MkKH = "MKKH";
    public static String tb_KhachHang_GioiTinh = "GIOITINH" ;
    public static String tb_KhachHang_NgaySinh = "NGAYSINH" ;
    public static String tb_KhachHang_CMND = "CMND" ;

    public static String tb_LoaiMon_MaLoai = "MALOAI";
    public static String tb_LoaiMon_TenLoai = "TENLOAI";

    public static String tb_MonAn_MaMonAn = "MAMONAN";
    public static String tb_MonAn_TenMonAn = "TENMONAN";
    public static String tb_MonAn_Gia = "GIA";
    public static String tb_MonAn_MaLoai = "MALOAI";

    public static String tb_ChiTietDatMon_MaDatMon = "MADATMON";
    public static String tb_ChiTietDatMon_MaMonAn = "MAMONAN";
    public static String tb_ChiTietDatMon_MaKH = "MAKH";
    public static String tb_ChiTietDatMon_SoLuong = "SOLUONG";
    public static String tb_ChiTietDatMon_TongTien = "TONGTIEN";

    public CreateDatabase( Context context) {
        /*context, name, factory,version*/
        super(context, "OrderFood",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbKhachHang = "CREATE TABLE " + tb_KhachHang + " ( " + tb_KhachHang_MaKH + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tb_KhachHang_TenKH + " TEXT, " + tb_KhachHang_MkKH + " TEXT, " + tb_KhachHang_GioiTinh + " TEXT, "
                + tb_KhachHang_NgaySinh + " TEXT, " + tb_KhachHang_CMND + " INTEGER )";
        String tbLoaiMon = "CREATE TABLE " + tb_LoaiMon + " ( " + tb_LoaiMon_MaLoai + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tb_LoaiMon_TenLoai + " TEXT )";
        String tbMonAn = "CREATE TABLE " + tb_MonAn + " ( " + tb_MonAn_MaMonAn + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tb_MonAn_TenMonAn + " TEXT, " + tb_MonAn_MaLoai + " INTEGER " + tb_MonAn_Gia + " TEXT )";
        String tbChiTietDatMon = "CREATE TABLE " + tb_ChiTietDatMon + " ( " + tb_ChiTietDatMon_MaDatMon + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + tb_ChiTietDatMon_MaKH + " INTEGER, " + tb_ChiTietDatMon_MaMonAn + " INTEGER, " + tb_ChiTietDatMon_SoLuong  ;

        /*Thực thi truy vấn*/
        db.execSQL(tbKhachHang);
        db.execSQL(tbLoaiMon);
        db.execSQL(tbMonAn);
        db.execSQL(tbChiTietDatMon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    /*Mở kết nối CSDL*/
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
