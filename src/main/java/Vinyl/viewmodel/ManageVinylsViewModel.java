package Vinyl.viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Vinyl.model.Model;
import Vinyl.model.Vinyl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ManageVinylsViewModel implements PropertyChangeListener
{
  private Model model;
  private ObjectProperty<ObservableList<Vinyl>> vinyls;
  public ManageVinylsViewModel(Model model) {
    this.model = model;
    this.vinyls = new SimpleObjectProperty<>();
    model.addListener(this);
  }

  public void update() {
    ObservableList<Vinyl> vinylsList = FXCollections.observableList(model.getVinyls());
    vinyls.set(vinylsList);
  }
  public void bindVinyls(ObjectProperty<ObservableList<Vinyl>> property) {
    update();
    property.bindBidirectional(vinyls);
  }

  public Model getModel() {
    return model;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
        update();
    });
  }
}
