package Vinyl.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ModelManager implements Model
{
  private List<Vinyl> vinyls;
  private final PropertyChangeSupport support;
  public ModelManager() {
    this.vinyls = new ArrayList<>();
    this.support = new PropertyChangeSupport(this);
  }
  @Override public void addVinyls()
  {
    vinyls.add(new Vinyl("The Dark Side Of The Moon", "Pink Floyd", 2013));
    vinyls.add(new Vinyl("Born to die", "Bruce Springsteen", 2020));
    vinyls.add(new Vinyl("Bridge Over Troubled Water", "Simon And Garfunkel", 1990));
    vinyls.add(new Vinyl("Tapestry", "Carole King", 2020));
    vinyls.add(new Vinyl("Deja Vu", "Crosby, Stills, Nash & Young", 2015));
    vinyls.add(new Vinyl("Astral Weeks", "Van Morrison", 2000));
    vinyls.add(new Vinyl("Untitled", "Led Zeppelin", 1990));
    vinyls.add(new Vinyl("Sticky Fingers", "The Rolling Stones", 2002));
    vinyls.add(new Vinyl("Tommy", "The Who", 2021));
    vinyls.add(new Vinyl("The Beatles", "The Beatles", 1998));
  }
  @Override public void reserving(Vinyl vinyl, Person person)
  {
    State state = vinyl.getState();
    vinyl.getState().reserve(vinyl, person);
    support.firePropertyChange("reserve", state, vinyl.getState());
  }

  @Override public void borrowing(Vinyl vinyl, Person person)
  {
      State state = vinyl.getState();
      vinyl.getState().borrow(vinyl, person);
      support.firePropertyChange("borrow", state, vinyl.getState());
  }

  @Override public void returning(Vinyl vinyl)
  {
    State state = vinyl.getState();
    vinyl.getState().returning(vinyl);
    support.firePropertyChange("return", state, vinyl.getState());
  }

  @Override public void deleteVinyl(Vinyl vinyl)
  {
    vinyls.remove(vinyl);
    support.firePropertyChange("delete", vinyl, null);
  }

  public List<Vinyl> getVinyls()
  {
    return vinyls;
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
