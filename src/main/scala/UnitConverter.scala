object UnitConverter {

  def sum2Length(firstLength: Double, firstUnit: Unit, secondLength: Double, secondUnit: Unit) = {
    normalizeToMeter(firstLength, firstUnit) + normalizeToMeter(secondLength, secondUnit)
  }


  def normalizeToMeter(input: Double, inputUnit: Unit): Double = {
    input * inputUnit.conversionFactorFromMeter
  }

  def convert(input: Double, inputUnit: Unit, outputUnit: Unit): Double = {
    (input * inputUnit.conversionFactorFromMeter) / outputUnit.conversionFactorFromMeter
  }
}

abstract class Unit(val conversionFactorFromMeter: Double)
object Meter extends Unit(1)
object Centimeter extends Unit(0.01)
object Inchi extends Unit(0.0254)