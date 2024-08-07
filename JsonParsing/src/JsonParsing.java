import javax.sound.midi.SysexMessage;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class JsonParsing {
    public static void main(String args[]){

        String file = "C:/Users/DELL/IdeaProjects/FileInput.json";
        String url = "jdbc:postgresql://localhost:5432/jsonparsing";
        String user="postgres";
        String password="root";

        StringBuilder jsonBuffer = new StringBuilder();
        try (
             BufferedReader br = new BufferedReader(new FileReader(file))) {
            String content;
            while((content=br.readLine())!=null){
                jsonBuffer.append(content);
            }
            System.out.println("JSON file read successfully.");
        } catch (IOException e) {
            System.out.println("Exception: "+e);
        }

        String str=jsonBuffer.toString();

        JSONArray array = null;
        try{
            array=new JSONArray(str);
            System.out.println("JSON parsed successfully.");
        }catch(Exception e){
            System.out.println("Exception: "+e);
        }

        String insertJson= "INSERT INTO result(id,name,age) VALUES (?,?,?)";

        Connection con=null;
        PreparedStatement statement=null;
        try{
            con= DriverManager.getConnection(url,user,password);

            if(con!=null){
                System.out.println("Database connection established successfully. ");
            }else{
                System.out.println("Failed to connect.");
            }
             statement=con.prepareStatement(insertJson);

                for(int i=0;i< array.length();i++){
                JSONObject obj=array.getJSONObject(i);

                statement.setInt(1,obj.getInt("id"));
                statement.setString(2,obj.getString("name"));
                statement.setInt(3,obj.getInt("age"));
                statement.addBatch();
            }
            int[] rowsArray=statement.executeBatch();
            System.out.println("Inserted "+rowsArray.length+" rows Successfully");
        } catch (SQLException e) {
            System.out.println("Exception: "+e);
        }

    }
}
