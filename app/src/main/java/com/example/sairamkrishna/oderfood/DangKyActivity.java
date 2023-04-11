package com.example.sairamkrishna.oderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sairamkrishna.oderfood.Database.CreateDatabase;

import java.text.ParseException;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener{

    EditText edTenDangNhapDK, edMatKhauDK , edNgaySinhDK, edCCCDK;
    Button btnDongYDK, btnThoatDk;
    RadioGroup rgGioiTinh;
    CreateDatabase createDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);

        createDatabase = new CreateDatabase(this);
        createDatabase.open();

        edTenDangNhapDK = (EditText)findViewById(R.id.edTenDangNhapDK);
        edMatKhauDK = (EditText)findViewById(R.id.edMatKhauDK);
        edNgaySinhDK = (EditText)findViewById(R.id.edNgaySinhDK);
        edCCCDK = (EditText)findViewById(R.id.edCCCĐK);
        rgGioiTinh = (RadioGroup)findViewById(R.id.RgGioiTinh);
        btnDongYDK = (Button)findViewById(R.id.btnDongYDK);
        btnThoatDk = (Button)findViewById(R.id.btnThoatDk);

        btnDongYDK.setOnClickListener(this);
        btnThoatDk.setOnClickListener(this);
        edNgaySinhDK.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDongYDK:
                // Lưu thông tin người dùng vào database
                luuThongTin();
                break;
            case R.id.btnThoatDk:
                // Đóng activity đăng ký
                finish();
                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (view.getId() == R.id.edNgaySinhDK && !b) {
            // Kiểm tra định dạng ngày sinh
            kiemTraNgaySinh();
        }
    }

    private void luuThongTin() {
        // Lấy thông tin từ các EditText và RadioButton và lưu vào database
        String tenDangNhap = edTenDangNhapDK.getText().toString();
        String matKhau = edMatKhauDK.getText().toString();
        String ngaySinh = edNgaySinhDK.getText().toString();
        String ccc = edCCCDK.getText().toString();
        int gioiTinhId = rgGioiTinh.getCheckedRadioButtonId();
        rgGioiTinh = (RadioGroup) findViewById(gioiTinhId);
        String gioiTinh = rgGioiTinh.getText().toString();

        CreateDatabase.themNguoiDung(tenDangNhap, matKhau, gioiTinh, ngaySinh, ccc);
    }

    private void kiemTraNgaySinh() {
        // Kiểm tra định dạng ngày sinh, thông báo nếu không đúng
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(edNgaySinhDK.getText().toString());
        } catch (ParseException e) {
            Toast.makeText(this, "Vui lòng nhập định dạng ngày sinh dd/MM/yyyy", Toast.LENGTH_SHORT).show();
            edNgaySinhDK.requestFocus();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Đóng kết nối với database
        createDatabase.close();
    }
}