package kr.ac.kopo.hdyw0w.sixthsensor;

import android.app.Activity;
import android.widget.Toast;

public class BackPressCloseHandler {

    private long backkeyPressedTime = 0;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context) {
        this.activity = context;
    }

    public void onBackPressed() {

        if (System.currentTimeMillis() > backkeyPressedTime + 2000) {
            backkeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }

        if (System.currentTimeMillis() <= backkeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
            return;
        }
    }

    public void showGuide() {
        toast = Toast.makeText(activity, "뒤로가기 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();
        return;
    }
}
