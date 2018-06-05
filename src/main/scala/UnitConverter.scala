abstract class Unit[T](val conversionFactorFromBaseUnit: Double)

trait LengthUnit
object Meter extends Unit[LengthUnit](1)
object Centimeter extends Unit[LengthUnit](0.01)
object Inch extends Unit[LengthUnit](0.0254)

trait VolumeUnit
object Liter extends Unit[VolumeUnit](1)
object Gallon extends Unit[VolumeUnit](3.78)

case class Measure[T](private val value: Double, private val unit: Unit[T]) {

  def add(otherMeasure: Measure[T]) = {
    Measure(otherMeasure.valueInBaseUnit / unit.conversionFactorFromBaseUnit + value, unit)
  }

  private lazy val valueInBaseUnit = value * unit.conversionFactorFromBaseUnit

  override def hashCode(): Int = super.hashCode()

  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case otherLength: Measure[T] => otherLength.valueInBaseUnit == valueInBaseUnit
      case _ => false
    }
  }

}