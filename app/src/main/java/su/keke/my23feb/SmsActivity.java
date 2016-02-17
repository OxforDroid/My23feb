package su.keke.my23feb;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {
    private TextView mTextViewtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextViewtext = (TextView)findViewById(R.id.tvsms);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bildText(mTextViewtext);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void share (TextView view)
    {
        String str = mTextViewtext.getText().toString();
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra(android.content.Intent.EXTRA_TEXT, str);
        startActivity(smsIntent);

    }
    public void bildText (View view){

        String[]gum_list = getResources().getStringArray(R.array.sms_array);
// Вычисляем, сколько слов в каждом списке
        int gumLength = gum_list.length;
//Генерируем случайное число
        int randl = (int) (Math.random() * gumLength);
//Теперь строим фразу
        String phrase =  gum_list[randl];
        mTextViewtext.setText("");//очищаем поле
        mTextViewtext.setText(phrase);//вставляем фразу
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.maintext, menu);
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
            share(mTextViewtext);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
