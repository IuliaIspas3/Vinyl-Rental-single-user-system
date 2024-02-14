package Vinyl;

import Vinyl.model.Model;
import Vinyl.model.ModelManager;
import Vinyl.model.Person;
import Vinyl.view.ViewHandler;
import Vinyl.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application
{
  @Override public void start(Stage primaryStage) throws Exception
  {
    Model model = new ModelManager();
    model.addVinyls();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
      Runnable person1 = new Person("Bob", model);
      Thread thread1 = new Thread(person1);
      thread1.start();
      Runnable person2 = new Person("Wendy", model);
      Thread thread2 = new Thread(person2);
      thread2.start();
    viewHandler.start(primaryStage);
  }
}
