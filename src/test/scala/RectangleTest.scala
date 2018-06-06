import org.scalatest.FunSpec
import org.scalatest.prop.TableDrivenPropertyChecks._

class RectangleTest extends FunSpec {

  describe("rectangle object") {
    it("should throw exception when width is 0") {
      val caught =
        intercept[IllegalArgumentException] {
          new Rectangle(0, 1)
        }
      assert(caught.getMessage == "Size needs to be a positive number")
    }

    it("should throw exception when width is -42") {
      val caught =
        intercept[IllegalArgumentException] {
          new Rectangle(-42, 1)
        }
      assert(caught.getMessage == "Size needs to be a positive number")
    }
  }
  describe("should calculate area for positive numbers") {
    val rectangles = Table(
      ("width", "height", "area"),
      (2, 3, 6),
      (2, 5, 10)
    )

    forAll(rectangles) { (width, height, expectedArea) =>
      assert(new Rectangle(width, height).area() == expectedArea)
    }
  }

  describe("perimeter") {
    it("should return 10 when the rectangle is 2x3") {
      assert(new Rectangle(2, 3).perimeter() == 10)
    }

    it("should throw exception when perimeter is bigger than maxInt") {
      assert(new Rectangle(1000000000, 2000000000).perimeter() == 6000000000L)
    }
  }
}
