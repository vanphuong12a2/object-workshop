import org.scalatest.FunSpec

class MeasureTest extends FunSpec {

  describe("compare length unit") {
    it("should compare 2 lengths in meter and meter") {
      assert(Measure(1, Meter) == Measure(1, Meter))
    }

    it("should compare 2 lengths in meter and Inch") {
      assert(Measure(1, Inch) == Measure(0.0254, Meter))
    }
  }

  describe("compare volume unit") {

    it("should compare gallon and liter") {
      assert(Measure(1, Gallon) == Measure(3.78, Liter))
    }

    it("should not compare meter and liter") {
      assert(Measure(1, Meter) != Measure(1, Liter))
    }
  }

  describe("sum of two length") {

    it("should return 2 when sum 1 meter and 100 cm") {
      assert(Measure(1, Meter).add(Measure(100, Centimeter)) == Measure(2, Meter))
    }

    it("should return 3 inch when sum 2in and 2.5cm") {
      assert(Measure(2, Inch).add(Measure(2.54, Centimeter)) == Measure(3, Inch))
    }
  }

  describe("sum of two volumes") {

    it("should return 2 gallons when sum 1 gallon and 1 gallon"){
      assert(Measure(1, Gallon).add(Measure(1, Gallon)) == Measure(2, Gallon))
    }

    it("should return 4.78 liters when sum 1 gallon and 1 liters"){
      assert(Measure(1, Gallon).add(Measure(1, Liter)) == Measure(4.78, Liter))
    }
  }

}
