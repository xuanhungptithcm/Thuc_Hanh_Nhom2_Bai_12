package com.example.th_bai_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    EditText txtName, txtPhone;
    ListView listViewInfo;
    ArrayList<String> listInfoAdapter = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String phone = txtPhone.getText().toString();
                if(!name.equals("") && !phone.equals("")) {
                    String data = "Tên: " + name + ", SDT:[" + phone + "]";
                    listInfoAdapter.add(data);
                    Toast.makeText(getApplicationContext(), "Thêm thông tin thành công", Toast.LENGTH_LONG).show();
                    txtName.setText("");
                    txtPhone.setText("");
                    txtPhone.clearFocus();
                    arrayAdapter.notifyDataSetChanged();
                } else {
                    if(name.equals("") && phone.equals("")) {
                        Toast.makeText(getApplicationContext(), "Vui lòng nhập Họ và Tên và Số điện thoại", Toast.LENGTH_LONG).show();
                        txtName.requestFocus();
                    }  else {
                        if(name.equals("")) {
                            Toast.makeText(getApplicationContext(), "Vui lòng nhập Họ và Tên", Toast.LENGTH_LONG).show();
                            txtName.requestFocus();
                        }
                        if(phone.equals("")) {
                            Toast.makeText(getApplicationContext(), "Vui lòng nhập Số điện thoại", Toast.LENGTH_LONG).show();
                            txtPhone.requestFocus();
                        }
                    }

                }
            }
        });
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listInfoAdapter);
        listViewInfo.setAdapter(arrayAdapter);

    }

    private void setControl() {
        btnSave = findViewById(R.id.btnSave);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        listViewInfo = findViewById(R.id.listViewInfo);
    }
}
