class ParkingLot {
  private var car: Option[Car] = None

  def retrieve(myCar: Car): Boolean = car.contains(myCar)

  def park(aCar: Car): Boolean = {
    car = Some(aCar)
    true
  }
}

class Car
