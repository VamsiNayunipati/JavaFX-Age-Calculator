import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Period;
import javafx.application.Application;

public class FXAgeCalculator extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        Label promptLabel = new Label("Pick Jane’s birth date");
        DatePicker datePicker = new DatePicker();
        Label ageLabel = new Label();
        ageLabel.setVisible(false);

        datePicker.setOnAction(event ->
        {
            LocalDate birthDate = datePicker.getValue();
            LocalDate currentDate = LocalDate.now();
            
            if (birthDate != null) {
                Period period = Period.between(birthDate, currentDate);
                int years = period.getYears();
                int months = period.getMonths();
                int days = period.getDays();

                String ageText = "Jane’s age is " + years + " years, " + months + " months, and " + days + " days.";
                ageLabel.setText(ageText);
                ageLabel.setVisible(true);
            }
        });

        VBox vbox = new VBox(10, promptLabel, datePicker, ageLabel);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");
        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setTitle("Age Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
