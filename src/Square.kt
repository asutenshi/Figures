class Square(var x: Int, var y: Int, var width: Int, id: Int = 0) : Movable, Figure(id), Transforming {
    var color: Int = -1
    lateinit var name: String

    constructor(square: Square) : this(square.x, square.y, square.width, square.id)

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (width * width).toFloat()
    }

    override fun resize(zoom: Int) {
        width *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        val dx = x - centerX
        val dy = y - centerY
        when (direction) {
            RotateDirection.Clockwise -> {
                x = centerX + dy
                y = centerY - dx
            }
            RotateDirection.CounterClockwise -> {
                x = centerX - dy
                y = centerY + dx
            }
        }
    }

    override fun toString(): String {
        return "Square(id=$id, x=$x, y=$y, width=$width, area=${area()})"
    }
}