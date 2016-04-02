package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.Joker;
import com.example.snehaanandyeluguri.androiddisplaylibrary.JokeDisplayActivity;

public class MainActivity extends ActionBarActivity {
    ProgressDialog progress;

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

    public void tellJoke(View view){
        new EndpointsAsyncTask(new JokeRetrievalHandler()).execute();

        Resources resources = getResources();
        progress = ProgressDialog.show(this, resources.getString(R.string.dialog_title),
                resources.getString(R.string.dialog_message), true);
    }

    private class JokeRetrievalHandler implements EndpointsAsyncTask.OnJokeRetrievedListener {

        @Override
        public void onJokeRetrieved(String joke) {
            progress.dismiss();
            Intent jokesIntent=new Intent(MainActivity.this, JokeDisplayActivity.class);
            jokesIntent.putExtra("Joke",joke);
            startActivity(jokesIntent);
        }
    }

}
