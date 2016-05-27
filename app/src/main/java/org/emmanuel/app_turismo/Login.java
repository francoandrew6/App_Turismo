package org.emmanuel.app_turismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.emmanuel.app_turismo.bean.Usuario;
import org.emmanuel.app_turismo.volley.WebService;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private TextView txtEmail,txtPass;
    private Button btnLogin;
    private Usuario userLogged=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        txtEmail=(TextView) findViewById(R.id.txtEmail);
        txtPass=(TextView) findViewById(R.id.txtPass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> params=new HashMap<String, String>();
                params.put("correo",txtEmail.getText().toString());
                params.put("contraseña",txtPass.getText().toString());

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, WebService.autenticar, new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray listaUsuarios=response.getJSONArray("data");
                            if(listaUsuarios.length()>0){
                                //Toast.makeText(getApplicationContext(),"Bienvenido",Toast.LENGTH_LONG).show();
                                JSONObject user=listaUsuarios.getJSONObject(0);
                                userLogged=new Usuario(
                                        user.getInt("id_Usuario"),
                                        user.getString("nombre"),
                                        user.getString("correo"),
                                        user.getString("nick"),
                                        "none",
                                        user.getString("direccion"),
                                        user.getInt("telefono"),
                                        user.getInt("id_Rol"),
                                        response.getString("token"),
                                        response.getString("exp")
                                );
                                startActivity(new Intent(Login.this,Lista.class));
                            }else{
                                Toast.makeText(getApplicationContext(),"Verifique sus Credenciales",Toast.LENGTH_LONG).show();
                            }
                        }catch(Exception ex){
                            Log.e("Response exception ",ex.getMessage());
                        }

                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError err) {
                        Log.d("Error: Response ",err.getMessage());
                    }
                }
                );
                WebService.getInstance(v.getContext()).addToRequestQueue(request);
            }
        });
    }
}
