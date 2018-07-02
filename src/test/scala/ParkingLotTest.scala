import org.scalatest.FunSpec

class ParkingLotTest extends FunSpec {

  describe("parking lot") {
    it("should be able to park a car") {
      val aCar = new Car
      val parkingLot = new ParkingLot()
      assert(parkingLot.park(aCar))
    }

    it("should be able to retrieve my car") {
      val myCar = new Car
      val parkingLot = new ParkingLot()
      parkingLot.park(myCar)

      assert(parkingLot.retrieve(myCar))
    }

    it("should not retrieve a car that not in parking lot") {
      val myCar = new Car
      val parkingLot = new ParkingLot()
      assert(!parkingLot.retrieve(myCar))
    }

  }

}
