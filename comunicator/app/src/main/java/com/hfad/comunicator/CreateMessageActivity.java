package com.hfad.comunicator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onClickSendMessage(View view) {
        EditText messageView = findViewById(R.id.sendMessage);
        String messageText = messageView.getText().toString();
        //Intent intent = new Intent(this, ReceiveMessageActivity.class);
        //intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageView.getText());
        Intent intent = new Intent(Intent.ACTION_SEND);
        Intent choosenIntent = Intent.createChooser(intent,"Wysyłanie wiadomości...");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);
        startActivity(choosenIntent);
    }
}