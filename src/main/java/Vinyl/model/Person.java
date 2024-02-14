package Vinyl.model;

import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person implements Runnable
{
  private String name;
  private Model modelManager;

  public Person(String name, Model modelManager)
  {
    this.name = name;
    this.modelManager = modelManager;
  }

  public Person(String name) {
    this.name = name;
    this.modelManager = null;
  }

  public String getName()
  {
    return name;
  }

  @Override public String toString()
  {
    return name;
  }

  public void reserveVinyl(Vinyl vinyl)
  {
    Platform.runLater(() -> {
      modelManager.reserving(vinyl, this);
    });
  }

  public void borrowVinyl(Vinyl vinyl)
  {
    Platform.runLater(() -> {
      modelManager.borrowing(vinyl, this);
    });
  }

  public void returnVinyl(Vinyl vinyl)
  {
    Platform.runLater(() -> {
      modelManager.returning(vinyl);
    });
  }

  @Override public void run()
  {
    //If you need to update a GUI component from a non-GUI thread, you can use that to put your update in a queue and it will be handled by the GUI thread as soon as possible.
      Random random = new Random();
      while(true)
      {
        int index = random.nextInt(modelManager.getVinyls().size());
        if (modelManager.getVinyls().get(index).getState() instanceof Available)
        {
          int choose = random.nextInt(2);
          if (choose == 0) {
            try {
              borrowVinyl(modelManager.getVinyls().get(index));
              Thread.sleep(5000);
            } catch (InterruptedException e) {
              throw new RuntimeException();
            }

          } else {
            try {
              reserveVinyl(modelManager.getVinyls().get(index));
              Thread.sleep(5000);
            } catch (InterruptedException e) {
              throw new RuntimeException();
            }          }
        } else if (modelManager.getVinyls().get(index).getState() instanceof Borrowed) {
          int choose = random.nextInt(2);
          if (choose == 0) {
            try {
              reserveVinyl(modelManager.getVinyls().get(index));
              Thread.sleep(5000);
            } catch (InterruptedException e) {
              throw new RuntimeException();
            }

          } else {
            try {
              returnVinyl(modelManager.getVinyls().get(index));
              Thread.sleep(5000);
            } catch (InterruptedException e) {
              throw new RuntimeException();
            }          }
        }
      }
  }
}

