package Vinyl.model;

public class BorrowedAndReserved implements State
{
  @Override public void borrow(Vinyl vinyl, Person person)
  {

  }

  @Override public void reserve(Vinyl vinyl, Person person)
  {

  }

  @Override public void returning(Vinyl vinyl)
  {
    vinyl.setState(new Reserved());
    vinyl.setBorrower(null);
  }

  @Override public String toString()
  {
    return "Borrowed and reserved";
  }
}
