package com.github.zdongcoding.aspectjdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

@Runtime("MainActivity")
public class MainActivity extends AppCompatActivity {
    @Runtime("base")
    private int base=1;

    @Runtime("onCreate")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base =10000000;
        Log.e("zoudong", "base="+base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onDdd();
//                AfterReturning("12349825");
                base++;

                AfterReturning(base + "12308543");
//                Log.e("zoudong", "onClick====" + "view = [" + view + "]"+base);
//                throwNullPoint();
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Runtime("AfterReturning")
    private int AfterReturning(String arg){
//        aaaa(1000);
        return 1;
    }
    private void throwNullPoint(){
        @Runtime({"s"})
        String s=null;
        s.equals("null");
    }
    protected  void onDdd(){
        test01();
        Log.e("zoudong", "onDdd====" + "");
    }
    private  void   test(){
        test01();
        Log.e("zoudong", "test====" + "");
    }
    private  void test01(){
        Log.e("zoudong", "test01====" + "");
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
        onDdd();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void aaaa(int base) {
//        Log.e("zoudong", "aaaa1====" + "base = [" + this.base + "]");
//        this.base++;
//        Log.e("zoudong", "aaaa2====" + "base = [" + this.base + "]");
//    }
}
