# Figures (Геометрические фигуры на Kotlin)

Проект реализует иерархию классов геометрических фигур (`Rect`, `Circle`, `Square`), поддерживающих перемещение (`Movable`), масштабирование и поворот на 90 градусов (`Transforming`), а также расчет площади (`Figure`).

## Архитектура

- **`Figure`** — абстрактный базовый класс с идентификатором `id` и абстрактным методом `area(): Float`.
- **`Movable`** — интерфейс перемещения:
  - `move(dx: Int, dy: Int)` — смещение координат фигуры.
- **`Transforming`** — интерфейс геометрических преобразований:
  - `resize(zoom: Int)` — масштабирование фигуры с сохранением пропорций.
  - `rotate(direction: RotateDirection, centerX: Int, centerY: Int)` — поворот вокруг заданной точки на 90° (`Clockwise` / `CounterClockwise`).
- **Фигуры**:
  - `Rect(x, y, width, height, id)` — прямоугольник. При повороте меняются размеры (`width` и `height` меняются местами) и координаты.
  - `Circle(x, y, radius, id)` — окружность с центром в `(x, y)`.
  - `Square(x, y, width, id)` — квадрат со стороной `width`.

---

## Запуск проекта

### Сборка и запуск через командную строку:

```bash
kotlinc src/*.kt -include-runtime -d app.jar
java -jar app.jar
```

---

## Демонстрация работы (`Main.kt`)

### Код демонстрации:

```kotlin
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
```

### Вывод программы:

```text
=== Исходные фигуры ===
Rect(id=1, x=10, y=20, width=4, height=2, area=8.0)
Circle(id=2, x=5, y=5, radius=3, area=28.274334)
Square(id=3, x=0, y=0, width=6, area=36.0)

=== Перемещение (move) на dx=5, dy=-2 ===
Rect(id=1, x=15, y=18, width=4, height=2, area=8.0)
Circle(id=2, x=10, y=3, radius=3, area=28.274334)
Square(id=3, x=5, y=-2, width=6, area=36.0)

=== Масштабирование (resize) в 2 раза ===
Rect(id=1, x=15, y=18, width=8, height=4, area=32.0)
Circle(id=2, x=10, y=3, radius=6, area=113.097336)
Square(id=3, x=5, y=-2, width=12, area=144.0)

=== Поворот (rotate) по часовой стрелке вокруг точки (0, 0) ===
Rect(id=1, x=18, y=-15, width=4, height=8, area=32.0)
Circle(id=2, x=3, y=-10, radius=6, area=113.097336)
Square(id=3, x=-2, y=-5, width=12, area=144.0)

=== Поворот (rotate) против часовой стрелки вокруг точки (0, 0) ===
Rect(id=1, x=15, y=18, width=8, height=4, area=32.0)
Circle(id=2, x=10, y=3, radius=6, area=113.097336)
Square(id=3, x=5, y=-2, width=12, area=144.0)
```
