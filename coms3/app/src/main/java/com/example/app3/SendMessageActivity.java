package com.example.app3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SendMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
    }

    public void onSendMessage(View view){
        EditText message =findViewById(R.id.editTextText);
        String messageText = message.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        String chooserTitle = getString(R.string.chooserTitle);
        Intent choosenIntent = Intent.createChooser(intent,chooserTitle);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);
        startActivity(choosenIntent);
    }
}