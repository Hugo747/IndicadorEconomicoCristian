package com.criss.miindicadorsolid.api;

import android.util.Log;

import com.criss.miindicadorsolid.pojo.indicadorEconomico.IndicadorEconomico;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;

public class CallHandle {

    private static String TAG = "CallHandle";
    public void handleCallBack(final RequestInterfaceApi
                                       objRestRequestInterface, Call objCall, final Response objResponse) {
        objCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                try {
                    Log.d(TAG, response.message());
                    if (response.isSuccessful()) {
                        objResponse.state = Response.ResponseState.SUCCESS;
                        objResponse.hasError = false;
                        objResponse.result = (IndicadorEconomico) response.body();
                        assert objResponse.result != null;
                    } else {
                        Log.d(TAG, "Error: "+response.message());
                        assert response.errorBody() != null;
                        objResponse.errorMessage = response.message();
                    }
                    objRestRequestInterface.response(objResponse);
                } catch (Exception objException) {
                    objResponse.errorMessage = "Error en la respuesta";
                    objRestRequestInterface.response(objResponse);
                }
            }
            @Override
            public void onFailure(Call call, Throwable objThrowable) {
                String errorMessage = "";
                if (objThrowable instanceof IOException) {
                    errorMessage = "No connection error";
                } else {
                    errorMessage = "Server error";
                }
                objResponse.errorMessage = errorMessage;
                objRestRequestInterface.response(objResponse);
            }
        });
    }

}
