package com.example.enc.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        byte by = 127; // auto down casting [1 byte] (data value range 2^7-1)
        short sh = 1; // auto down casting [2 byte] (data value range 2^15-1)
        int i = 1;  // [4 byte] (data value range 2^31-1)
        long l = 1; // up casting [8 byte] (data value range 2^63-1)
        float f = 17117171274117172722727272472422727.0f;
        double d = 1.0;
        char c = 'a';
        boolean b = true;

        String st = "abc";
        String st2 = "abcd";  // its hold previous variable reference address which variable store same value of this variable
        String st1 = new String("abc");  // its create new object as well as new reference address

        if(st.equalsIgnoreCase(st1)){
            Toast.makeText(MainActivity.this,"1st checking - true",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(MainActivity.this,"1st checking - false",Toast.LENGTH_SHORT).show();
        }

        if (st == st2) {
            Toast.makeText(this, "2nd checking - true", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "2nd checking - false", Toast.LENGTH_SHORT).show();
        }
        Long ln = 1l; // auto boxing
        String s = "1234";
        Integer integer = Integer.parseInt(s);


        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new MyOnClickListener(this)); // anonymous inner class
        Sub.getInstance(); // its call singleton class constructor

    }


    class MyOnClickListener implements View.OnClickListener {

        MainActivity mainActivity;

        MyOnClickListener(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mainActivity, "", Toast.LENGTH_SHORT).show();
        }
    }

    // -------------------------------------Collection Framwork----------------------------------------

    {   // { } its non static block. its execute when object is created

        List<Object> arrayList = new ArrayList(); // List is a parent class of ArrayList
        arrayList.add(Sub.getInstance()); // here add the key value by default
        arrayList.add("ASD"); // here add the key value by default
        arrayList.add(12); // here add the key value by default
        arrayList.get(0); // its retuen object reference
        arrayList.remove(0); // its remove 0th index value
        arrayList.remove(Sub.getInstance()); // its remove particular object
        List<Object> list1 = arrayList; // here arrayList just copied into list1 & if any element of list1 is modify then its also modify arrayList object
        List<Sub> list = (List<Sub>) ((ArrayList)arrayList).clone(); // its create another new object with same value but reference address is different

        Map<String,Object> hashMap = new HashMap<>();  // Map is a parent class of HashMap
        hashMap.put("string","abc");
        hashMap.put("sub",Sub.getInstance());
        hashMap.put("integer",12345);
        hashMap.get("sub");

        // ArrayList perform fast retrive operation  & LinkList perform fast insertion operation

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("mp");
        linkedList.get(0);

        Stack<String> stack = new Stack<>();
        stack.push("abc");
        stack.push("efg");
        stack.push("ijk");
        stack.pop();
        stack.pop();
        stack.peek(); // its return current top location

       //-------------------------------------Thread--------------------------------------------------

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int a = 1;
                int b = 2;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int sum = a + b;
                System.out.println("BACKGROUND");
                System.out.println(sum);
            }
        },5000);
        System.out.println("MAIN");
    }
}






    /* ----------------------------------------Note---------------------------------------------------
     Access specifier
        1. public - its access from anywhere
        2. protected - its only access derive class object of same package as well as different package
        3. default - its access any class object of same package
        4. private - its only access same class object      */


