package sg.edu.rp.c346.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    String bankClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if(v.getId()== tvDBS.getId()){
            bankClicked = "DBS";
        }
        if(v.getId()== tvOCBC.getId()){
            bankClicked = "OCBC";
        }
        if(v.getId()== tvUOB.getId()){
            bankClicked = "UOB";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0 && bankClicked.equals("DBS")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intent);
            return true;
        } else if (item.getItemId() == 1 && bankClicked.equals("DBS")) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
            startActivity(intentCall);
            return true;
        }
        if (item.getItemId() == 0 && bankClicked.equals("OCBC")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intent);
            return true;
        } else if (item.getItemId() == 1 && bankClicked.equals("OCBC")) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
            startActivity(intentCall);
            return true;
        }
        if (item.getItemId() == 0 && bankClicked.equals("UOB")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intent);
            return true;
        } else if (item.getItemId() == 1 && bankClicked.equals("UOB")) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
            startActivity(intentCall);
            return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("error");
            tvOCBC.setText("error");
            tvUOB.setText("error");
        }

        return super.onOptionsItemSelected(item);
    }

}
