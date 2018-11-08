package kr.ac.kopo.hdyw0w.sixthsensor.push;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    // 토큰 재생성
    @Override
    public void onTokenRefresh(){

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG," token = " + token);
    }


}
