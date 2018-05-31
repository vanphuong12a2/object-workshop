import org.scalatest.FunSpec

class ConverterTest extends FunSpec {

  describe("convert cm to inches") {

    it("should return 1 for 2.54 cm") {
      assert(Converter.convertToInch(Cm(2.54)) == Inch(1.0))
    }

    it("should return 2 for 5.08 cm") {
      assert(Converter.convertToInch(Cm(5.08)) == Inch(2.0))
    }
  }

  describe("convert foot to inches") {

    it("should return 1 for 12 foot") {
      assert(Converter.convertToInch(Cm(2.54)) == Inch(1.0))
    }
  }
}
