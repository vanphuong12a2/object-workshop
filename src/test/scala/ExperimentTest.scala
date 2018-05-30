import org.scalatest.FunSpec

class ExperimentTest extends FunSpec {

  describe("probability of rolling a die") {
    it("should calculate probability of rolling a die") {
      assert(Experiment.withDie().getChance(3) == Chance(1, 6))
      assert(Experiment.withDie().getChance(4) == Chance(1, 6))
    }

    it("should calculate probability for NOTrolling a die") {
      assert(Experiment.withDie().getChanceReverse(3) == Chance(5, 6))
      assert(Experiment.withDie().getChanceReverse(4) == Chance(5, 6))
    }
  }

  describe("probability of two events") {

    it("should calculate probability of rolling two dice") {
      assert(Experiment.withDie().getChanceFor2Events(1, 6) == Chance(1, 36))
      assert(Experiment.withDie().getChanceFor2Events(1, 5) == Chance(1, 36))
    }

    it("should calculate probability of flipping two coins") {
      assert(new Experiment(List(1, 2)).getChanceFor2Events(1, 2) == Chance(1, 4))
    }

  }

  describe("probability of either event") {

    it("should calculate probability of rolling either dice") {
      assert(Experiment.withDie().getChanceForEitherEvent(1, 6) === Chance(11, 36))
    }

    it("should calculate probability of flipping two coins") {
      assert(new Experiment(List(1, 2)).getChanceForEitherEvent(1, 2) === Chance(3, 4))
    }

  }
}
