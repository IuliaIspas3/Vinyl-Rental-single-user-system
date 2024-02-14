package Vinyl.viewmodel;

import Vinyl.model.Model;

public class ViewModelFactory
{
  private ManageVinylsViewModel manageVinylsViewModel;
  private HomeViewModel homeViewModel;
  private ReserveRentViewModel reserveRentViewModel;

  public ViewModelFactory(Model model) {
    this.manageVinylsViewModel = new ManageVinylsViewModel(model);
    this.homeViewModel = new HomeViewModel(model);
    this.reserveRentViewModel = new ReserveRentViewModel(model);
  }

  public ManageVinylsViewModel getManageVinylsViewModel()
  {
    return manageVinylsViewModel;
  }

  public HomeViewModel getHomeViewModel() {
    return homeViewModel;
  }

  public ReserveRentViewModel getReserveRentViewModel()
  {
    return reserveRentViewModel;
  }
}
