package mrperfect.example.gdgkotlin

import android.telephony.gsm.GsmCellLocation
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object APIHopder{
    private val BASE_URL = "http://dummy.restapiexample.com/api/v1/"

    val publicApiRxJava2: PublicApiForRxJava2 by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()
            .build()
            .create(PublicApiForRxJava2::class.java))
    }

}