package Vinyl.viewmodel;

import Vinyl.model.Model;
import Vinyl.model.Person;
import Vinyl.model.Vinyl;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReserveRentViewModel implements PropertyChangeListener
{
  private Model model;
  private ObjectProperty<ObservableList<Vinyl>> vinyls;
  public ReserveRentViewModel(Model model) {
    this.model = model;
    this.vinyls = new SimpleObjectProperty<>();
    model.addListener(this);
  }

  public void bindVinyls(ObjectProperty<ObservableList<Vinyl>> property) {
    update();
    property.bindBidirectional(vinyls);
  }

  public void borrowing(Vinyl vinyl, Person person) {
    this.model.borrowing(vinyl, person);
  }

  public void reserving(Vinyl vinyl, Person person) {
    this.model.reserving(vinyl, person);
  }

  public void returning(Vinyl vinyl) {
    this.model.returning(vinyl);
  }

  public void update() {
    ObservableList<Vinyl> vinylsList = FXCollections.observableList(model.getVinyls());
    vinyls.set(vinylsList);
  }


  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      update();
    });
  }
}
