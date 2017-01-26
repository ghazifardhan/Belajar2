package org.simonita.simonita.rest;

/**
 * Created by plonk on 1/26/2017.
 */

import org.simonita.simonita.models.Data;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Teknorial on 06/02/2016.
 */
public interface RestApi {

    //@GET("test.php")
    @GET("test.php") //ini error
    Call<Data> getDataAdmin();
}