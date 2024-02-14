package Vinyl.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import Vinyl.model.Vinyl;
import Vinyl.viewmodel.ManageVinylsViewModel;

import java.io.Serializable;

public class ManageVinylsController implements Serializable
{
  @FXML ListView<Vinyl> vinylListView;
  @FXML Button homeButton;
  @FXML Button manageButton;
  @FXML Button reserveRentButton;
  @FXML Button exit;
  @FXML Button removeButton;
  private Region root;
  private ViewHandler viewHandler;
  private ManageVinylsViewModel manageVinylsViewModel;


  public void init(Region root, ViewHandler viewHandler, ManageVinylsViewModel manageVinylsViewModel) {
    this.root = root;
    this.viewHandler = viewHandler;
    this.manageVinylsViewModel = manageVinylsViewModel;

    manageVinylsViewModel.bindVinyls(vinylListView.itemsProperty());

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

  public void onClick() {
    //biding?
    Vinyl vinyl = vinylListView.getSelectionModel().getSelectedItem();
    manageVinylsViewModel.getModel().deleteVinyl(vinyl);
  }

  public void reset() {

  }

  public Region getRoot()
  {
    return root;
  }


}
