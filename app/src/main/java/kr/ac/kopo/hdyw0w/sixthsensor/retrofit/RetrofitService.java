package kr.ac.kopo.hdyw0w.sixthsensor.retrofit;

import kr.ac.kopo.hdyw0w.sixthsensor.item.DeviceItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.JoinItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.LoginItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.PassChItem;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://iot-sixthsensor.appspot.com/").addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
            .build();

    // 조회 (라즈베리파이 ID)
    @GET("devices/{deviceId}")
    Call<DeviceItem> device (
            @Header("x-auth") String token,
            @Path("deviceId") String deviceId
    );

    // 장소이름
    @FormUrlEncoded
    @POST("devices/{deviceId}")
    Call<DeviceItem> place (
            @Field("deviceName") String deviceName
    );

    // 장치이름 (아두이노 설정)
    @GET("devices/{deviceId}")
    Call<DeviceItem> sensor (
            @Path("sensorName") String sensorName,
            @Path("measRange") int measRange
    );

    // 로그인
    @FormUrlEncoded
    @POST("users/login")
    Call<LoginItem> login (
            @Field("userid") String userid,
            @Field("password") String password
    );

    //비밀번호 변경
    @FormUrlEncoded
    @PATCH("users/{userid}/password")
    Call<PassChItem> password (
            @Header("x-auth") String token,
            @Field("userid") String userid,
            @Field("password") String password,
            @Field("newPassword") String newPassword
    );

    // 회원가입
    @FormUrlEncoded
    @POST("users")
    Call<JoinItem> users (
            @Field("userid") String userid,
            @Field("username") String username,
            @Field("password") String password
    );
}