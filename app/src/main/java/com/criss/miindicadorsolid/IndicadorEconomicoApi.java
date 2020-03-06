package com.criss.miindicadorsolid;

import com.criss.miindicadorsolid.pojo.indicadorEconomico.IndicadorEconomico;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IndicadorEconomicoApi {

    @GET("{tipoIndicador}/{fechaIndicador}")
    Call<IndicadorEconomico> getIndicadorEconomico(@Path("tipoIndicador") String tipoIndicador,
                                                   @Path("fechaIndicador") String fechaIndicador);
}
