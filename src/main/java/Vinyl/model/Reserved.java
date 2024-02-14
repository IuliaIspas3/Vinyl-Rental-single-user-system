package Vinyl.model;

public class Reserved implements State
{
  @Override public void borrow(Vinyl vinyl, Person person)
  {
    if (vinyl.getReservant().equals(person)) {
      vinyl.setState(new Borrowed());
      vinyl.setBorrower(person);
    }
  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {

  }

  @Override public void returning(Vinyl vinyl)
  {

  }

  @Override public String toString()
  {
    return "Reserved";
  }
}
