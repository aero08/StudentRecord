package com.example.sqllitestudentrecord;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editTextId,editName,editEmail,editCC;
    Button buttonAdd,buttonGetData,buttonUpdate,buttonDelete,buttonViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDB=new DatabaseHelper(this);
        editTextId=findViewById(R.id.editText_id);
        editName=findViewById(R.id.editText_name);
        editEmail=findViewById(R.id.editText_email);
        editCC=findViewById(R.id.editText_CC);


        buttonAdd=findViewById(R.id.button_add);
        buttonUpdate=findViewById(R.id.button_update);
        buttonDelete=findViewById(R.id.button_delete);
        buttonGetData=findViewById(R.id.button_view);
        buttonViewAll=findViewById(R.id.button_viewAll);
        AddData();


     // showMessage("test","testing done");
    }
    public void AddData(){
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String myEmail=editEmail.getText().toString();
                boolean isInserted =myDB.insertData(editName.getText().toString(),editEmail.getText().toString(),editCC.getText().toString());
                if(isInserted==true){
                    Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();
                }
                else {
                     Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }

               // Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
            }
        });
    }




    private void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}