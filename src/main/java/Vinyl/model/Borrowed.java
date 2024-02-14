package Vinyl.model;

public class Borrowed implements State
{

  @Override public void borrow(Vinyl vinyl, Person person)
  {

  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {
    vinyl.setState(new BorrowedAndReserved());
    vinyl.setReservant(person);
  }

  @Override public void returning(Vinyl vinyl)
  {
    vinyl.setState(new Available());
    vinyl.setBorrower(null);
  }

  @Override public String toString()
  {
    return "Borrowed";
  }
}
