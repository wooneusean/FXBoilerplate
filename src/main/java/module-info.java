module win.woon.fxboilerplate {
    requires javafx.controls;
    requires javafx.fxml;


    opens win.woon.fxboilerplate to javafx.fxml;
    exports win.woon.fxboilerplate;
}