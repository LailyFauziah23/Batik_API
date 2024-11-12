package com.example.batik_api.Model

import com.google.gson.annotations.SerializedName

data class BatikItem(
    @SerializedName("nama_batik")
    val namaBatik: String,
    @SerializedName("daerah_batik")
    val daerahBatik: String,
    @SerializedName("makna_batik")
    val maknaBatik: String,
    @SerializedName("harga_rendah")
    val hargaRendah: Int,
    @SerializedName("harga_tinggi")
    val hargaTinggi: Int,
    @SerializedName("link_batik")
    val linkBatik: String
)