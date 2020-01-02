package com.example.mynewsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mynewsapp.helpers.MyFontsClass;
import com.example.mynewsapp.helpers.PublicArea;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    Typeface font;
    TextView txtLoginText,
            txtUserNameText,
            txtPasswordText,
            txtDescriptionText,
            txtShowPasswordText,
            txtCopyright;
    EditText edtUserName,
            edtPassword;
    boolean status = false;
    PublicArea publicArea;


    Button btnLogin,btnsignUp;

    MyFontsClass myFontsClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        firebaseAuth = FirebaseAuth.getInstance();
        init();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null) {

            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();

        }






    }
    private void init() {
        publicArea = new PublicArea(this);
        myFontsClass = new MyFontsClass(this);
        initTextViews();
        initButtons();
        initEditTexts();
    }
    private void initEditTexts() {

        edtUserName = findViewById(R.id.edtpanelKullaniciAdi);
        edtPassword = findViewById(R.id.edtpanelSifre);

        publicArea.editTextNormalTint(edtUserName);
        publicArea.editTextNormalTint(edtPassword);

        font = Typeface.createFromAsset(getAssets(), "fonts/rawline-700.ttf");
        edtUserName.setTypeface(font);
        edtPassword.setTypeface(font);
        btnLogin.setTypeface(font);

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if ((edtPassword.getText().toString().isEmpty() || edtPassword.getText().toString() == null || edtPassword.getText().toString().equals("")) && txtShowPasswordText.getVisibility() == View.VISIBLE)
                    txtShowPasswordText.setVisibility(View.GONE);
                else
                    txtShowPasswordText.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

                publicArea.editTextNormalTint(edtPassword);
            }
        });

        edtUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                publicArea.editTextNormalTint(edtUserName);
            }
        });

        edtPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    if (i == KeyEvent.KEYCODE_ENTER) {
                        loginButton(btnLogin);
                    }
                }
                return false;
            }
        });

        if ((edtPassword.getText().toString().isEmpty() || edtPassword.getText().toString() == null || edtPassword.getText().toString().equals("")) && txtShowPasswordText.getVisibility() == View.VISIBLE)
            txtShowPasswordText.setVisibility(View.GONE);
        else
            txtShowPasswordText.setVisibility(View.VISIBLE);
    }

    private void initTextViews() {
        txtLoginText = findViewById(R.id.txtGirisYap);
        txtUserNameText = findViewById(R.id.txtpanelKullaniciAdi);
        txtPasswordText = findViewById(R.id.txtpanelSifre);
        txtDescriptionText = findViewById(R.id.txtpanelAciklama);
        txtShowPasswordText = findViewById(R.id.txtpanelSifreGoster);
        txtCopyright = findViewById(R.id.txtCopyright);

        myFontsClass.setTextViewFont(myFontsClass.getFont900(), txtLoginText, txtUserNameText, txtPasswordText);

        myFontsClass.setTextViewFont(myFontsClass.getFont700(), txtShowPasswordText);

        font = Typeface.createFromAsset(getAssets(), "fonts/rawline-700i.ttf");
        txtDescriptionText.setTypeface(font);

        font = Typeface.createFromAsset(getAssets(), "fonts/rawline-500i.ttf");

        txtCopyright.setTypeface(font);

    }
    private void initButtons() {
        btnLogin = findViewById(R.id.loginButton);
        btnsignUp = findViewById(R.id.signUpButton);
        font = Typeface.createFromAsset(getAssets(), "fonts/rawline-700.ttf");
        btnLogin.setTypeface(font);
        btnsignUp.setTypeface(font);
    }
    public void loginButton(View view) {

        String email = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();


        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });


    }

    public void signUpClicked(View view) {

        String email = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();


        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                Toast.makeText(LoginActivity.this,"User Created",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });



    }

    public void edtPanelSifreGoster(View view) {
        TextView tv = (TextView) view;

        if (status) {
            edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            txtShowPasswordText.setText("show");
            publicArea.editTextNormalTint(edtPassword);
            edtPassword.hasFocus();
            status = false;
        } else {
            edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            publicArea.editTextAttentionTint(edtPassword);
            txtShowPasswordText.setText("hide");

            status = true;
        }
    }

}
