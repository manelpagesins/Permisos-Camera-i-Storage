package cat.dam.andy.permisoscameraistorage;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button_Camera;
    Button button_Storage;
    TextView message_permissos;

    //Variables en static per poder accedir desde cualsevol funcio
    static int Code_Camera = 1;
    static int Code_Storage = 2;

    @RequiresApi(api = Build.VERSION_CODES.M)
    /**
     * Funcio en la que podrem concedir permissos de Camera amb la nostre aplicacio
     */
    public void Camera(TextView message_permissos) {

        int permis_Camera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        //Condicional per reconexier el estat dels permissos
        if (permis_Camera == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, Code_Camera);
        }else{
            message_permissos.setText("PERMISOS DE CÀMERA CONCEDITS!");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    /**
     * Funcio en la que podrem concedir permissos de Emmgatazematge a la nostre Apilcacio
     */
    public void Storage(TextView message_permissos) {
        int permiss_Storage = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        //Condicional per reconexier el estat dels permissos
        if (permiss_Storage == PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, Code_Storage);
        } else {
            message_permissos.setText("PERMISOS D'EMMAGATZEMATGE CONCEDITS!");
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_Camera = (Button) findViewById(R.id.button_Camera);
        button_Storage = (Button) findViewById(R.id.button_Storage);
        message_permissos = (TextView) findViewById(R.id.messagePermissos);

        button_Camera.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Camera(message_permissos);
            }
        });
        button_Storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Storage(message_permissos);
            }
        });
    }
}