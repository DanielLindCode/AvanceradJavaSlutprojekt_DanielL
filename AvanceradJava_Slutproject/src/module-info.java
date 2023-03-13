module AvanceradJava_Slutproject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires okhttp3;
	requires org.json;
	
	opens application to javafx.graphics, javafx.fxml;
}
