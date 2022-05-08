module CapstoneRedoV1.CapstoneRedoV1 {
    requires javafx.controls;
    requires javafx.fxml;
	requires com.google.gson;
	requires org.apache.httpcomponents.httpclient;

    opens CapstoneRedoV1.CapstoneRedoV1 to javafx.fxml;
    exports CapstoneRedoV1.CapstoneRedoV1;
}
