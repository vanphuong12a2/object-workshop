import org.scalatest.FunSpec

class UnitConverterTest extends FunSpec {

  describe("converting units") {
    it("should get length in meters") {
      assert(UnitConverter.convert(2, Meter, Meter) == 2)
    }

    it("should get length in centimeters") {
      assert(UnitConverter.convert(1.5, Meter, Centimeter) == 150)
    }

    it("should convert value from inch to centimeters") {
      assert(UnitConverter.convert(1, Inchi, Centimeter) == 2.54)
    }
  }

  describe("normalizing to meter") {
    it("should get length in meters") {
      assert(UnitConverter.normalizeToMeter(100, Centimeter) == 1)
    }
  }

  describe("sum up 2 length") {
    it("should return 2 meters when sum up 1 meter and 100 cm") {
      assert(UnitConverter.sum2Length(1, Meter, 100, Centimeter) == 2)
    }
  }

}
