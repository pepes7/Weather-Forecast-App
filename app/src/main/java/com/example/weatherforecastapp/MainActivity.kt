package com.example.weatherforecastapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.weatherforecastapp.entities.WheaterEntity
import com.example.weatherforecastapp.service.apiService
import com.example.weatherforecastapp.service.apiWoeid
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date
import java.util.Objects

class MainActivity : AppCompatActivity() {
    //private lateinit var mWheaterViewModel: WheaterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container_header_lyt.visibility = View.GONE

       // mWheaterViewModel = ViewModelProvider(this).get(WheaterViewModel::class.java)
        button_ok.setOnClickListener {
            enviar()
        }
    }

    fun enviar(){
        val call2: Call<Woeid> = apiWoeid().searchWeather(edit_city.text.toString());
        progressBar.visibility = View.VISIBLE
        call2.enqueue(object : Callback<Woeid> {
            override fun onResponse(call: Call<Woeid>, response: Response<Woeid>) {
                val response : Woeid? = response.body();
                val call: Call<Wheater> = apiService().searchWeather(response?.woeid.toString());
                call.enqueue(object : Callback<Wheater> {
                    override fun onResponse(call: Call<Wheater>, response: Response<Wheater>) {
                        container_header_lyt.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        val wheater : Wheater? = response.body();
                        val results = wheater?.results
                        txt_city_card.text = results?.city;
                        txt_description_card.text = results?.description
                        txt_date_card.text = results?.date + " - " + results?.time
                        txt_temp_card.text = results?.temp + "º C"

                        var forecast =  results?.forecast?.get(0);
                        txt_date_list_1.text = forecast?.weekday + " - " + forecast?.date;
                        txt_max_list_1.text = forecast?.max + "º C"
                        txt_min_list_1.text = forecast?.min + "º C"

                        forecast =  results?.forecast?.get(1);
                        txt_date_list_2.text = forecast?.weekday + " - " + forecast?.date;
                        txt_max_list_2.text = forecast?.max + "º C"
                        txt_min_list_2.text = forecast?.min + "º C"

                        forecast =  results?.forecast?.get(2);
                        txt_date_list_3.text = forecast?.weekday + " - " + forecast?.date;
                        txt_max_list_3.text = forecast?.max + "º C"
                        txt_min_list_3.text = forecast?.min + "º C"

                        forecast =  results?.forecast?.get(3);
                        txt_date_list_4.text = forecast?.weekday + " - " + forecast?.date;
                        txt_max_list_4.text = forecast?.max + "º C"
                        txt_min_list_4.text = forecast?.min + "º C"

                       // val wheaterEntity = WheaterEntity(0, results?.city.toString(), results?.date.toString(),
                         //   results?.description.toString(), results?.temp.toString(), results?.time.toString())
                        //mWheaterViewModel.addUser(wheaterEntity)


                    }
                    override fun onFailure(call: Call<Wheater?>?, t: Throwable) {
                        Log.e("CEPService   ", "Erro ao buscar o cep:" + t.message)
                    }
                })

            }
            override fun onFailure(call: Call<Woeid?>?, t: Throwable) {
                Log.e("CEPService   ", "Erro ao buscar o cep:" + t.message)
            }
        })


    }
}