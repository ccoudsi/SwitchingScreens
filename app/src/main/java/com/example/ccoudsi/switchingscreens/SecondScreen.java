package com.example.ccoudsi.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ccoudsi on 5/25/17.
 */

public class SecondScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        Intent activityThatCalled = getIntent();

        TextView callingActivityMessage = (TextView) findViewById(R.id.calling_activity_info_text_view);

        //String previousActivity = activityThatCalled.getExtras().getString("callingActivity");
        //callingActivityMessage.append(" " + previousActivity );

        Human bob = (Human) activityThatCalled.getSerializableExtra("humanBob");

        callingActivityMessage.append(bob.getName() + " " + bob.getHeight() + " ft" + bob.getWeight() + " lbs");

    }

    public void onSendUserName(View view) {
        EditText userNameET = (EditText) findViewById(R.id.user_name_edit_text);

        String userName = String.valueOf(userNameET.getText());

        Intent goingBack = new Intent();

        goingBack.putExtra("UserName", userName);

        setResult(RESULT_OK, goingBack);

        finish();
    }
}
