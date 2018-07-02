import scala.reflect.ClassTag

abstract class Unit[T](val conversionFunctionFromBaseUnit: (BigDecimal) => BigDecimal, val valueCondition: (BigDecimal) => Boolean)(implicit val tag: ClassTag[T])

trait Length
object Meter extends Unit[Length](1 * _, _ >= 0)
object Centimeter extends Unit[Length](0.01 * _, _ >= 0)
object Inch extends Unit[Length](0.0254 * _, _ >= 0)

trait Volume
object Liter extends Unit[Volume](1 * _, _ >= 0)
object Gallon extends Unit[Volume](3.78 * _, _ >= 0)

trait Temperature
object Fahrenheit extends Unit[Temperature](_ * 1, _ => true)
object Celsius extends Unit[Temperature](32 + 1.8 * _, _ => true)

case class Measure[T](private val value: BigDecimal, private val unit: Unit[T]) {

  if(!unit.valueCondition(value)) throw new IllegalArgumentException("Illegal value")

  def add(otherMeasure: Measure[T]): Measure[T] = {
    Measure(1/unit.conversionFunctionFromBaseUnit(1/otherMeasure.valueInBaseUnit) + value, unit)
  }

  private lazy val valueInBaseUnit = unit.conversionFunctionFromBaseUnit(value)

  override def hashCode(): Int = super.hashCode()

  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case otherLength: Measure[T] =>
        unit.tag == otherLength.unit.tag && otherLength.valueInBaseUnit == valueInBaseUnit
      case _ => false
    }
  }
}

//TODO: compare 212F = 100C