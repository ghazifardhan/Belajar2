package org.simonita.simonita;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.simonita.simonita.models.Data;
import org.simonita.simonita.models.Models;
import org.simonita.simonita.rest.RestApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //ROOT_URL dari web service
    public static final String ROOT_URL = "http://128.199.226.96/test/";

    List<Models> models; // Create variable array

    //definisi tampilan
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Memanggil method untuk mengambil data
        getData();

    }

    private void getData(){
        //ketika aplikasi sedang mengambil data kita akan melihat progress dialog muncul
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data","Please wait..",false,false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())//GsonConverter untuk parsing json
                .build();
        RestApi service = retrofit.create(RestApi.class);
        Call<Data> call = service.getDataAdmin();
        call.enqueue(new Callback<Data>() { //Asyncronous Request
                         @Override
                         public void onResponse(Call<Data> call, Response<Data> response) {
                             try {
                                 loading.dismiss(); //progress dialog dihentikan
                                 List<Models> modelses = response.body().getData(); // add data to models

                                 models = modelses; //

                                 String[] itemsName = new String[models.size()]; // variable array to hold name
                                 String[] itemsKota = new String[models.size()]; // variable array to hold kota
                                 for(int i=0;i<models.size();i++){
                                     itemsName[i] = models.get(i).getNama();
                                     itemsKota[i] = models.get(i).getKota();
                                     System.out.println(models.get(i).getNama());
                                     System.out.println(models.get(i).getKota());
                                 }

                                 ModelAdapter adapter = new ModelAdapter(MainActivity.this, itemsName, itemsKota);
                                 listView = (ListView) findViewById(R.id.myList);
                                 listView.setAdapter(adapter);

                             }catch (Exception e){
                                 e.printStackTrace();
                             }
                         }

                         @Override
                         public void onFailure(Call<Data> call, Throwable t) {

                         }

                     }
        );
    }
}