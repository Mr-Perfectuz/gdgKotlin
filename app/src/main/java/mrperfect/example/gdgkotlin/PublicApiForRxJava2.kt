package mrperfect.example.gdgkotlin

import io.reactivex.Single
import okhttp3.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface PublicApiForRxJava2{
    @GET("employees")
    fun employees(): Single<Response>
}