package com.example.a32androidfirebasedangkydangnhap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
{
    EditText editText1, editText2, editText3, editText4;
    Button button1, button2;

    FirebaseAuth mAuthentication;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthentication = FirebaseAuth.getInstance();
        anhXa();

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dangKy();
            }
        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dangNhap();
            }
        });
    }


    private void dangKy()
    {
        String email1 = editText1.getText().toString();
        String password1 = editText2.getText().toString();
        mAuthentication.createUserWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                            editText1.setText("");
                            editText2.setText("");
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Đăng Ký Thất Bại", Toast.LENGTH_SHORT).show();
                            editText1.setText("");
                            editText2.setText("");
                        }
                    }
                });
    }


    private void dangNhap()
    {
        String email = editText3.getText().toString();
        String password = editText4.getText().toString();
        mAuthentication.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, "Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                            editText3.setText("");
                            editText4.setText("");
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Đăng Ký Thất Bại", Toast.LENGTH_SHORT).show();
                            editText3.setText("");
                            editText4.setText("");
                        }
                    }
                });
    }
    private void anhXa()
    {
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.butTon1);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        button2 = findViewById(R.id.butTon2);
    }
}
