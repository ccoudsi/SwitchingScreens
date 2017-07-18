package com.example.ccoudsi.switchingscreens;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onGetnameClick(View view) {
        final int result = 1;

        //Intent getNameScreenIntent = new Intent(this,SecondScreen.class);

        //getNameScreenIntent.putExtra("callingActivity", "MainActivity");

        //startActivityForResult(getNameScreenIntent, result);

        Human bob = new Human (6.25,185,"Bob");

        Intent sendBob = new Intent(this, SecondScreen.class);

        sendBob.putExtra("humanBob", bob);

        startActivityForResult(sendBob, result);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView userNameMessage = (TextView) findViewById(R.id.user_name_message);

        String nameSentback = data.getStringExtra("UserName");

        userNameMessage.append(" " + nameSentback);



    }
}
