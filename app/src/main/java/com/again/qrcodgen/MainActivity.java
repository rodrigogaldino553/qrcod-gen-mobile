package com.again.qrcodgen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    EditText edit_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_link = findViewById(R.id.edit_link);

    }

    public void sendLink(View view) {
        Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT).show();
    }

    public void request() throws IOException {
        URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"); //http://qrcod-gen.herokuapp.com/qrcode/show?
        HttpURLConnection client = null;
        try {
            client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("GET");
            client.setRequestProperty("content", edit_link.getText().toString());
            client.setDoOutput(true);

            OutputStream outputPost = new BufferedOutputStream(client.getOutputStream());
            writeStream(outputPost);
            outputPost.flush();
            outputPost.close();
        } catch(MalformedURLException error) {
            //Handles an incorrectly entered URL
        } catch(SocketTimeoutException error) {
            //Handles URL access timeout.
        } catch (IOException error) {
            //Handles input and output errors
        } finally {
            if(client != null) // Make sure the connection is not null.
            {
                client.disconnect();
            }
        }
    }

    private void writeStream(OutputStream outputPost) {
    }

    /*public void request() throws IOException {
        URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY"); //"http://qrcod-gen.herokuapp.com/qrcode/show?content="+edit_link.getText().toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
    }*/

}