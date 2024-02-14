package Vinyl.model;

public class Vinyl
{
  private String title;
  private String artist;
  private int year;
  private State state;
  private Person reservant;
  private Person borrower;

  public Vinyl(String title, String artist, int year) {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.state = new Available();
    reservant = null;
    borrower = null;
  }

  public synchronized State getState() {
    return this.state;
  }

  public synchronized void setState(State state) {
    this.state = state;
  }
  public synchronized void setReservant(Person reservant) {
    this.reservant = reservant;
  }

  public synchronized void setBorrower(Person borrower) {
    this.borrower = borrower;
  }


  public synchronized Person getReservant() {
    return reservant;
  }

  public synchronized Person getBorrower()
  {
    return borrower;
  }

  public synchronized String toString() {
    String temp = title + ", " + artist + ", " + year + "        " + state + " ";
    if (reservant != null) {
      temp += "The reservant is: " + reservant.getName() + " ";
    }
    if (borrower != null) {
      temp += "The borrower is: " + borrower.getName() + " ";
    }
    return temp;
  }

}
