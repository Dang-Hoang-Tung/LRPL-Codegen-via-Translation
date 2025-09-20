class Day7PuzzleInput(input: String, expectedResult: Long? = null) : PuzzleInput<Long>(expectedResult) {
    val root: FileSystemEntry = FileSystemEntry("/")

    init {
        val filePattern = "(\\d+) (.*)".toRegex()
        var currentDir = root
        File(input).readLines().forEach { line ->
            if(line.startsWith("$ cd ..")) {
                currentDir = currentDir.parent ?: currentDir
            }
            else if(line.startsWith("$ cd ")) {
                val dir = line.substring("$ cd ".length)
                currentDir = currentDir.children.find { it.name == dir } ?: currentDir
            }
            else if(line.startsWith("dir ")) {
                currentDir.children.add(FileSystemEntry(line.substring("dir ".length), currentDir))
            }
            else if(filePattern.matches(line)) {
                val (size, name) = filePattern.find(line)!!.destructured
                currentDir.children.add(FileSystemEntry(name, currentDir, size.toLong()))
            }
        }
        root.getEntrySize()
    }
}

class Day7PuzzleInputList(input: String, expectedResult: Long? = null) : PuzzleInput<Long>(expectedResult) {
    val root = FileSystemEntry("/")
    val dirQueue = mutableListOf<FileSystemEntry>()

    init {
        val filePattern = "(\\d+) (.*)".toRegex()
        var currentDir = root
        File(input).readLines().forEach { line ->
            if(line.startsWith("$ cd ..")) {
                currentDir = currentDir.parent ?: currentDir
            }
            else if(line.startsWith("$ cd ")) {
                val dir = line.substring("$ cd ".length)
                currentDir = currentDir.children.find { it.name == dir } ?: currentDir
            }
            else if(line.startsWith("dir ")) {
                val dir = FileSystemEntry(line.substring("dir ".length), currentDir)
                currentDir.children.add(dir)
                dirQueue.add(dir)
            }
            else if(filePattern.matches(line)) {
                val (size, name) = filePattern.find(line)!!.destructured
                currentDir.children.add(FileSystemEntry(name, currentDir, size.toLong()))
            }
        }
        root.getEntrySize()
    }
}

fun day7Puzzle() {
    Day7PuzzleSolution(100000).solve(Day7PuzzleInput("inputs/day7/exampleCommands.txt", 95437))
    Day7PuzzleSolution(100000).solve(Day7PuzzleInput("inputs/day7/inputCommands.txt",1428881))
    Day7PuzzleSolutionList(100000).solve(Day7PuzzleInputList("inputs/day7/exampleCommands.txt", 95437))
    Day7PuzzleSolutionList(100000).solve(Day7PuzzleInputList("inputs/day7/inputCommands.txt",1428881))
    Day7Puzzle2Solution().solve(Day7PuzzleInput("inputs/day7/exampleCommands.txt", 24933642))
    Day7Puzzle2Solution().solve(Day7PuzzleInput("inputs/day7/inputCommands.txt", 10475598))
    Day7Puzzle2SolutionList().solve(Day7PuzzleInputList("inputs/day7/exampleCommands.txt", 24933642))
    Day7Puzzle2SolutionList().solve(Day7PuzzleInputList("inputs/day7/inputCommands.txt", 10475598))
}
