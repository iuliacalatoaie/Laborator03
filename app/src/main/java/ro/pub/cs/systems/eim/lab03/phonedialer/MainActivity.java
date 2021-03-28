package ro.pub.cs.systems.eim.lab03.phonedialer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;
    Button btnHash;
    Button btnStar;
    ImageButton btnCall;
    ImageButton btnHangup;
    ImageButton btnBackspace;

    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init buttons
        btnOne = findViewById(R.id.buttonOne);
        btnTwo = findViewById(R.id.buttonTwo);
        btnThree = findViewById(R.id.buttonThree);
        btnFour = findViewById(R.id.buttonFour);
        btnFive = findViewById(R.id.buttonFive);
        btnSix = findViewById(R.id.buttonSix);
        btnSeven = findViewById(R.id.buttonSeven);
        btnEight = findViewById(R.id.buttonEight);
        btnNine = findViewById(R.id.buttonNine);
        btnZero = findViewById(R.id.buttonZero);
        btnStar = findViewById(R.id.buttonStar);
        btnHash = findViewById(R.id.buttonHash);
        btnCall = findViewById(R.id.call);
        btnHangup = findViewById(R.id.hangup);
        btnBackspace = findViewById(R.id.backspace);

        input = findViewById(R.id.phone_number_edit_text);
    }

    public void one(View v) {
        onButtonClick(btnOne, input, Constants.ONE);
    }
    public void two(View v) {
        onButtonClick(btnTwo, input, Constants.TWO);
    }
    public void three(View v) {
        onButtonClick(btnThree, input, Constants.THREE);
    }
    public void four(View v) {
        onButtonClick(btnFour, input, Constants.FOUR);
    }
    public void five(View v) {
        onButtonClick(btnFive, input, Constants.FIVE);
    }
    public void six(View v) {
        onButtonClick(btnSix, input, Constants.SIX);
    }
    public void seven(View v) {
        onButtonClick(btnSeven, input, Constants.SEVEN);
    }
    public void eight(View v) {
        onButtonClick(btnEight, input, Constants.EIGHT);
    }
    public void nine(View v) {
        onButtonClick(btnNine, input, Constants.NINE);
    }
    public void zero(View v) {
        onButtonClick(btnZero, input, Constants.ZERO);
    }
    public void star(View v) {
        onButtonClick(btnStar, input, Constants.STAR);
    }
    public void hash(View v) {
        onButtonClick(btnHash, input, Constants.HASH);
    }
    public void call(View v) {
        if (input.getText().length() <= 3) {
            Toast.makeText(this, Constants.INVALID_NUMBER, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);

            String hash = input.getText().toString();

            if (hash.contains(Constants.HASH)) {
                hash.replace(Constants.HASH, Constants.HASH_REPLACEMENT);
            }
            intent.setData(Uri.parse(Constants.TEL_FORMAT + hash));
            startActivity(intent);
        }
    }
    public void hangup(View v) {
    }
    public void backspace(View v) {
        input.setText("");
    }

    public void onButtonClick(Button button, EditText inputNumber, String number) {
        String newNumber = inputNumber.getText().toString() + number;

        inputNumber.setText(newNumber);
    }
}