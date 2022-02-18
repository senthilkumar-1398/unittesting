package com.example.unittest11_08_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.twofact.TwoFactorAuth;

public class MainActivity extends AppCompatActivity {
    TwoFactorAuth twoFactorAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        twoFactorAuth = new TwoFactorAuth( this );
        ImageView ivQr = findViewById( R.id.iv_qr );
        AppCompatButton btn = findViewById( R.id.btn_save );

        Bitmap bitmap = twoFactorAuth.getQrCode( "5555666677779999" );
        ivQr.setImageBitmap( bitmap );

        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoFactorAuth.addDataToFirebase( 1, "5555666677779999", 234543 );

            }
        } );
    }
}