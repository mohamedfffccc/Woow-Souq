package com.woow.appwoowsouq.view.acivity.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.view.acivity.HomeActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.activity_login_tool_bar)
    Toolbar activityLoginToolBar;
    @BindView(R.id.activity_login_tv_email)
    EditText activityLoginTvEmail;
    @BindView(R.id.activity_login_tv_password)
    EditText activityLoginTvPassword;
    @BindView(R.id.activity_login_btn_login)
    Button activityLoginBtnLogin;
    @BindView(R.id.activity_login_tv_create_a_new_account)
    TextView activityLoginTvCreateANewAccount;

    @BindView(R.id.activity_login_btn_login_facebook)
    LoginButton activityLoginBtnLoginFacebook;
    @BindView(R.id.sign_in_button)
    SignInButton signInButton;
    private CallbackManager callbackManager;
    private static final String EMAIL = "email";
    private GoogleSignInClient mGoogleSignInClient;
    private int RC_SIGN_IN = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        updateUI(account);

        FacebookSdk.sdkInitialize(LoginActivity.this);
//        AppEventsLogger.activateApp(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        activityLoginBtnLoginFacebook.setReadPermissions(Arrays.asList(EMAIL));
        activityLoginBtnLoginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("LoginActivity", response.toString());

                                // Application code
                                try {
                                    Log.d("tttttt", object.getString("id"));
                                    String birthday = "";
                                    if (object.has("birthday")) {
                                        birthday = object.getString("birthday"); // 01/31/1980 format
                                    }

                                    String fnm = object.getString("first_name");
                                    String lnm = object.getString("last_name");
                                    Toast.makeText(LoginActivity.this, fnm + " " + lnm, Toast.LENGTH_SHORT).show();
                                    String mail = object.getString("email");
                                    String gender = object.getString("gender");
                                    String fid = object.getString("id");
                                    //https://graph.facebook.com/143990709444026/picture?type=large
                                    Log.d("aswwww", "https://graph.facebook.com/" + fid + "/picture?type=large");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, first_name, last_name, email, gender, birthday, location");
                request.setParameters(parameters);
                request.executeAsync();


                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }

    @OnClick({R.id.activity_login_btn_login, R.id.activity_login_tv_create_a_new_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_login_btn_login:
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                break;
            case R.id.activity_login_tv_create_a_new_account:
                startActivity(new Intent(LoginActivity.this, Registratoin.class));
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Toast.makeText(this, account.getEmail(), Toast.LENGTH_SHORT).show();

            // Signed in successfully, show authenticated UI.
//            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
//            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
        }
    }

}
