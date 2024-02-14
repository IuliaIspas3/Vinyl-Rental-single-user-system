package Vinyl.model;

public interface State
{
 void borrow(Vinyl vinyl, Person person);
 void reserve(Vinyl vinyl, Person person);
 void returning(Vinyl vinyl);

 String toString();
}
