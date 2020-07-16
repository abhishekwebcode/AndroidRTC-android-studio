package fr.pchab.androidrtc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Start extends Activity {
    public TextView chatId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        chatId = findViewById(R.id.chatId);
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
        handleIntent(getIntent());

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }
    private void handleIntent(Intent intent) {
        String appLinkAction = intent.getAction();
        Uri appLinkData = intent.getData();
        if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null){
            String recipeId = appLinkData.getLastPathSegment();
            startActivity(new Intent(this,RtcActivity.class).putExtra("chatId",recipeId));
        }
    }

    public void startChat(View v) {
        startActivity(new Intent(this,RtcActivity.class).putExtra("chatId",chatId.getText().toString()));
    }
    public void initiate(View v) {
        startActivity(new Intent(this,RtcActivity.class));
    }

}
