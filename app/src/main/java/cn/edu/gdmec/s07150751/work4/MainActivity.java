package cn.edu.gdmec.s07150751.work4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        tv1 = new TextView(this);
        tv1.setText("请点击按键或者是屏幕");
        setContentView(tv1);
    }
    boolean LongPress;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_HOME:
                SetMessage("按下HOME键");
                return true;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("按下MENU键");
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("按下BACK键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("按下了声量+键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("按下了声量-键");
                event.startTracking();
                return true;
            default:
                SetMessage("按下的键码是"+keyCode);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_HOME:
                SetMessage("松开了HOME键");
                return true;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("松开了MENU键");
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("松开了BACK键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("松开了声量+键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("松开了声量-键");
                break;
            default:
                SetMessage("放开的键码是"+keyCode);
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_HOME:
                SetMessage("长按了Home键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("长按了MENU键");
                break;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("长按了BACK键");
                break;
            default:
                SetMessage("长按的键码是"+keyCode);
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("长按了声量+键");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("长按了声量-键");
                break;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_CANCEL||action == MotionEvent.ACTION_DOWN||action == MotionEvent.ACTION_MOVE){
            return false;
        }
        String x = String.valueOf(event.getX());
        String y = String.valueOf(event.getY());
        SetMessage("触点坐标是("+x+","+y +")");
        return super.onTouchEvent(event);
    }

  /*  @Override
    public void onBackPressed() {
        super.onBackPressed();
        SetMessage("按下返回键了");
    }*/

    public void SetMessage(String Str) {
        String oldStr = tv1.getText().toString();
        String newStr = oldStr+"\n"+Str;
        tv1.setText(newStr);
    }
}
