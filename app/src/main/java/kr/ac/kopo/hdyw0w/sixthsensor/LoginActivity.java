package kr.ac.kopo.hdyw0w.sixthsensor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import kr.ac.kopo.hdyw0w.sixthsensor.item.Code;
import kr.ac.kopo.hdyw0w.sixthsensor.item.LoginItem;
import kr.ac.kopo.hdyw0w.sixthsensor.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    CheckBox autoCheckbox;

    SharedPreferences setting;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        autoCheckbox = (CheckBox) findViewById(R.id.autoCheckbox);

        final EditText userId = (EditText) findViewById(R.id.la_edUserID);
        final EditText userPassWd = (EditText) findViewById(R.id.la_edPassword);

        setting = getSharedPreferences(Code.pref_id,0);
        editor = setting.edit();

        if (setting.getBoolean("autoCheckbox",true)){
            userId.setText(setting.getString(Code.pref_user_id,""));
            userPassWd.setText(setting.getString(Code.pref_user_passwd,""));
            autoCheckbox.setChecked(true);
        }

        findViewById(R.id.btnLogin).setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        final String userid = userId.getText().toString();
                        String passWd = userPassWd.getText().toString();

                        if (userid.length() == 0){
                            Toast.makeText(LoginActivity.this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (passWd.length() == 0) {
                            Toast.makeText(LoginActivity.this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                            return;
                        }


                        // 자동로그인
                        if (autoCheckbox.isChecked()){

                            String ID = userId.getText().toString();
                            String PW = userPassWd.getText().toString();

                            editor.putString(Code.pref_user_id,ID);
                            editor.putString(Code.pref_user_passwd,PW);
                            editor.putBoolean("autoCheckbox",true);
                            editor.apply();

                        } else {
                            editor.clear();
                            editor.commit();
                        }

//                        Intent intent_act = new Intent(getApplicationContext(), NavActivity.class);
//                        startActivity(intent_act);

                        Retrofit retrofit = RetrofitService.retrofit;
                        RetrofitService service = retrofit.create(RetrofitService.class);
                        service.login(userid, passWd).enqueue(new Callback<LoginItem>() {

                            @Override
                            public void onResponse(Call<LoginItem> call, Response<LoginItem> response) {
//                                LoginItem item1 = response.body();
//                                if (!item1.getUsername().isEmpty())
//                                    Toast.makeText(LoginActivity.this, item1.getUsername(), Toast.LENGTH_SHORT).show();

                                if (response.isSuccessful()) {
                                    LoginItem item = response.body();
                                    assert item != null;

                                    if (item.getStatus().equals("success")){
                                        SharedPreferences preferences = getSharedPreferences(Code.pref_id, 0);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putString(Code.pref_user_id, userid).putString(Code.pref_token, item.getToken()).apply();

                                        Toast.makeText(LoginActivity.this, "로그인", Toast.LENGTH_SHORT).show();

                                        Intent intent_act = new Intent(getApplicationContext(), NavActivity.class);
                                        startActivity(intent_act);

                                    } else {
                                        Toast.makeText(LoginActivity.this, "다시 시도해주세요!", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "다시 시도해주세요!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<LoginItem> call, Throwable t) {
                                Log.e("onFailure()", t.getMessage(), t);
                                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }
        );

        findViewById(R.id.btnJoin).setOnClickListener(

                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent_act = new Intent(getApplicationContext(),JoinActivity.class);
                        startActivity(intent_act);
                    }
                }
        );
    }

//    // 자동로그인
//    // 값 불러오기
//    private void getPreferences(){
//        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
//        pref.getString("","");
//    }
//
//    // 값 저장하기
//    private void savePreferences(){
//        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putString("","");
//        editor.commit();
//    }
//
//    // 값 (Key Data) 삭제하기
//    private void removePreferences(){
//        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.remove("");
//        editor.commit();
//    }
//
//    // 값 (ALL Data) 삭제하기
//    private void removeAllPreferences(){
//        SharedPreferences pref = getSharedPreferences("pref",MODE_PRIVATE);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.clear();
//        editor.commit();
//    }
}
