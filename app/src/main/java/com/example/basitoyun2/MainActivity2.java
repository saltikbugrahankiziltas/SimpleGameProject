package com.example.basitoyun2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtKalanHak,txtSonuc;
    private EditText editSayı;
    private String gelenDeger;
    private int Hak=3, randomSayi;
    private Random randomNumber;
    private boolean tahmin=false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtKalanHak=findViewById(R.id.txtkalanHak);
        txtSonuc=findViewById(R.id.txtSonuc);
        editSayı=findViewById(R.id.editSayı);
        editSayı.setShowSoftInputOnFocus(false);
        randomNumber=new Random();
        randomSayi=randomNumber.nextInt(10)+1;
        System.out.println("Random sayi:"+randomSayi);

    }
    public void btnTahminEt(View view){
        gelenDeger=editSayı.getText().toString();
        if(!TextUtils.isEmpty(gelenDeger)){
            if(Hak>0&& tahmin==false){
                if(gelenDeger.equals(String.valueOf(randomSayi))){
                    sonucGoster("Tahmininiz doğru");
                    tahmin=true;
                }
                else {
                    txtSonuc.setText("Yanlış tahminde bulundunuz...");
                    editSayı.setText("");
                }

                Hak--;
                txtKalanHak.setText("Kalan Hakkınız: "+Hak);

                if(Hak==0 && tahmin==false) {
                    sonucGoster("Tahmin hakkınız bitti");
                    editSayı.setText(" ");
                }
            }
            else
                txtSonuc.setText("Oyun Bitti......");
        }
        else
            txtSonuc.setText("Girilen değer boş olamaz....");
    }

    private void sonucGoster(String mesaj) {
        editSayı.setEnabled(false);
        txtSonuc.setText(mesaj);
    }
}

