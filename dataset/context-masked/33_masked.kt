import java.io.File

open class PuzzleInput<T>(val expectedResult: T? = null)
abstract class Puzzle<T, P : PuzzleInput<T>> {
    fun solve(input: P) {
        val solution = solution(input)
        if(input.expectedResult != null) {
            if(solution != input.expectedResult) {
                println("$solution == ${input.expectedResult}")
            }
            check(solution == input.expectedResult)
        }
        else {
            println(solution)
        }
    }

    abstract fun solution(input: P) : T
}

class FileSystemEntry(val name: String, val parent: FileSystemEntry? = null, private var size: Long = 0) {
    val children = mutableListOf<FileSystemEntry>()
    val isDir = size == 0.toLong()
    fun getEntrySize(): Long {
        if(size == 0.toLong() && children.isNotEmpty()) {
            size = children.sumOf { child ->
                child.getEntrySize()
            }
        }
        return size
    }
}

class Day7PuzzleSolution(private val targetDirSize: Long) : Puzzle<Long, Day7PuzzleInput>() {
    override fun solution(input: Day7PuzzleInput): Long {
        return getTotalSizeSmallDirectories(targetDirSize, input.root)
    }

    private fun getTotalSizeSmallDirectories(size: Long, entry: FileSystemEntry): Long {
        val sizeOfSmallChildren = entry.children.sumOf { child ->
            getTotalSizeSmallDirectories(size, child)
        }
        if(entry.isDir && entry.getEntrySize() <= size) {
            return sizeOfSmallChildren + entry.getEntrySize()
        }
        return sizeOfSmallChildren
    }
}

class Day7PuzzleSolutionList(private val targetDirSize: Long) : Puzzle<Long, Day7PuzzleInputList>() {
    override fun solution(input: Day7PuzzleInputList): Long {
        return input.dirQueue.sumOf {dir ->
            if(dir.getEntrySize() <= targetDirSize) {
                dir.getEntrySize()
            }
            else {
                0
            }
        }
    }

}

class Day7Puzzle2Solution : Puzzle<Long, Day7PuzzleInput>() {
    override fun solution(input: Day7PuzzleInput): Long {
        val targetDirSize = 30000000 - (70000000 - input.root.getEntrySize())
        val result = findDirectoryToDelete(targetDirSize, input.root)
        return result?.getEntrySize() ?: error("Did not find a directory")
    }

    private fun findDirectoryToDelete(size: Long, entry: FileSystemEntry): FileSystemEntry? {
        /* GENERATE THIS FUNCTION */
    }
}

class Day7Puzzle2SolutionList : Puzzle<Long, Day7PuzzleInputList>() {
    override fun solution(input: Day7PuzzleInputList): Long {
        val targetDirSize = 30000000 - (70000000 - input.root.getEntrySize())
        var currentBest = input.root
        for (dir in input.dirQueue) {
            if (dir.getEntrySize() < currentBest.getEntrySize() && dir.getEntrySize() > targetDirSize) {
                currentBest = dir
            }
        }
        return currentBest.getEntrySize()
    }
}
