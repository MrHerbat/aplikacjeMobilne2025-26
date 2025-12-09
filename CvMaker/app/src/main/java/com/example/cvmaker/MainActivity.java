package com.example.cvmaker;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        return "E-mail: "+email+"\n"+
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
    boolean locked = true;

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

    public void lockCv(View view) {
        TextView personNameAndSurname = findViewById(R.id.nameAndSurname),
                personEmail = findViewById(R.id.email),
                personPhoneNumber = findViewById(R.id.phoneNumber),
                personBirthDate = findViewById(R.id.birthDate),
                personExperience = findViewById(R.id.experience),
                personLanguages = findViewById(R.id.languages),
                personSkills = findViewById(R.id.skills),
                personHobbies = findViewById(R.id.languages);
        RadioButton podstawowe = findViewById(R.id.podstawowe),
                zawodowe = findViewById(R.id.zawodowe),
                srednie = findViewById(R.id.srednie),
                wyzsze = findViewById(R.id.wyzsze);
        ImageButton profileButton = findViewById(R.id.imageButton);
        locked = !locked;
        personNameAndSurname.setEnabled(locked);
        personEmail.setEnabled(locked);
        personPhoneNumber.setEnabled(locked);
        personBirthDate.setEnabled(locked);
        personExperience.setEnabled(locked);
        personLanguages.setEnabled(locked);
        personSkills.setEnabled(locked);
        personHobbies.setEnabled(locked);
        podstawowe.setEnabled(locked);
        zawodowe.setEnabled(locked);
        srednie.setEnabled(locked);
        wyzsze.setEnabled(locked);
        profileButton.setEnabled(locked);
    }
}