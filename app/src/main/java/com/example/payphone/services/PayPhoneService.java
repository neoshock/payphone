package com.example.payphone.services;

import com.example.payphone.models.Payment;
import com.example.payphone.models.Transaction;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PayPhoneService {
    @Headers({"Authorization: Bearer RHcZ5fBS96dDNnaMKjf_ldUkDn8_k5_AfglzTlDQhntQ_thufuVCTEiKNcA2" +
            "nsdSRQzkmTS51s_pMuOzHnq_YvSjgADt_WXOgogtC6F12ULa-eM6hpf8OOeWPdZfN1JvHcx6FWdQIFh8DB4hE" +
            "3KJbAJN_MFnxRQhrOid_nZzNS3prwPETRNNWuXhMtu1Ty8pTD1ZSW7zD_XVe-BZ5BSPhrEPXaD-zZi0S7q1" +
            "yl3719h3dt4rhBEGeLnEyLH3GPzlUF8BRmm5vXF9SNfWrrH3TrnI8dOMwsOT56SAJ4vfxgcDNrSVYCI8AL" +
            "_BjgKwBcpk4LDbf_YOUUriCLbDqFgWkCUcC1I"})
    @POST("Sale")
    Call<Transaction> setTransaction(@Body Payment payment);
}
