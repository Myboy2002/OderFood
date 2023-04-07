package com.example.sairamkrishna.oderfood.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CreateDatabase extends SQLiteOpenHelper {

    public static String tb_KhachHang = "KHACHHANG";
    public static String tb_LoaiMon = "LOAIMON";
    public static String tb_MonAn = "MONAN";

    public CreateDatabase( Context context) {
        /*context, name, factory,version*/
        super(context, "OrderFood",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbKhachhang = ""
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
