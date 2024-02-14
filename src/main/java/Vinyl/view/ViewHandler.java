package Vinyl.view;

import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import Vinyl.viewmodel.ViewModelFactory;


public class ViewHandler
{
  private Scene scene;
  private Stage stage;
  private ViewFactory viewFactory;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewFactory = new ViewFactory(this, viewModelFactory);
    scene = new Scene(new Region());
  }

  public void start(Stage stage) {
    this.stage = stage;
    openView("home");
  }

  public void openView(String id) {
    Region root = viewFactory.loadView(id);
    scene.setRoot(root);
    stage.setScene(scene);
    stage.sizeToScene();
    stage.show();
  }

  public void close()
  {
    stage.close();
  }
}
