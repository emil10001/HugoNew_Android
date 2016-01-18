package io.ejf.hugonew;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.US);
        String strDate = date.format(new Date()).toString();
        StringBuilder sb = new StringBuilder("+++\n");
        sb.append("date = \"" + strDate + "\"\n");
        sb.append("title = \"New Post Title\"\n");
        sb.append("images = [\"preview image or delete\"]\n");
        sb.append("description = \"<short description or delete>\"\n");
        sb.append("+++");

        String header = sb.toString();
        Log.d(TAG, "header = " + header);

        ClipData clip = ClipData.newPlainText("simple text", header);

        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);

        finish();
    }
}
