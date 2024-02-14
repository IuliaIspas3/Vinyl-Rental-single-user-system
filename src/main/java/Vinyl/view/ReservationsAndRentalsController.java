package Vinyl.view;

import Vinyl.model.Person;
import Vinyl.model.Vinyl;
import Vinyl.viewmodel.ReserveRentViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;


public class ReservationsAndRentalsController
{
  @FXML ListView<Vinyl> vinylListView;
  @FXML Button homeButton;
  @FXML Button manageButton;
  @FXML Button reserveRentButton;
  @FXML Button exit;
  @FXML Button borrowButton;
  @FXML Button reserveButton;
  @FXML Button returnButton;
  private Region root;
  private ViewHandler viewHandler;
  private ReserveRentViewModel reserveRentViewModel;

  public void init(Region root, ViewHandler viewHandler, ReserveRentViewModel reserveRentViewModel) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.reserveRentViewModel = reserveRentViewModel;

    reserveRentViewModel.bindVinyls(vinylListView.itemsProperty());
  }

  public void action(ActionEvent e) {
    if (e.getSource() == homeButton) {
      viewHandler.openView("home");
    }
    if (e.getSource() == reserveRentButton) {
      viewHandler.openView("reserve");
    }
    if (e.getSource() == manageButton) {
      viewHandler.openView("manage");
    }
    if(e.getSource() == exit)
    {
      viewHandler.close();
    }
  }

  public void chooseVinyl(ActionEvent e) {
    if (e.getSource() == borrowButton) {
      Vinyl vinyl = vinylListView.getSelectionModel().getSelectedItem();
      reserveRentViewModel.borrowing(vinyl, new Person("(you)"));
    }
    if (e.getSource() == reserveButton) {
      Vinyl vinyl = vinylListView.getSelectionModel().getSelectedItem();
      reserveRentViewModel.reserving(vinyl, new Person("(you)"));
    }
    if (e.getSource() == returnButton) {
      Vinyl vinyl = vinylListView.getSelectionModel().getSelectedItem();
      reserveRentViewModel.returning(vinyl);
    }
  }
  public void reset() {

  }

  public Region getRoot()
  {
    return root;
  }

}
