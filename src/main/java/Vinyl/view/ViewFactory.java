package Vinyl.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import Vinyl.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewFactory
{
  private HomeController homeController;
  private ManageVinylsController manageVinylsController;
  private ReservationsAndRentalsController reservationsAndRentalsController;
  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;

  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    homeController = null;
    manageVinylsController = null;
    reservationsAndRentalsController = null;
  }

  public Region loadView(String id) {
    return switch (id){
      case "manage" -> loadManageVinyls();
      case "home" -> loadHome();
      case "reserve" -> loadReserve();
      default -> throw new RuntimeException("The id was not found");
    };
  }

  private Region loadManageVinyls() {
    if (manageVinylsController == null) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vinyl/ManageVinyls.fxml"));
      try {
        Region root = loader.load();
        manageVinylsController = loader.getController();
        manageVinylsController.init(root, viewHandler, viewModelFactory.getManageVinylsViewModel());
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    return manageVinylsController.getRoot();
  }

  private Region loadHome() {
    if (homeController == null) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vinyl/Home.fxml"));
      try {
        Region root = loader.load();
        homeController = loader.getController();
        homeController.init(root, viewHandler, viewModelFactory.getHomeViewModel());
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    return homeController.getRoot();
  }

  private Region loadReserve() {
    if (reservationsAndRentalsController == null) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vinyl/ReservationsAndRentals.fxml"));
      try {
        Region root = loader.load();
        reservationsAndRentalsController = loader.getController();
        reservationsAndRentalsController.init(root, viewHandler, viewModelFactory.getReserveRentViewModel());
      }
      catch (IOException e)
      {
        throw new RuntimeException(e);
      }
    }
    return reservationsAndRentalsController.getRoot();
  }
}

