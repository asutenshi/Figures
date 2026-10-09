fun main() {
    val rect = Rect(x = 10, y = 20, width = 4, height = 2, id = 1)
    val circle = Circle(x = 5, y = 5, radius = 3, id = 2)
    val square = Square(x = 0, y = 0, width = 6, id = 3)

    val figures: List<Figure> = listOf(rect, circle, square)

    println("=== Исходные фигуры ===")
    figures.forEach { println(it) }

    println("\n=== Перемещение (move) на dx=5, dy=-2 ===")
    val movableFigures: List<Movable> = listOf(rect, circle, square)
    movableFigures.forEach { it.move(5, -2) }
    figures.forEach { println(it) }

    println("\n=== Масштабирование (resize) в 2 раза ===")
    val transformingFigures: List<Transforming> = listOf(rect, circle, square)
    transformingFigures.forEach { it.resize(2) }
    figures.forEach { println(it) }

    println("\n=== Поворот (rotate) по часовой стрелке вокруг точки (0, 0) ===")
    transformingFigures.forEach { it.rotate(RotateDirection.Clockwise, 0, 0) }
    figures.forEach { println(it) }

    println("\n=== Поворот (rotate) против часовой стрелки вокруг точки (0, 0) ===")
    transformingFigures.forEach { it.rotate(RotateDirection.CounterClockwise, 0, 0) }
    figures.forEach { println(it) }
}