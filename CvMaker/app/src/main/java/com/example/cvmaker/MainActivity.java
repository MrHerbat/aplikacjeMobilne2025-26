package com.example.cvmaker;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

class Person{
    String nameAndSurname,
            email,
            phoneNumber,
            birthDate,
            experience,
            education,
            skills,
            hobbies,
            languages;
    Uri profilePicture;

    public Person(String nameAndSurname, String email, String birthDate, String experience, String education, String skills, String hobbies, String languages, String phoneNumber, Uri profilePicture) {
        this.nameAndSurname = nameAndSurname;
        this.email = email;
        this.birthDate = birthDate;
        this.experience = experience;
        this.education = education;
        this.skills = skills;
        this.hobbies = hobbies;
        this.languages = languages;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "Adres e-mail: "+email+"\n"+
                "Numer telefonu: "+phoneNumber+"\n"+
                "Data urodzenia: "+birthDate+"\n"+
                "Doświadczenie: "+experience+"\n"+
               "Wykształcenie: "+education+"\n"+
               "Języki: "+languages+"\n"+
               "Zainteresowania: "+hobbies;
    }
}

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> listOfCVs = new ArrayList<>();
    int SELECT_PICTURE = 150;
    Uri selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.send).setEnabled(false);
        Switch lock = findViewById(R.id.lock);
        lock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                findViewById(R.id.nameAndSurname).setEnabled(!isChecked);
                findViewById(R.id.email).setEnabled(!isChecked);
                findViewById(R.id.phoneNumber).setEnabled(!isChecked);
                findViewById(R.id.birthDate).setEnabled(!isChecked);
                findViewById(R.id.experience).setEnabled(!isChecked);
                findViewById(R.id.languages).setEnabled(!isChecked);
                findViewById(R.id.skills).setEnabled(!isChecked);
                findViewById(R.id.hobbies).setEnabled(!isChecked);
                findViewById(R.id.podstawowe).setEnabled(!isChecked);
                findViewById(R.id.zawodowe).setEnabled(!isChecked);
                findViewById(R.id.srednie).setEnabled(!isChecked);
                findViewById(R.id.wyzsze).setEnabled(!isChecked);
                findViewById(R.id.imageButton).setEnabled(!isChecked);
            }
        });
        CheckBox check = findViewById(R.id.acknowledge);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                findViewById(R.id.send).setEnabled(isChecked);
            }
        });
    }
    void imageChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(
                Intent.createChooser(intent,"Select Image"),
                SELECT_PICTURE);
    }
    public void onActivityResult(int requestCode,
                                  int resultCode,
                                  Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode == RESULT_OK){
            if (requestCode == SELECT_PICTURE){
                selectedImage = data.getData();
                if(null!=selectedImage){
                    data.setData(selectedImage);
                    ImageButton imgBtn = findViewById(R.id.imageButton);
                    imgBtn.setImageURI(selectedImage);
                }
            }
        }
    }

    public void selectImageFromGallery(View view) {
        imageChooser();
    }

    public void sendCV(View view) {
        TextView personNameAndSurname = findViewById(R.id.nameAndSurname),
                personEmail = findViewById(R.id.email),
                personPhoneNumber = findViewById(R.id.phoneNumber),
                personBirthDate = findViewById(R.id.birthDate),
                personExperience = findViewById(R.id.experience),
                personLanguages = findViewById(R.id.languages),
                personSkills = findViewById(R.id.skills),
                personHobbies = findViewById(R.id.languages);
        RadioGroup personEducation = findViewById(R.id.education);
        if(personNameAndSurname.getText().toString().isEmpty() ||
                personEmail.getText().toString().isEmpty() ||
                personPhoneNumber.getText().toString().isEmpty() ||
                personBirthDate.getText().toString().isEmpty() ||
                personExperience.getText().toString().isEmpty() ||
                personLanguages.getText().toString().isEmpty() ||
                personSkills.getText().toString().isEmpty() ||
                personHobbies.getText().toString().isEmpty() ||
                personEducation.getCheckedRadioButtonId()==-1){
            TextView submittedInformations = findViewById(R.id.submittedInformations);
            submittedInformations.setText("Niektóre pola są puste, proszę je uzupełnić!");
        }else{
            RadioButton education = findViewById(personEducation.getCheckedRadioButtonId());
            Person person = new Person(
                    personNameAndSurname.getText().toString(),
                    personEmail.getText().toString(),
                    personBirthDate.getText().toString(),
                    personExperience.getText().toString(),
                    education.getText().toString(),
                    personLanguages.getText().toString(),
                    personSkills.getText().toString(),
                    personHobbies.getText().toString(),
                    personPhoneNumber.getText().toString(),
                    selectedImage
            );
            listOfCVs.add(person);
            ImageView profilePicture = findViewById(R.id.submittedProfilePicture);
            TextView submittedNameAndSurname = findViewById(R.id.submittedNameAndSurname),
                    submittedInformations = findViewById(R.id.submittedInformations);
            profilePicture.setImageURI(person.profilePicture);
            submittedNameAndSurname.setText(person.nameAndSurname);
            submittedInformations.setText(person.toString());

        }
    }
}