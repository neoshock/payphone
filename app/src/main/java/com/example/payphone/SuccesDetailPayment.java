package com.example.payphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.payphone.models.SaleStatus;
import com.example.payphone.models.Transaction;
import com.example.payphone.services.PayPhoneService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SuccesDetailPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_succes_detail_payment);

        Button btnBack = findViewById(R.id.returnBtn);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });

        Bundle bundle = this.getIntent().getExtras();
        loadDetails(bundle.getInt("transactionId"));
    }

    private void loadDetails(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pay.payphonetodoesposible.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        PayPhoneService payPhoneService = retrofit.create(PayPhoneService.class);
        Call<SaleStatus> saleStatus = payPhoneService.getSaleStatus(id);
        saleStatus.enqueue(new Callback<SaleStatus>() {
            @Override
            public void onResponse(Call<SaleStatus> call, Response<SaleStatus> response) {
                setViewVariables(response.body(), id);
            }

            @Override
            public void onFailure(Call<SaleStatus> call, Throwable t) {
                backHome();
            }
        });
    }

    void backHome() {
        Intent intent = new Intent(SuccesDetailPayment.this,MainActivity.class);
        startActivity(intent);
    }

    void setViewVariables(SaleStatus saleStatus, int transaction){
        TextView email = findViewById(R.id.email);
        TextView document = findViewById(R.id.document);
        TextView cardType = findViewById(R.id.cardType);
        TextView lastDigits = findViewById(R.id.lastDigits);
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        TextView storeName = findViewById(R.id.storeName);
        TextView transactionId = findViewById(R.id.transactionId);
        TextView amount = findViewById(R.id.amount);

        email.setText("Email: " + saleStatus.getEmail());
        document.setText("Numero de cedula: " + saleStatus.getDocument());
        cardType.setText("Tipo de tarjeta: Test");
        lastDigits.setText("Tarjeta: xxxx xxxx xxxx 5933");
        phoneNumber.setText("Telefono: 0" + saleStatus.getPhoneNumber().substring(3,saleStatus.getPhoneNumber().length() - 1));
        storeName.setText("Establecimiento: " + saleStatus.getStoreName());
        transactionId.setText("Numero de transaccion: " + transaction);
        amount.setText("Valor: " + saleStatus.getAmount());

        if(saleStatus.getTransactionStatus().equals("Approved")){
            LinearLayout success = findViewById(R.id.successTransaction);
            success.setVisibility(View.VISIBLE);
        }else {
            LinearLayout pendding = findViewById(R.id.peddingTransaction);
            pendding.setVisibility(View.VISIBLE);
        }
    }
}