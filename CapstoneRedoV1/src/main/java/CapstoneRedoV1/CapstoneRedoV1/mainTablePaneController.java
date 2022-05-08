package CapstoneRedoV1.CapstoneRedoV1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.google.gson.Gson;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class mainTablePaneController implements Initializable {

	@FXML
	TableView passwordTable;
	@FXML
	TableColumn<PasswordObject, String> passwordColumn;
	@FXML
	TableColumn<PasswordObject, String> usernameColumn;
	@FXML
	TableColumn<PasswordObject, String> websiteColumn;

	public static final String GetLink = ("https://b4gbbp0wng.execute-api.us-east-2.amazonaws.com/dev/pass");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println();
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
		passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
		websiteColumn.setCellValueFactory(new PropertyValueFactory<>("url")); 

		List<PasswordObject> list = (getPasswordList(getHttp("")).getList());
		for (int i = 0; i < list.size(); i++) { 
			passwordTable.getItems().add(list.get(i));
		}

	}

	private String getList() {

		try {

			BufferedReader buffReader = new BufferedReader(new InputStreamReader(new FileInputStream(
					"C:\\Users\\bryna\\eclipse-workspace\\CapstoneRedoV1\\src\\main\\java\\CapstoneRedoV1\\CapstoneRedoV1\\mockData.json")));
			String line = buffReader.readLine();
			String s = "";
			while ((line = buffReader.readLine()) != null) {
				s += line;
			}

			return s;
		} catch (IOException e) {
			return "an error happened";
		}
	}

	public PasswordListObject getPasswordList(String s) {
		Gson g = new Gson();
		return g.fromJson(s, PasswordListObject.class);
	}

	public static String getHttp(String s) {

		URL url;
		StringBuilder sb = new StringBuilder();
		try {
			url = new URL(GetLink);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			// Reading from the HTTP response body
			Scanner httpResponseScanner = new Scanner(con.getInputStream());
			while (httpResponseScanner.hasNextLine()) {
				sb.append(httpResponseScanner.nextLine());
			}
			httpResponseScanner.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}
