package Vinyl.view;

import Vinyl.viewmodel.HomeViewModel;
import Vinyl.viewmodel.ManageVinylsViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class HomeController
{
  @FXML Button homeButton;
  @FXML Button manageButton;
  @FXML Button reserveRentButton;
  @FXML Button exit;
  private Region root;
  private ViewHandler viewHandler;
  private HomeViewModel homeViewModel;

  public void init(Region root, ViewHandler viewHandler, HomeViewModel homeViewModel)
  {
    this.root = root;
    this.viewHandler = viewHandler;
    this.homeViewModel = homeViewModel;
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
  public void reset() {

  }

  public Region getRoot()
  {
    return root;
  }
}
