package com.example.payphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.payphone.models.Payment;
import com.example.payphone.models.Transaction;
import com.example.payphone.services.PayPhoneService;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.nio.charset.Charset;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCrearOrden = findViewById(R.id.pagarBtn);

        btnCrearOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText cedula = findViewById(R.id.cedulaTxt);
                TextInputEditText telefono = findViewById(R.id.telefonoTxt);
                TextInputEditText monto = findViewById(R.id.montoTxt);

                if(cedula.getText().toString().isEmpty() && telefono.getText().toString().isEmpty()
                        && monto.getText().toString().isEmpty()){
                    showAlert("Uno o mas campos no han sido ingresados");
                }else {
                    if(cedula.getText().toString().length() < 10 && telefono.getText().toString().length() < 10 || Integer.parseInt(monto.getText().toString()) < 10) {
                        showAlert("El numero de cedula o telefono no estan completos");
                    }else {
                        Payment payment = new Payment(telefono.getText().toString().substring(1,10), "593",
                                cedula.getText().toString(), "none",
                                "http://paystoreCZ.com/confirm.php", generateRandomSerie(),
                                Integer.parseInt(monto.getText().toString()),
                                Integer.parseInt(monto.getText().toString()) - 10, 0,10);
                        generateOrden(payment);
                    }
                }
            }
        });
    }

    private String generateRandomSerie(){
        int random = new Random().nextInt();
        return Integer.toString(random);
    }

    private void generateOrden(Payment payOrden){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pay.payphonetodoesposible.com/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        PayPhoneService payPhoneService = retrofit.create(PayPhoneService.class);
        Call<Transaction> transactionCall = payPhoneService.setTransaction(payOrden);

        transactionCall.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                Transaction transaction = response.body();
                if(transaction != null){
                    //callPayPhoneApp(transaction);
                    nextWindowResult(transaction);
                }else {
                    showAlert("Hubo un error al generar la orden");
                }

            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error al realizar la transaccion",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showAlert(String messagge){
        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
        alertDialogBuilder.setTitle("Atencion!");
        alertDialogBuilder.setMessage(messagge);
        alertDialogBuilder.setPositiveButton("Aceptar", (dialog, which) -> {});
        alertDialogBuilder.show();
    }

    private void nextWindowResult(Transaction transaction){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(MainActivity.this, SuccesDetailPayment.class);
        bundle.putInt("transactionId", transaction.getTransactionId());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void callPayPhoneApp(Transaction transaction){
        Intent intent = new Intent("payPhone_Android.PayPhone_Android.Purchase");
        Gson gson = new Gson();
        intent.putExtra("otherApp", true);
        String parameters = gson.toJson(transaction);
        intent.putExtra("parameters", parameters);
        intent.putExtra("package", getPackageName());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}