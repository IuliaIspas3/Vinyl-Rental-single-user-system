module Vinyl {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires javafx.base;
  requires javafx.graphics;

  opens Vinyl to javafx.fxml;
  opens Vinyl.view to javafx.fxml;

  exports Vinyl;
}