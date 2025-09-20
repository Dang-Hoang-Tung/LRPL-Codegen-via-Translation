tailrec fun sumFiles(filesystem: MutableList<Directory>, children: List<String>, sum: Long): Long {
    var total = sum
    if (children.isEmpty()) return total
    val dirs = children.map { child ->
        filesystem.first { it.name == child }
    }
    dirs.forEach { dir ->
        total += dir.files.sumOf { it.size }
        sumFiles(filesystem, dir.childrenDirectories, total)
    }
    return total
}