class Rectangle(width: Int, height: Int) {

  if (width <= 0 || height <= 0) throw new IllegalArgumentException("Size needs to be a positive number")

  def area(): Int = width * height

  def perimeter(): Long = width * 2L + height * 2L
}