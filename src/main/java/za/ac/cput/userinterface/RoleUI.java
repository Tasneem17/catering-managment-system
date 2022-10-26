package za.ac.cput.userinterface;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class RoleUI {

    private static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static String run(String URL) throws IOException {
        Request request = new Request.Builder()
                .url(URL).addHeader("Authorization", Credentials.basic("userA","12345"))
                .build();

        try(Response response = client.newCall(request).execute()){
            return response.body().string();
        }
    }

    //Get all users from database
    public static void getAll(){
        try{
            final String URL = "http://localhost:8080/role/all";
            String responseBody = run(URL);
            JSONArray roles = new JSONArray(responseBody);

            for(int i = 0; i < roles.length(); i ++){
                JSONObject role = roles.getJSONObject(i);
                Gson g = new Gson();
                Role r = g.fromJson(role.toString(), Role.class);
                System.out.println(r.toString());
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    //Save User to database
    public  static void save(String id, String name, String description) {
        final String URL = "http://localhost:8080/role/save";

        Role role = RoleFactory.createRole(id, name, description);
        Gson g = new Gson();
        String RoleJSON = g.toJson(role);
        RequestBody body = RequestBody.create(RoleJSON, JSON);
        Request request = new Request.Builder()
                .url(URL).addHeader("Authorization",Credentials.basic("userA","12345"))
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            JOptionPane.showMessageDialog(null,response);
            response.body().string();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    //Delete user from database
    private static void delete(String roleID)  {
        final String URL = "http://localhost:8080/role/delete/" + roleID;
        Request request = new Request.Builder()
                .url(URL).addHeader("Authorization",Credentials.basic("userA","12345"))
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            Objects.requireNonNull(response.body()).string();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    //Read user from database
    private static void read(String roleID)  {
        final String URL = "http://localhost:8080/role/read/" + roleID;
        Request request = new Request.Builder()
                .url(URL).addHeader("Authorization",Credentials.basic("userA","12345"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        save("25552", "Zero", "Waiter");
        System.out.println("========================================");
        getAll();
        System.out.println("========================================");
        read("55634720");
        System.out.println("========================================");
//        getAll();
    }
}
