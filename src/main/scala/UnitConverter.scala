abstract class Unit(val conversionFactorFromMeter: Double)
object Meter extends Unit(1)
object Centimeter extends Unit(0.01)
object Inch extends Unit(0.0254)

case class Length(value: Double, unit: Unit) {

  def add(otherLength: Length) = {
    val resultValue = otherLength.valueInMeter + valueInMeter
    Length(resultValue, Meter)
  }

  private lazy val valueInMeter = value * unit.conversionFactorFromMeter

  override def hashCode(): Int = super.hashCode()

  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case otherLength: Length => otherLength.valueInMeter == valueInMeter
      case _ => false
    }
  }
}