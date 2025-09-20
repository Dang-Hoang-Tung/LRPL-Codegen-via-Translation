fun Grid.addSandAt(point: Point, limit: Int? = null, limitIsFloor: Boolean = false): Boolean {
    if (this[point] != 0) return false
    var x = point.x
    var lastY = (limit ?: maxY) - 1
    for (y in (point.y..lastY)) {
        val nextY = y + 1
        if (this[x,nextY] == 0) continue
        if (this[x-1,nextY] == 0) {
            x=x-1
            continue
        }
        if (this[x+1,nextY] == 0){
            x=x+1
            continue
        }
        this[x,y] = sand
        return true
    }

    if (limitIsFloor) {
        this[x,lastY] = sand
        return true
    }
    return false
}