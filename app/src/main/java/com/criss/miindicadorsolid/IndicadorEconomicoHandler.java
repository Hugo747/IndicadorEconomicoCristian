package com.criss.miindicadorsolid;

import com.criss.miindicadorsolid.api.CallHandle;
import com.criss.miindicadorsolid.api.RequestInterfaceApi;
import com.criss.miindicadorsolid.api.Response;
import com.criss.miindicadorsolid.pojo.indicadorEconomico.IndicadorEconomico;
import com.criss.miindicadorsolid.utils.RetrofitClient;

import retrofit2.Call;

public class IndicadorEconomicoHandler extends CallHandle {

    private String tipoIndicador, fechaIndicador;

    public IndicadorEconomicoHandler(String tipoIndicador, String
            fechaIndicador) {
        this.tipoIndicador = tipoIndicador;
        this.fechaIndicador = fechaIndicador;
    }

    public void getIndicadorEconomico(RequestInterfaceApi objRestRequestInterface) {
        Call<IndicadorEconomico> objCall;
        Response objResponse = new Response();
        IndicadorEconomicoApi indicadorEconomicoApiEndPoint;
        objResponse.state = Response.ResponseState.FAILURE;
        objResponse.hasError = true;
        objResponse.requestType = Response.RequestType.SEARCH_FOR_INDICADOR;
        indicadorEconomicoApiEndPoint = RetrofitClient.getRetrofitInstance().create(IndicadorEconomicoApi.class);
        objCall = indicadorEconomicoApiEndPoint.getIndicadorEconomico(tipoIndicador, fechaIndicador);
        handleCallBack(objRestRequestInterface, objCall, objResponse);
    }
}
