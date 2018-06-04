import org.scalatest.FunSpec

class LengthTest extends FunSpec {

  describe("length") {
    it("should compare 2 lengths in meter and meter") {
      assert(Length(1, Meter) == Length(1, Meter))
    }

    it("should compare 2 lengths in meter and Inch") {
      assert(Length(1, Inch) == Length(0.0254, Meter))
    }
  }

  describe("sum of two length") {
    it("should return 2 when sum 1 meter and 100 cm") {
      assert(Length(1, Meter).add(Length(100, Centimeter)) == Length(2, Meter))
    }
    it("should return 3 inch when sum 2in and 2.5cm"){
      assert(Length(2, Inch).add(Length(2.5, Centimeter)) == Length(2.9842519685039375, Inch))
    }
  }

}
