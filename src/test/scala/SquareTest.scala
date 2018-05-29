import org.scalatest.FunSpec

class SquareTest extends FunSpec {

  describe("square object") {
    it("should throw exception when size is 0") {
      val caught =
        intercept[IllegalArgumentException] {
          new Square(0)
        }
      assert(caught.getMessage == "Size needs to be a positive number")
    }
}
