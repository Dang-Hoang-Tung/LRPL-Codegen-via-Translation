fun part2(input: Input): Int {
    val (xRange, yRange) = input.toList().map { it.first..it.second }
    require(xRange.first > 0 && xRange.last >= xRange.first)
    require(yRange.last < 0 && yRange.last >= yRange.first)
    var answer = 0
    for (xv in 1..xRange.last) {
        for (yv in yRange.first..yRange.first.absoluteValue) {
            var (cx, cy) = 0 to 0
            var (cxv, cyv) = xv to yv
            while (true) {
                cx += cxv.also { cxv -= cxv.sign }
                cy += cyv--
                if (cx in xRange && cy in yRange) {
                    answer++
                    break
                }
                if (cx > xRange.last || cy < yRange.first) break
            }
        }
    }
    return answer
}