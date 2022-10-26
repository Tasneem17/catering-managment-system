package za.ac.cput.userinterface;

import com.google.gson.Gson;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;

import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class UserUI {

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
                final String URL = "http://localhost:8080/user/all";
                String responseBody = run(URL);
                JSONArray users = new JSONArray(responseBody);

                for(int i = 0; i < users.length(); i ++){
                    JSONObject user = users.getJSONObject(i);
                    Gson g = new Gson();
                    User u = g.fromJson(user.toString(), User.class);
                    System.out.println(u.toString());
                }
            }
            catch (IOException e){
                System.out.println(e);
            }
        }

        //Save User to database
        public  static void save(String id, String firstName, String lastName) {
            final String URL = "http://localhost:8080/user/save";

            User user = UserFactory.createUser(id,firstName, lastName);
            Gson g = new Gson();
            String UserJSON = g.toJson(user);
            RequestBody body = RequestBody.create(UserJSON, JSON);
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
        private static void delete(String userID)  {
            final String URL = "http://localhost:8080/user/delete/" + userID;
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
    private static void read(String userID)  {
        final String URL = "http://localhost:8080/user/read/" + userID;
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
            save("222", "Wilbur", "Smith");
            System.out.println("========================================");
            getAll();
            System.out.println("========================================");
            read("b67db2b5-f337-46bd-8f4c-11da23bdf210");
            System.out.println("========================================");
            getAll();
        }
    }

