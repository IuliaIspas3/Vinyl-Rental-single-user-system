package Vinyl.model;

public class Available implements State
{

  @Override public void borrow(Vinyl vinyl, Person person)
  {
    vinyl.setState(new Borrowed());
    vinyl.setBorrower(person);
  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {
    vinyl.setState(new Reserved());
    vinyl.setReservant(person);
  }

  @Override public void returning(Vinyl vinyl)
  {

  }

  @Override public String toString()
  {
    return "Available";
  }
}
