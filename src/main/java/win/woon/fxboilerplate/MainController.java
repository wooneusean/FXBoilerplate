package win.woon.fxboilerplate;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    MainControllerViewModel vm = new MainControllerViewModel();

    @FXML
    private TextField ftFXMLBinding;

    @FXML
    private TextField ftProgrammaticBinding1;

    @FXML
    private TextField ftProgrammaticBinding2;

    @FXML
    private TextField ftFXMLControllerBinding;

    public final StringProperty controllerBinding = new SimpleStringProperty("");

    public String getControllerBinding() {
        return controllerBinding.get();
    }

    public StringProperty ControllerBindingProperty() {
        return controllerBinding;
    }

    public void setControllerBinding(String fourthBindingProperty) {
        this.controllerBinding.set(fourthBindingProperty);
    }

    @FXML
    private TextField ftProgrammaticControllerBinding;

    @FXML
    private TextField ftProgrammaticViewModelBinding;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Bindings.bindBidirectional(ftProgrammaticBinding1.textProperty(), ftProgrammaticBinding2.textProperty());

        // Bind to controller programmatically
        ftProgrammaticControllerBinding.textProperty().bindBidirectional(ControllerBindingProperty());

        ftProgrammaticViewModelBinding.textProperty().bindBidirectional(vm.viewModelBindingStringProperty());
    }

    @FXML
    public void changeValue(ActionEvent actionEvent) {
        controllerBinding.set(new Date().toString());
    }
}

class MainControllerViewModel {
    private final StringProperty viewModelBindingString = new SimpleStringProperty("");

    public String getViewModelBindingString() {
        return viewModelBindingString.get();
    }

    public StringProperty viewModelBindingStringProperty() {
        return viewModelBindingString;
    }

    public void setViewModelBindingString(String viewModelBindingString) {
        this.viewModelBindingString.set(viewModelBindingString);
    }
}