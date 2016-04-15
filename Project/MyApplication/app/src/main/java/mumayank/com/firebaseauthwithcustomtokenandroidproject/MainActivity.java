package mumayank.com.firebaseauthwithcustomtokenandroidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

import mumayank.com.firebaseauthwithcustomtokenandroidproject.FirebaseTokenGenerator.TokenGenerator;

public class MainActivity extends AppCompatActivity {
    Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init Firebase
        Firebase.setAndroidContext(this);

        // set your Firebase link
        // edit strings.xml to set your Firebase link
        myFirebaseRef = new Firebase(getString(R.string.my_firebase_link));

        // prepare auth token
        // edit strings.xml to set your Firebase secret
        // it is your responsibility to obfuscate your Firebase sercret before shipping your code
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("uid", "uniqueId1");
        payload.put("some", "arbitrary");
        payload.put("data", "here");
        // check https://github.com/firebase/firebase-token-generator-java#token-options for more options which you can set
        TokenGenerator tokenGenerator = new TokenGenerator(getString(R.string.my_firebase_secret));
        String token = tokenGenerator.createToken(payload);

        debugUnauthFirebase();

        // auth Firebase with custom token
        myFirebaseRef.authWithCustomToken(token, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticationError(FirebaseError error) {
                ((TextView)findViewById(R.id.textView)).setText("Login Failed! " + error.getMessage()+"\n\nHint: Did you set your Firebase link and secret in strings.xml?");
            }
            @Override
            public void onAuthenticated(AuthData authData) {
                ((TextView)findViewById(R.id.textView)).setText("Login Succeeded!");
            }
        });
    }

    private void debugUnauthFirebase() {
        // This is just a debug method
        // I want to unauth everytime app starts
        // So that I can force auth flow of Firebase everytime
        // (You may comment this function out)
        myFirebaseRef.unauth();
    }
}
