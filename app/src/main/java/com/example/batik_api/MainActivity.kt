package com.example.batik_api

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.batik_api.Model.BatikResponse
import com.example.batik_api.Network.ApiClient
import com.example.batik_api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val responseBatik = client.getAllBatik()
        val batikList = ArrayList<String>()

        responseBatik.enqueue(object : Callback<BatikResponse> {
            override fun onResponse(call: Call<BatikResponse>, response: Response<BatikResponse>) {
                if (response.isSuccessful) {
                    response.body()?.hasil?.forEach {
                        batikList.add(it.namaBatik)
                    }
                    // Atur ArrayAdapter ke ListView
                    val listAdapter = ArrayAdapter(this@MainActivity, R.layout.simple_list_item_1, batikList)
                    binding.lvBatik.adapter = listAdapter
                } else {
                    Toast.makeText(this@MainActivity, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<BatikResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Koneksi error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}