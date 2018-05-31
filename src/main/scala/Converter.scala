object Converter {

  def convertToInch(value: Cm): Inch = {
    value.toInch()
  }
}

case class Cm(value: Double) {
  def toInch() = Inch(value/2.54)
}

case class Inch(value: Double)

