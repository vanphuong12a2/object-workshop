case class Chance(numerator: Int, denominator: Int) {
  def reverse() = Chance(denominator - numerator, denominator)

  def *(otherChance: Chance) = Chance(numerator * otherChance.numerator, denominator * otherChance.denominator)

  def +(otherChance: Chance) = {
    if (denominator == otherChance.denominator) Chance(numerator + otherChance.numerator, denominator)
    else Chance(numerator * otherChance.denominator + otherChance.numerator * denominator, denominator * otherChance.denominator)
  }

  def -(otherChance: Chance) = {
    if (denominator == otherChance.denominator) Chance(numerator - otherChance.numerator, denominator)
    else Chance(numerator * otherChance.denominator - otherChance.numerator * denominator, denominator * otherChance.denominator)
  }

  def ===(otherChance: Chance) = {
    numerator*1.0/denominator == otherChance.numerator*1.0/otherChance.denominator
  }
}

class Experiment(space: List[Int]) {


  val spaceSize: Int = space.size

  def getChance(event: Int): Chance = {
    Chance(space.count(_ == event), spaceSize)
  }

  def getChanceReverse(event: Int): Chance = {
    getChance(event).reverse()
  }

  def getChanceFor2Events(firstEvent: Int, secondEvent: Int) = {
    getChance(firstEvent) * getChance(secondEvent)
  }

  def getChanceForEitherEvent(firstEvent: Int, secondEvent: Int) = {
    getChance(firstEvent) + getChance(secondEvent) - getChanceFor2Events(firstEvent, secondEvent)
  }
}

object Experiment {
  def withDie()= new Experiment(List(1, 2, 3, 4, 5, 6))
}
