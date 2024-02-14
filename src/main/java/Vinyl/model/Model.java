package Vinyl.model;

import java.beans.PropertyChangeListener;
import java.util.List;

public interface Model
{
  void reserving(Vinyl vinyl, Person person);
  void borrowing(Vinyl vinyl, Person person);
  void returning(Vinyl vinyl);
  void deleteVinyl(Vinyl vinyl);
  void addVinyls();
  List<Vinyl> getVinyls();

  void addListener(PropertyChangeListener listener);
  void removeListener(PropertyChangeListener listener);
}
