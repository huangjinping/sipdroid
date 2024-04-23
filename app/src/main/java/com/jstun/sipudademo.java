package com.jstun;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.sipdroid.sipua.R;
import org.sipdroid.sipua.ui.Sipdroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sipudademo extends Activity {
    Button textView;
    List<Map<String, String>> accountList = new ArrayList<>();
    int selectedIndex = -1;
    private TextView edt_bank_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sipudademo);
        textView = findViewById(R.id.textView);
        edt_bank_account = findViewById(R.id.edt_bank_account);

        init();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openOO1();
//                openOO2();
                onSubmit();

            }
        });

        Button textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(sipudademo.this, "cccc", Toast.LENGTH_SHORT).show();
            }
        });

        edt_bank_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectAccount();
            }
        });
    }

    private void onSelectAccount() {
        List<String> dataTitle = new ArrayList<>();
        for (Map<String, String> item : accountList
        ) {
            dataTitle.add(item.get("accountName"));
        }
        String[] arrString = dataTitle.toArray(new String[dataTitle.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(arrString, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedIndex = which;
                edt_bank_account.setText("" + accountList.get(which).get("accountName"));
            }
        }).show();
    }

    private void init() {
        accountList.clear();
//
        for (int i = 1; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            String acount = "19" + createText1(i);
            map.put("accountName", acount);
            accountList.add(map);
        }

//        for (int i = 1; i < 1000; i++) {
//            Map<String, String> map = new HashMap<>();
//            String acount = "10" + createText(i);
//            if (i < 100) {
//                acount = "10" + createText(i);
//            } else {
//                acount = "1" + createText(i);
//            }
//            map.put("accountName", acount);
//            accountList.add(map);
//        }


//        for (int i = 1; i < 10; i++) {
//            Map<String, String> map = new HashMap<>();
//            String acount = "20" + createText(i);
//            map.put("accountName", acount);
//            accountList.add(map);
//        }

    }


    private String createText1(int index) {
        String result = index + "";
        if (result.length() == 1) {
            result = "9" + result;
        }
        return result;
    }

    private String createText(int index) {
        String result = index + "";
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }


    private void openOO1() {

        ConfigSip configSip = new ConfigSip();
        configSip.setServer("115.28.186.246");
        configSip.setDns0("115.28.186.246");
        configSip.setPort("65060");
        configSip.setUsername("9004");
        configSip.setProtocol("TCP");
        configSip.setPassword("@#123Qw");
        SipuaConfig.init(this, configSip);

        Intent intent = new Intent(this, Sipdroid.class);
//        intent.putExtra(Sipdroid.numberKey, "13756526000");
        startActivity(intent);
    }

    private void openOO2() {

//            try {
//                Thread.sleep(10000);
//            }catch (Exception E){
//                E.printStackTrace();
//            }

        ConfigSip configSip = new ConfigSip();
        configSip.setServer("13.246.65.101");
        configSip.setDns0("8.8.8.8");
        configSip.setPort("65060");
        configSip.setUsername("1002");
        configSip.setProtocol("TCP");
        configSip.setPassword("!@#123Qw");
        SipuaConfig.init(this, configSip);

        Intent intent = new Intent(this, Sipdroid.class);
        startActivity(intent);
    }

    private void onSubmit() {
        if (selectedIndex == -1) {
            Toast.makeText(this, "Veuillez sélectionner un compte", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, String> map = accountList.get(selectedIndex);
//
        ConfigSip configSip = new ConfigSip();
        configSip.setServer("13.246.65.101");
        configSip.setDns0("8.8.8.8");
        configSip.setPort("65060");
        configSip.setUsername(map.get("accountName"));
//        configSip.setUsername("1099");
        configSip.setProtocol("TCP");
        configSip.setPassword("!@#123Qw");
        SipuaConfig.init(this, configSip);
        Intent intent = new Intent(this, Sipdroid.class);
        startActivity(intent);


//        ConfigSip configSip = new ConfigSip();
//        configSip.setServer("115.28.186.246");
//        configSip.setDns0("115.28.186.246");
//        configSip.setPort("65060");
//        configSip.setUsername("9003");
//        configSip.setProtocol("TCP");
//        configSip.setPassword("@#123Qw");
//        SipuaConfig.init(this, configSip);
//        Intent intent = new Intent(this, Sipdroid.class);
//        startActivity(intent);
    }


}
