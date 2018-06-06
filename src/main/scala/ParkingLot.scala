class ParkingLot {
  private var cars: List[Car] = List()

  def retrieve(myCar: Car): Boolean = cars.contains(myCar)

  def park(aCar: Car) = {
    cars = aCar :: cars
    true
  }

}

case class Car(plateNumber: Int)
