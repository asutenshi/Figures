class Rect(var x: Int, var y: Int, var width: Int, var height: Int, id: Int = 0) : Movable, Figure(id), Transforming {
    var color: Int = -1
    lateinit var name: String

    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height, rect.id)

    override fun move(dx: Int, dy: Int) {
        x += dx
        y += dy
    }

    override fun area(): Float {
        return (width * height).toFloat()
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
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
        val temp = width
        width = height
        height = temp
    }

    override fun toString(): String {
        return "Rect(id=$id, x=$x, y=$y, width=$width, height=$height, area=${area()})"
    }
}